package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ManipularBD {
	
	//Funções do Caixa
	public static void consultarTotal() throws SQLException {
		//Altere os dados da conexão SQL na Classe DadosMYSQL no pacote Persistencia
		String url = DadosMYSQL.getUrl();
		String usuario = DadosMYSQL.getUsuario(); 
		String senha = DadosMYSQL.getSenha(); 
		
		Connection conexao = DriverManager
				.getConnection(url, usuario, senha);
		System.out.println("Conexão Caixa!");
		//Código
		
		double total = 10000;
		JOptionPane.showMessageDialog (null, "Total em caixa: "+" "+ total);
		
		
		conexao.close();
		System.out.println("Conexão Caixa finalizada!");
		
		
		
		
	}
	
	/*
	 * 
	 	String url = DadosMYSQL.getUrl();
		String usuario = DadosMYSQL.getUsuario(); 
		String senha = DadosMYSQL.getSenha(); 
		
		Connection conexao = DriverManager
				.getConnection(url, usuario, senha);
		System.out.println("Conexão efetuada com sucesso!");
		//Código
		conexao.close();
		System.out.println("Conexão finalizada!");
	 * 
	 */
	
}
