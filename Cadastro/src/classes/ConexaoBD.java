package classes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import classes.Clientes;

import javax.swing.JOptionPane;



public class ConexaoBD {
	
	//static String status="";
	private int setaCodigo;	
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
	
		public void inserirCliente(Clientes c) {
			if(c != null) {
				Connection conn = null;
				try {
					conn = ConexaoBD.getConnection();
					PreparedStatement stmt;
					stmt = conn.prepareStatement("INSERT INTO Clientes(nomeCliente, enderecoCliente, foneCliente, cpfCliente)values(?, ?, ?, ?)");
					
					stmt.setString(1, c.getNomeCliente());
					stmt.setString(2, c.getEndCliente());
					stmt.setString(3, c.getFoneCliente());
					stmt.setString(4, c.getCpfCliente());
					
					stmt.execute();
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso! ");
					conn.close();
					stmt.close();
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente no banco de dados." + e.getMessage());
				}
			}else {
				System.out.println("O cliente enviado por parâmetro está vazio.");
			}
		}
	
		public List<Clientes> getClientes () throws SQLException{
			
			
			Connection conn = null;
			
			conn = ConexaoBD.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT codCliente, nomeCliente, enderecoCliente, foneCliente, cpfCliente FROM Clientes");
			
			ArrayList<Clientes> clientes = new ArrayList<Clientes>();
			try {
				while (rs.next()) {
					Clientes cliente = new Clientes();
							
					cliente.setCodigoCliente(rs.getInt("codCliente"));
					cliente.setNomeCliente(rs.getString("nomeCliente"));
					cliente.setEndCliente(rs.getString("enderecoCliente"));
					cliente.setFoneCliente(rs.getString("foneCliente"));
					cliente.setCpfCliente(rs.getString("cpfCliente"));
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
		
		public Clientes getClienteByCod(int cod) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Clientes cliente = new Clientes();
			try {
				String sql = "SELECT * FROM Clientes WHERE codCliente=?";
				conn = ConexaoBD.getConnection();
				stmt = conn.prepareStatement(sql);
			    stmt.setInt(1, cod);
			    rs = stmt.executeQuery();
				while(rs.next()) {
					cliente.setCodigoCliente(rs.getInt("codCliente"));
					cliente.setNomeCliente(rs.getString("nomeCliente"));
					cliente.setEndCliente(rs.getString("enderecoCliente"));
					cliente.setFoneCliente(rs.getString("foneCliente"));
					cliente.setCpfCliente(rs.getString("cpfCliente"));
				}
				conn.close();
				stmt.close();
				rs.close();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao listar os clientes" + e.getMessage());
			}
			return cliente;
		}

			
}
	