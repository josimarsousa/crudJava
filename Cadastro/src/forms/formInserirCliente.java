package forms;

import classes.Clientes;
import classes.ConexaoBD;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class formInserirCliente  extends JFrame {

		private DefaultTableModel modelo = new DefaultTableModel();
		
		private JPanel pFundo;
		private JButton jbSalvar;
		private JButton jbLimpar;
		private JLabel jlNome;
		private JLabel jlEndereco;
		private JLabel jlFone;
		private JLabel jlCpf;
		
		private JTextField txtNome;
		private JTextField txtEndereco;
		private JTextField txtFone;
		private JTextField txtCpf;
		
		public formInserirCliente(DefaultTableModel md) {
			super("Clientes");
			criaJanela();
			modelo = md;
			
		}
		
		public void criaJanela() {
		    jbSalvar = new JButton("Salvar");
			jbLimpar = new JButton("Limpar");
			jlNome = new JLabel("Nome: ");
			jlEndereco = new JLabel("Endereco: ");
			jlFone = new JLabel("Fone: ");
			jlCpf = new JLabel("Cpf: ");
			
			JTextField jtNome = new JTextField(10);
			JTextField jtEndereco = new JTextField();
			JTextField jtFone = new JTextField();
			JTextField jtCpf = new JTextField();
			
			JPanel pFundo = new JPanel();
			pFundo.setLayout(new GridLayout(4,2,2,4));
			pFundo.add(jlNome);
			pFundo.add(jtNome);
			pFundo.add(jlEndereco);
			pFundo.add(jtEndereco);
			pFundo.add(jlFone);
			pFundo.add(jtFone);
			pFundo.add(jlCpf);
			pFundo.add(jtCpf);
			pFundo.add(jbSalvar);
			pFundo.add(jbLimpar);
			
			getContentPane().add(pFundo);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setSize(300,150);
			setVisible(true);
			jbSalvar.addActionListener(new jbSalvarListener());
			jbLimpar.addActionListener(new jbLimparListener());
			
		}
		
		private class jbSalvarListener implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
				Clientes c = new Clientes();
				c.setNomeCliente(txtNome.getText());
				c.setEndCliente(txtEndereco.getText());
				c.setFoneCliente(txtFone.getText());
				c.setCpfCliente(txtCpf.getText());
				
				ConexaoBD conn = new ConexaoBD();
				conn.inserirCliente(c);
				try {
					formCliente.pesquisar(modelo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		}
		
		private class jbLimparListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtEndereco.setText("");
				txtFone.setText("");
				txtCpf.setText("");
			}
		}
		
}
