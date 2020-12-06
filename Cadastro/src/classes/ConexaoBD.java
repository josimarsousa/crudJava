package classes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import classes.Clientes;

import javax.swing.JOptionPane;



public class ConexaoBD {
	
	//static String status="";
		
	public static Connection getConnection() throws SQLException {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/Control?user=root&password=";
			conn = DriverManager.getConnection(url);
			//System.out.println("Conectado ao banco.");
			System.out.println();
			
			/*Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT codCliente, nomeCliente, enderecoCliente, foneCliente, cpfCliente FROM Clientes");
			
			while(rs.next()) {
				System.out.println("Código: " + rs.getInt("codCliente"));
				System.out.println("Nome: " + rs.getString("nomeCliente"));
				System.out.println("Endereço: " + rs.getString("enderecoCliente"));
				System.out.println("fone: " + rs.getString("foneCliente"));
				System.out.println("CPF: " + rs.getString("cpfCliente"));
				System.out.println();
				
			}*/
						
	    } 
		catch (ClassNotFoundException e) {
	    	throw new SQLException(e.getMessage());
	    }
		return conn;
		
	}
	
		public List<Clientes> getClientes () throws SQLException{
			
			Connection conn = null;
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT codCliente, nomeCliente, enderecoCliente, foneCliente, cpfCliente FROM Clientes");
			
			ArrayList<Clientes> clientes = new ArrayList<Clientes>();
			try {
				while (rs.next()) {
					Clientes cliente = new Clientes();
					
					cliente.setNomeCliente(rs.getString("Nome"));
					cliente.setEndCliente(rs.getString("Endereco"));
					cliente.setFoneCliente(rs.getString("Fone"));
					cliente.setCpfCliente(rs.getString("Cpf"));
					clientes.add(cliente);
				}
				conn.close();
				stmt.close();
				rs.close();
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Erro ao listar os clientes" + e.getMessage());
			}
			return clientes;
			
		}
		
		public void remover(int codcliente) throws SQLException {
			
			Connection conn = null;
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("DELETE FROM CLIENTES WHERE codCliente =?");
			
			try {
				
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao excluir contato do banco de dados " + e.getMessage());
			}
		}
		
		public void updateCliente(Clientes cliente) {
			if(cliente != null) {
				Connection conn = null;
				try {
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("UPDATE CLIENTES SET nomeCliente=?, enderecoCliente=?, foneCliente=?, cpfCliente=? WHERE codCliente =?");
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados do cliente no banco de dados" + e.getMessage());
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "O contato enviado por parâmetro está vazio");
			}
		}
	
}
	