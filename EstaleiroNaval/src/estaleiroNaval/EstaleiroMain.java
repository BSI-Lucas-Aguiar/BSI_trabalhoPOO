package estaleiroNaval;

import java.sql.SQLException;

import persistencia.CriarBD;
import telas.TelaPrincipal;

/*
 * Esta � a classe main que deve ser executada no in�cio do programa;
 * N�o se esque�a de alterar na FabricaConexao os dados de conex�o no MYSQL;
 * As classes atualmente implementadas e funcionais com persistencia s�o Funcionarios e Compra;
 * Nenhuma das imagens utilizadas � de minha posse;
 * Caso v� utilizar parcialmente ou totalmente meus c�digos pelo menos me d� um follow no instagram @lucassendrak
 */

public class EstaleiroMain {

	public static void main(String[] args) throws SQLException { //Verificar a senha root na classe CriarBD no pacote persistencia
		
		//Altere os dados do SQL na Classe DadosMYSQL no pacote Persistencia
		CriarBD.iniciarBD();
		
		//Chamada da Tela Principal
		TelaPrincipal tela = new TelaPrincipal();
		tela.setVisible(true);
		System.out.println("Aplica��o Iniciada!");
				
	}

}
