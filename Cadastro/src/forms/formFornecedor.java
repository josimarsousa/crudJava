package forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import classes.Fornecedores;
import classes.ConexaoBD;

public class formFornecedor extends JFrame{
	
	JLabel jlcodFor, jlnomeFor, jlenderecoFor, jlcnpjFor, jlfoneFor;
	JTextField jtcodFor, jtnomeFor, jtenderecoFor, jtcnpjFor, jtfoneFor;
	JButton jblimpar, jbsalvar, jbsair;
	
	private Connection conexaoFornecedores;
	
	public formFornecedor() throws SQLException {
		
		this.conexaoFornecedores = ConexaoBD.getConnection();
		
		setTitle("Cadastro de Fornecedores");
		setSize(550,450);	
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		jlcodFor = new JLabel("Código:");
		jtcodFor = new JTextField("");
		jlnomeFor = new JLabel("Nome:");
		jtnomeFor = new JTextField("");
		jlenderecoFor = new JLabel("Endereço");
		jtenderecoFor = new JTextField("");
		jlcnpjFor = new JLabel("CNPJ:");
		jtcnpjFor = new JTextField("");
		jlfoneFor = new JLabel("Fone:");
		jtfoneFor = new JTextField("");
		jblimpar = new JButton("Limpar");
		jbsalvar = new JButton("Salvar");
		jbsair = new JButton("Sair");
		
		getContentPane().setLayout(null);
		
		getContentPane().add(jlcodFor);
		getContentPane().add(jtcodFor);
		getContentPane().add(jlnomeFor);
		getContentPane().add(jtnomeFor);
		getContentPane().add(jlenderecoFor);
		getContentPane().add(jtenderecoFor);
		getContentPane().add(jlcnpjFor);
		getContentPane().add(jtcnpjFor);
		getContentPane().add(jlfoneFor);
		getContentPane().add(jtfoneFor);
		getContentPane().add(jblimpar);
		getContentPane().add(jbsalvar);
		getContentPane().add(jbsair);
		
		jlcodFor.setBounds(20,20,100,15);
		jtcodFor.setBounds(20, 40, 80, 25);
		jlnomeFor.setBounds(115,20,100,15);
		jtnomeFor.setBounds(115,40,300,25);
		jlenderecoFor.setBounds(20,70,100,15);
		jtenderecoFor.setBounds(20,90,300,25);
		jlfoneFor.setBounds(20,120,300,15);
		jtfoneFor.setBounds(20,140,120,25);
		jlcnpjFor.setBounds(280,120,150,15);
		jtcnpjFor.setBounds(280,140,200,25);
		jblimpar.setBounds(20,340,90,30);
		jbsalvar.setBounds(115,340,90,30);
		jbsair.setBounds(430,340,90,30);
		
		jbsalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbsalvar);
				
				Fornecedores fornecedor = new Fornecedores();
				fornecedor.setNomeFornecedor(jtnomeFor.getText());
				fornecedor.setEnderecoFornecedor(jtenderecoFor.getText());
				fornecedor.setCnpjFornecedor(jtcnpjFor.getText());
				fornecedor.setFoneFornecedor(jtfoneFor.getText());
				
				try {
					adicionaFornecedores(fornecedor);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
	}
	
	public void adicionaFornecedores(Fornecedores fornecedor) throws SQLException {
		
		String sql = "insert into Fornecedores (nomeFornecedor, enderecoFornecedor, cnpjFornecedor, foneFornecedor)" +
					"values ( ?, ?, ?, ?)";
		
			PreparedStatement stmt = conexaoFornecedores.prepareStatement(sql);
		
			
			stmt.setString(1, fornecedor.getNomeFornecedor());
			stmt.setString(2, fornecedor.getEnderecoFornecedor());
			stmt.setString(3, fornecedor.getCnpjFornecedor());
			stmt.setString(4, fornecedor.getFoneFornecedor());
			
			stmt.execute();
			stmt.close();
					
	}
		

}