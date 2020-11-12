package classes;
import java.sql.*;

public class Conexao {
	
	static String status="";
	
	public static Connection getConnection() {
		
		Connection conex=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost/Control?user=root&password=12345678";
			conex = DriverManager.getConnection(url);
			status = "connection opened";
		}catch (SQLException e) {
			status = e.getMessage();
		}catch (ClassNotFoundException e) {
			status = e.getMessage();
		}catch (Exception e) {
			status = e.getMessage();
		}
		return conex;
		}
}
	