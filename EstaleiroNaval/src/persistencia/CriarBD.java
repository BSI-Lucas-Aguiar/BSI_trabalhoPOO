package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBD {

	public static void iniciarBD() throws SQLException {
		//Altere os dados do SQL na Classe DadosMYSQL no pacote Persistencia
		//Função criada para toda movimentação com banco de dados, lembrar de colocar o close ao fim de cada chamada
		Connection conexao = FabricaConexao.getConexao();
		
		Statement criarBD = conexao.createStatement();
		//Criar o Banco de Dados
		criarBD.execute("CREATE DATABASE IF NOT EXISTS estaleiro_naval;");
		System.out.println("Banco de Dados estaleiro_naval Criado.");
		//Utilizar o Banco de dados
		criarBD.execute("USE estaleiro_naval;");
		System.out.println("Utilizando o BD estaleiro_Naval...");
		//Criar tabela lancha
		criarBD.execute("CREATE TABLE IF NOT EXISTS lancha(codigoProjeto varchar(255), quantidadeMaterial int, materialUtilizado int, vendido boolean, valorEmbarcacao double, tipo varchar(255));");
		
		//Criar tabela estoque
		criarBD.execute("CREATE TABLE IF NOT EXISTS estoque(idEstoque int, estoqueMaterial int, UNIQUE INDEX estoque_unico (`idEstoque` ASC));");
		criarBD.execute("INSERT IGNORE INTO estoque(idEstoque, estoqueMaterial) VALUES(1, 0);");
		
		//Criar tabela compra
		criarBD.execute("CREATE TABLE IF NOT EXISTS compra(nomeMaterial varchar(255), precoMaterial double);");
		
		//Criar tabela caixa
		criarBD.execute("CREATE TABLE IF NOT EXISTS caixa(idCaixa int, totalCaixa double, UNIQUE INDEX caixa_unico (`idCaixa` ASC));");
		criarBD.execute("INSERT IGNORE INTO caixa(idCaixa, totalCaixa) VALUES(1, 0);");
		
		//Criar tabela funcionarios
		criarBD.execute("CREATE TABLE IF NOT EXISTS funcionario(nome varchar(255), cargo varchar(255), projetoAtual varchar(255));");
		System.out.println("Tabelas criadas / Verificadas.");
		
		conexao.close();
		System.out.println("Conexão finalizada!");
	}

}
