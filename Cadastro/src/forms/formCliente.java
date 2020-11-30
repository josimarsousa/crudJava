package forms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	
		

}
	
	
	

