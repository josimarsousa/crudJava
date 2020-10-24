package classes;

import forms.formCliente;
import forms.formFornecedor;

public class Master {

	public static void main(String[] args) {
		
		formCliente cliente = new formCliente();
		formFornecedor fornecedor = new formFornecedor();
		
		cliente.setVisible(true);
		cliente.setLocationRelativeTo(null);
		fornecedor.setVisible(true);
		fornecedor.setLocationRelativeTo(null);
	}

}
