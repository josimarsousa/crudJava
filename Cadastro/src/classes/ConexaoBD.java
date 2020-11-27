package classes;
import java.sql.*;

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
	
}
	