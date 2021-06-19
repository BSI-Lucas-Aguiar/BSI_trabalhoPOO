package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBD {

	public static void iniciarBD() throws SQLException {
		final String url = "jdbc:mysql://localhost:3306";
		final String usuario = "root"; 
		final String senha = "1234"; //Utilize sua senha root do MySQL aqui para rodar a criação do BD
		
		Connection conexao = DriverManager
				.getConnection(url, usuario, senha);
		
		System.out.println("Conexão efetuada com sucesso!");
		
		Statement criarBD = conexao.createStatement();
		//Criar o Banco de Dados
		criarBD.execute("CREATE DATABASE IF NOT EXISTS estaleiro_naval;");
		System.out.println("Banco de Dados estaleiro_naval Criado.");
		//Utilizar o Banco de dados
		criarBD.execute("USE estaleiro_naval;");
		System.out.println("Utilizando estaleiro_Naval...");
		//Criar tabela lancha
		criarBD.execute("CREATE TABLE IF NOT EXISTS lancha(codigoProjeto varchar(255), quantidadeMaterial int, materialUtilizado int, vendido boolean, valorEmbarcacao double, nomeLancha varchar(255));");
		System.out.println("Tabela lancha criada!");
		//Criar tabela estoque
		criarBD.execute("CREATE TABLE IF NOT EXISTS estoque(estoqueMaterial int);");
		System.out.println("Tabela estoque criada!");
		//Criar tabela compra
		criarBD.execute("CREATE TABLE IF NOT EXISTS compra(nomeMaterial varchar(255), precoMaterial double);");
		System.out.println("Tabela compra criada!");
		//Criar tabela caixa
		criarBD.execute("CREATE TABLE IF NOT EXISTS caixa(totalCaixa double);");
		System.out.println("Tabela caixa criada!");
		//Criar tabela funcionarios
		criarBD.execute("CREATE TABLE IF NOT EXISTS funcionario(nome varchar(255), cargo varchar(255), projetoAtual varchar(255));");
		System.out.println("Tabela funcionarios criada!");
		
		conexao.close();
		System.out.println("Conexão finalizada!");
	}

}
