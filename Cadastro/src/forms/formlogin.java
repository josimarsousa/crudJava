package forms;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class formlogin extends JFrame {

	JLabel jllogName, jllogSenha;
	JTextField jtlogName, jtlogSenha;
	JButton jblogUser, jblogSair;
	
	public formlogin() {
		
		setTitle("Login");
		setSize(300, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		jllogName = new JLabel("Usuário:");
		jtlogName = new JTextField("");
		jllogSenha = new JLabel("Senha:");
		jtlogSenha = new JTextField("");
		jblogUser = new JButton("Entrar");
		jblogSair = new JButton("Sair");
		
		getContentPane().setLayout(null);
		
		getContentPane().add(jllogName);
		getContentPane().add(jtlogName);
		getContentPane().add(jllogSenha);
		getContentPane().add(jtlogSenha);
		getContentPane().add(jblogUser);
		getContentPane().add(jblogSair);
		
		jllogName.setBounds(35,20,90,15);
		jtlogName.setBounds(100,15,150,25);
		jllogSenha.setBounds(45,60,90,15);
		jtlogSenha.setBounds(100,55,150,25);
		jblogUser.setBounds(65,110,90,25);
		jblogSair.setBounds(160,110,90,25);
		
	}
	
	
}
