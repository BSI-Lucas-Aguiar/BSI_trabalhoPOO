package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBD {

	public static void iniciarBD() throws SQLException {
		//Altere os dados do SQL na Classe DadosMYSQL no pacote Persistencia
		String url = DadosMYSQL.getUrl();
		String usuario = DadosMYSQL.getUsuario(); 
		String senha = DadosMYSQL.getSenha(); 
		
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
		criarBD.execute("CREATE TABLE IF NOT EXISTS estoque(idEstoque int, estoqueMaterial int, UNIQUE INDEX estoque_unico (`idEstoque` ASC));");
		criarBD.execute("INSERT IGNORE INTO estoque(idEstoque, estoqueMaterial) VALUES(1, 0);");
		System.out.println("Tabela estoque criada!");
		//Criar tabela compra
		criarBD.execute("CREATE TABLE IF NOT EXISTS compra(nomeMaterial varchar(255), precoMaterial double);");
		System.out.println("Tabela compra criada!");
		//Criar tabela caixa
		criarBD.execute("CREATE TABLE IF NOT EXISTS caixa(idCaixa int, totalCaixa double, UNIQUE INDEX caixa_unico (`idCaixa` ASC));");
		criarBD.execute("INSERT IGNORE INTO caixa(idCaixa, totalCaixa) VALUES(1, 0);");
		System.out.println("Tabela caixa criada!");
		//Criar tabela funcionarios
		criarBD.execute("CREATE TABLE IF NOT EXISTS funcionario(nome varchar(255), cargo varchar(255), projetoAtual varchar(255));");
		System.out.println("Tabela funcionarios criada!");
		
		conexao.close();
		System.out.println("Conexão finalizada!");
	}

}
