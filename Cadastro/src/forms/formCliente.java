package forms;

/*package forms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.Clientes;
import classes.ConexaoBD;

public class formCliente extends JFrame{
	
	JLabel jlcod, jlnome, jlendereco, jlfone, jlcpf;
	JTextField jtcod, jtnome, jtendereco, jtfone, jtcpf;
	
	JButton jblimpar, jbsalvar, jbsair;
	
	private Connection conexaoCliente;
	
	public formCliente()  throws SQLException{
		
		this.conexaoCliente = ConexaoBD.getConnection();
		
		setTitle("Cadastro de Clientes");
		setSize(550, 450);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		jlcod = new JLabel("Código:");
		jtcod = new JTextField("");
		jlnome= new JLabel("Nome:");
		jtnome = new JTextField("");
		jlendereco = new JLabel("Endereço:");
		jtendereco= new JTextField("");
		jlfone= new JLabel("Fone:");
		jtfone= new JTextField("");
		jlcpf = new JLabel("Cpf:");
		jtcpf= new JTextField("");
		jblimpar = new JButton("Limpar");
		jbsalvar = new JButton("Salvar");
		jbsair = new JButton("Sair");
		
		getContentPane().setLayout(null);
		
		
		getContentPane().add(jlcod);
		getContentPane().add(jtcod);
		getContentPane().add(jlnome);
		getContentPane().add(jtnome);
		getContentPane().add(jlendereco);
		getContentPane().add(jtendereco);
		getContentPane().add(jlfone);
		getContentPane().add(jtfone);
		getContentPane().add(jlcpf);
		getContentPane().add(jtcpf);
		getContentPane().add(jblimpar);
		getContentPane().add(jbsalvar);
		getContentPane().add(jbsair);
		
		jlcod.setBounds(20,20,100,15);
		jtcod.setBounds(20, 40, 80, 25);
		jlnome.setBounds(115,20,100,15);
		jtnome.setBounds(115,40,300,25);
		jlendereco.setBounds(20,70,100,15);
		jtendereco.setBounds(20,90,300,25);
		jlfone.setBounds(20,120,300,15);
		jtfone.setBounds(20,140,120,25);
		jlcpf.setBounds(280,120,150,15);
		jtcpf.setBounds(280,140,200,25);
		jblimpar.setBounds(20,340,90,30);
		jbsalvar.setBounds(115,340,90,30);
		jbsair.setBounds(430,340,90,30);
		
		
		
		jbsalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbsalvar);
				
				Clientes cliente = new Clientes();
				cliente.setNomeCliente(jtnome.getText());
				cliente.setEndCliente(jtendereco.getText());
				cliente.setFoneCliente(jtfone.getText());
				cliente.setCpfCliente(jtcpf.getText());
				
				try {
					adicionaClientes(cliente);
					JOptionPane.showMessageDialog(null, jtnome.getText() + " foi incluido com sucesso!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	
	}
	
	public void adicionaClientes(Clientes cliente) throws SQLException {
		
		String sql = "insert into Clientes (nomeCliente, enderecoCliente, foneCliente, cpfCliente)" +
					"values ( ?, ?, ?, ?)";
		
			PreparedStatement stmt = conexaoCliente.prepareStatement(sql);
		
			
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getEndCliente());
			stmt.setString(3, cliente.getFoneCliente());
			stmt.setString(4, cliente.getCpfCliente());
			
			stmt.execute();
			stmt.close();
					
	}
	
		

}*/
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Clientes;

import classes.ConexaoBD;

public class formCliente extends JFrame{
	
	private JPanel pFundo;
	private JPanel pBotoes;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JButton jbInserir;
	private JButton jbEditar;
	private JButton jbExcluir;
	private DefaultTableModel modelo = new DefaultTableModel();
	
	public formCliente() throws SQLException {
		super("Clientes");
		criaJTable();
		criaJanela();
		
	}
	
	public void criaJanela() {
		jbInserir = new JButton("Cadastrar");
		jbEditar = new JButton("Atualizar");
		jbExcluir = new JButton("Remover");
		
		pBotoes = new JPanel();
		pFundo = new JPanel();
		
		barraRolagem = new JScrollPane(tabela);
		
		pBotoes.add(jbInserir);
		pBotoes.add(jbEditar);
		pBotoes.add(jbExcluir);
		
		pFundo.setLayout(new BorderLayout());
		pFundo.add(BorderLayout.CENTER, barraRolagem);
		pFundo.add(BorderLayout.SOUTH, pBotoes);
		
		getContentPane().add(pFundo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,230);
		setVisible(true);
		jbInserir.addActionListener(new jbInserirListener());
		jbEditar.addActionListener(new jbEditarListener());
		jbExcluir.addActionListener(new jbExcluirListener());
				
	}
	
		private void criaJTable() throws SQLException {
			
			tabela = new JTable(modelo);
			modelo.addColumn("Codigo");
			modelo.addColumn("Nome");
			modelo.addColumn("Endereço");
			modelo.addColumn("Fone");
			modelo.addColumn("Cpf");
			
			tabela.getColumnModel().getColumn(0)
			.setPreferredWidth(20);
			tabela.getColumnModel().getColumn(1)
			.setPreferredWidth(120);
			tabela.getColumnModel().getColumn(1)
			.setPreferredWidth(120);
			tabela.getColumnModel().getColumn(1)
			.setPreferredWidth(120);
			tabela.getColumnModel().getColumn(1)
			.setPreferredWidth(120);
			pesquisar(modelo);
			
		}
		
		public static void pesquisar(DefaultTableModel modelo) throws SQLException {
			modelo.setNumRows(0);
			ConexaoBD conex = new ConexaoBD();
			
			for (Clientes c : conex.getClientes()) {
				modelo.addRow(new Object[]{c.getCodCliente(), c.getNomeCliente(), c.getEndCliente(),
					c.getFoneCliente(), c.getCpfCliente()});
				}
			}
		private class jbInserirListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				formInserirCliente ic = new formInserirCliente(modelo);
				ic.setVisible(true);
			}
		}
		
		private class jbEditarListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				int setaLinha = -1;
				setaLinha = tabela.getSelectedRow();
					if(setaLinha >= 0) {
						int codCliente = (int)tabela.getValueAt(setaLinha, 0);
						formUpdateCliente upcli = new formUpdateCliente(modelo, codCliente, setaLinha);
						upcli.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Primeiro, selecione uma linha de cliente!");
					}
			}
			
		}
		
		private class jbExcluirListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				int setaLinha = -1;
				setaLinha = tabela.getSelectedRow();
				if(setaLinha >= 0) {
					int codcliente = (int)tabela.getValueAt(setaLinha, 0);
					ConexaoBD cli = new ConexaoBD();
					try {
						cli.remover(codcliente);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					modelo.removeRow(setaLinha);
				}else {
					JOptionPane.showMessageDialog(null, "Primeiro, selecione uma linha de cliente!");
				}
			}
		}
}
	
	

