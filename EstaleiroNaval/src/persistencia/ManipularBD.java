package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ManipularBD {
	
	//Fun��es do Caixa
	public static void consultarTotal() throws SQLException {
		//Altere os dados da conex�o SQL na Classe DadosMYSQL no pacote Persistencia
		String url = DadosMYSQL.getUrl();
		String usuario = DadosMYSQL.getUsuario(); 
		String senha = DadosMYSQL.getSenha(); 
		
		Connection conexao = DriverManager
				.getConnection(url, usuario, senha);
		System.out.println("Conex�o Caixa!");
		//C�digo
		
		double total = 10000;
		JOptionPane.showMessageDialog (null, "Total em caixa: "+" "+ total);
		
		
		conexao.close();
		System.out.println("Conex�o Caixa finalizada!");
		
		
		
		
	}
	
	/*
	 * 
	 	String url = DadosMYSQL.getUrl();
		String usuario = DadosMYSQL.getUsuario(); 
		String senha = DadosMYSQL.getSenha(); 
		
		Connection conexao = DriverManager
				.getConnection(url, usuario, senha);
		System.out.println("Conex�o efetuada com sucesso!");
		//C�digo
		conexao.close();
		System.out.println("Conex�o finalizada!");
	 * 
	 */
	
}
