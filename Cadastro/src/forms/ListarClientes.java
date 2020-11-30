package forms;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListarClientes extends JFrame{
	
	JPanel painelFundo;
	JTable tabela;
	JScrollPane barraRolagem;
	
	Object [][] dados ={
		{"1", "josimar", "papagaio", "9984039800", "05586265648"}
		
	};
	
	
	String[] colunas = {"Codigo", "Nome", "Endereço", "Telefone", "Cpf"};

	public ListarClientes() {
		
		super("Clientes");
		
	}
	
	public void criaJanela(){

        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        tabela = new JTable(dados, colunas);
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem);

        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 120);
        setVisible(true);
    }

}
	

