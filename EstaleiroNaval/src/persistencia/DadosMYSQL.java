package persistencia;

public class DadosMYSQL {
	final static String url = "jdbc:mysql://localhost:3306";
	final static String usuario = "root"; 
	final static String senha = "1234";
	
	public static String getUrl() {
		return url;
	}
	public static String getUsuario() {
		return usuario;
	}
	public static String getSenha() {
		return senha;
	}
	
	
}
