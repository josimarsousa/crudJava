package Classes;
import java.sql.*;

public class Conexao {
	
	static String status="";
	
	public static Connection getConnection() {
		
		Connection conex=null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url ="jdbc:mysql://localhost/Control?user=root&password=";
			conex = DriverManager.getConnection(url);
			status = "Conexao ao banco de dados OK";
		}catch (SQLException e) {
			status = "erro na conexao 1";//e.getMessage();
		}catch (ClassNotFoundException e) {
			status = "erro na conexao 2";//e.getMessage();
		}catch (Exception e) {
			status = "erro na conexao 3";//e.getMessage();
		}
		return conex;
		}
}
	


