package Classes;
import java.sql.*;

public class Conexao {
	
	static String status="";
	
	public static Connection getConnection() {
		
		Connection conex = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/Control?user=root&password=jose8403*";
			conex = DriverManager.getConnection(url);
			status = "Conectado ao Banco de Dados.";
		}
		catch(SQLException e) {
			status = e.getMessage();
		}catch(ClassNotFoundException e) {
			status = e.getMessage();
		}catch(Exception e) {
			status = e.getMessage();
		}return conex;
		/*String JdbcUrl = "jdbc:mysql://localhost:3306/Control?" + "autoReconnect=true&useSSL=false";
		String userName = "root";
		String password = "12345678";
		Connection conex = null;
		try {
			conex = DriverManager.getConnection(JdbcUrl, userName, password);
			status = "connection opened";
		}catch (SQLException e) {
			status = "erro na conexao 1";//e.getMessage();
		}catch (Exception e) {
			status = "erro na conexao com o banco";//e.getMessage();
		}
		return conex;*/
		}
}
	


