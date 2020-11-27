package classes;

import forms.formCliente;

public class Master{
	
public static void main(String[] args) {
	
	formCliente cliente = new formCliente();
	
	Conexao.getConnection();
	System.out.println(Conexao.status);
	
	cliente.setVisible(true);

	
	}

	
}
