package forms;
import classes.Clientes;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import classes.Clientes;
import classes.ConexaoBD;

public class formUpdateCliente extends JFrame {
	
	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel pFundo;
	private JButton jbSalvar;
	private JButton jbLimpar;
	private JLabel lbNome;
	private JLabel lbEndereco;
	private JLabel lbFone;
	private JLabel lbCpf;
	private JLabel lbCodigo;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtFone;
	private JTextField txtCpf;
	private JTextField txtCodigo;
	Clientes cliente;
	private int setaLinha;
	
	public formUpdateCliente(DefaultTableModel md, int codcliente, int linha) {
		super("Clientes");
		criaJanela();
		modelo = md;
		
		ConexaoBD conn = new ConexaoBD();
		cliente = conn.getClienteByCod(codcliente);
		
		
		txtCodigo.setText(Integer.toString(cliente.getCodCliente()));
		txtNome.setText(cliente.getNomeCliente());
		txtEndereco.setText(cliente.getEndCliente());
		txtFone.setText(cliente.getFoneCliente());
		txtCpf.setText(cliente.getCpfCliente());
		
		setaLinha = linha;
		
	}
	
	public void criaJanela() {
		jbSalvar = new JButton("Salvar");
		jbLimpar = new JButton("Limpar");
		JLabel jlCodigo = new JLabel("Codigo");
		JLabel jlNome = new JLabel("Nome");
		JLabel jlEndereco = new JLabel("Endereco");
		JLabel jlFone = new JLabel("Fone");
		JLabel jlCpf = new JLabel("Cpf");
		
		JTextField txCodigo = new JTextField();
		JTextField txNome = new JTextField();
		JTextField txEndereco = new JTextField();
		JTextField txFone = new JTextField();
		JTextField txCpf = new JTextField();
		
		txCodigo.setEditable(false);
		
		JPanel pFundo = new JPanel();
		
		pFundo.setLayout(new GridLayout(5,2,2,4));
		pFundo.add(jlCodigo);
		pFundo.add(txCodigo);
		pFundo.add(jlNome);
		pFundo.add(txNome);
		pFundo.add(jlEndereco);
		pFundo.add(txEndereco);
		pFundo.add(jlFone);
		pFundo.add(txFone);
		pFundo.add(jlCpf);
		pFundo.add(txCpf);
		
		pFundo.add(jbSalvar);
		pFundo.add(jbLimpar);
		
		getContentPane().add(pFundo);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setSize(300,150);
		setVisible(true);
		
		jbSalvar.addActionListener(new
		formUpdateCliente.jbSalvarListener()); 
		jbLimpar.addActionListener(new
		formUpdateCliente.jbLimparListener());
		
		
	}
	
		private class jbSalvarListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				Clientes c = new Clientes();
				
				c.setNomeCliente(txtNome.getText());
				c.setEndCliente(txtEndereco.getText());
				c.setFoneCliente(txtFone.getText());
				c.setCpfCliente(txtCpf.getText());
				
				ConexaoBD conn = new ConexaoBD();
				conn.updateCliente(c);
				modelo.removeRow(setaLinha);
				modelo.addRow(new Object[] {c.getCodCliente(),
						c.getNomeCliente(), c.getEndCliente(), c.getFoneCliente(), c.getCpfCliente()
				});
				setVisible(false);
				
			}
		}
		
		private class jbLimparListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				txtNome.setText("");
				txtEndereco.setText("");
				txtFone.setText("");
				txtCpf.setText("");
				
			}
		}
	
	
}
