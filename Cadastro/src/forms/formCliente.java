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
		
		getContentPane().setLayout(null);
		
		
		getContentPane().add(jlcod);
		getContentPane().add(jtcod);
		getContentPane().add(jlnome);
		getContentPane().add(jtnome);
		getContentPane().add(jlendereco);
		getContentPane().add(jtendereco);
		getContentPane().add(jlfone);
		getContentPane().add(jtfone);
		getContentPane().add(jlcpf);
		getContentPane().add(jtcpf);
		
		jlcod.setBounds(20,20,100,15);
		jtcod.setBounds(20, 40, 80, 25);
		jlnome.setBounds(115,20,100,15);
		jtnome.setBounds(115,40,300,25);
		jlendereco.setBounds(20,70,100,15);
		jtendereco.setBounds(20,90,300,25);
		jlfone.setBounds(20,120,300,15);
		jtfone.setBounds(20,140,120,25);
		jlcpf.setBounds(280,120,150,15);
		jtcpf.setBounds(280,140,200,25);
			
	}
	
	public static void main (String args[]) {
			new formCliente().setVisible(true);
		}
}
