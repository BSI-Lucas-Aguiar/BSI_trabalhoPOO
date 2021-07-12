package estaleiroNaval;

import java.sql.SQLException;

import persistencia.CriarBD;
import telas.TelaPrincipal;

/*
 * Esta é a classe main que deve ser executada no início do programa;
 * Não se esqueça de alterar na FabricaConexao os dados de conexão no MYSQL;
 * As classes atualmente implementadas e funcionais com persistencia são Funcionarios e Compra;
 * Nenhuma das imagens utilizadas é de minha posse;
 * Caso vá utilizar parcialmente ou totalmente meus códigos pelo menos me dê um follow no instagram @lucassendrak
 */

public class EstaleiroMain {

	public static void main(String[] args) throws SQLException { //Verificar a senha root na classe CriarBD no pacote persistencia
		
		//Altere os dados do SQL na Classe DadosMYSQL no pacote Persistencia
		CriarBD.iniciarBD();
		
		//Chamada da Tela Principal
		TelaPrincipal tela = new TelaPrincipal();
		tela.setVisible(true);
		System.out.println("Aplicação Iniciada!");
				
	}

}
