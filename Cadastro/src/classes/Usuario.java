package classes;

public class Usuario {
	
	private int userCodigo;
	private String userName;
	private String userSenha;
	private String userNivel;
	
	
	public String getUserName() {
		return userName;
	}
	
	public String getUserSenha() {
		return userSenha;
	}
	
	public int getUserCodigo() {
		return userCodigo;
	}
	
	public String getUserNivel() {
		return userNivel;
	}
	
		
	public void setUserNivel(String nivel) {
		this.userNivel = nivel;
	}
	
	

}
