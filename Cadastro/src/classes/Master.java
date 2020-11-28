package classes;

import java.sql.Connection;
import java.sql.SQLException;

import forms.formCliente;

public class Master{
	
public static void main(String[] args) throws SQLException {
	formCliente cliente = new formCliente();
	//Conexao.getConnection();
	//System.out.println(Conexao.status);
	
	Connection conexao = new ConexaoBD().getConnection();
	System.out.println("Conexao on");
	System.out.println();
	cliente.setVisible(true);
	
	

	
		
	}

	
}
