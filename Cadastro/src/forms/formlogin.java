package forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class formlogin extends JFrame {

	private JLabel jllogName, jllogSenha;
	private JTextField jtlogName, jtlogSenha;
	private JButton jblogUser, jblogSair;
	
			
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
		
		
		jblogUser.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jblogUser);
				String mensagem = jtlogName.getText();
				System.out.println(mensagem);
		
		}});
		
		jblogSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jblogSair);	
				System.exit(EXIT_ON_CLOSE);
				
			}
			
		});	
	}
}
