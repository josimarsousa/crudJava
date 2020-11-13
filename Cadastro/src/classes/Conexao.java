package classes;
import java.sql.*;

public class Conexao {
	
	static String status="";
		
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost/mysql?user=root&password=";
			conn = DriverManager.getConnection(url);
			System.out.println("Conectado ao banco.");
	    } 
		catch (SQLException e) {
	        status = e.getMessage();
	    }catch (ClassNotFoundException e) {
	    	status = e.getMessage();
	    }catch(Exception e) {
	    	status = e.getMessage();
	    }
		return conn;
	}	
}
	