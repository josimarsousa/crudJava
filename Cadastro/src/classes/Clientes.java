package classes;


public class Clientes{
	
	private int codCliente;
	private String nomeCliente;
	private String enderecoCliente;
	private String foneCliente;
	private String cpfCliente;
	
	public Clientes() {
		
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getEndCliente() {
		return enderecoCliente;
	}
	
	public void setEndCliente(String endCliente) {
		this.enderecoCliente = endCliente;
	}
	
	public String getFoneCliente() {
		return foneCliente;
	}
	
	public void setFoneCliente(String foneCliente) {
		this.foneCliente = foneCliente;
	}
	
	public String getCpfCliente() {
		return cpfCliente;
	}
	
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	public void setCodigoCliente(int codcliente) {
		this.codCliente = codcliente;
	}
	
	public int getCodCliente() {
		return codCliente;
	}
	
	

}
