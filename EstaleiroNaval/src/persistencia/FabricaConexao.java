package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	
	public static Connection getConexao() throws SQLException {
	//Alterar credenciais para uso do banco de dados;
		String url = "jdbc:mysql://localhost:3306";
		String usuario = "root"; 
		String senha = "1234"; 

		System.out.println("Conexão com o BD efetuada!");
		return DriverManager.getConnection(url, usuario, senha);
	
	}
	
}
