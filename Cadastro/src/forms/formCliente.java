package forms;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class formCliente extends JFrame{

	JLabel jlcod, jlnome, jlendereco, jlfone, jlcpf;
	JTextField jtcod, jtnome, jtendereco, jtfone, jtcpf;
	
	JButton jblimpar, jbsalvar, jbsair;
	
	public formCliente() {
		setTitle("Cadastro de Clientes");
		setSize(550, 450);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		jlcod = new JLabel("Código:");
		jtcod = new JTextField("");
		jlnome= new JLabel("Nome:");
		jtnome = new JTextField("");
		jlendereco = new JLabel("Endereço:");
		jtendereco= new JTextField("");
		jlfone= new JLabel("Fone:");
		jtfone= new JTextField("");
		jlcpf = new JLabel("Cpf:");
		jtcpf= new JTextField("");
		
	}
}
