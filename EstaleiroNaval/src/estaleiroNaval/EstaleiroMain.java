package estaleiroNaval;

import java.sql.SQLException;

import persistencia.CriarBD;
import telas.TelaPrincipal;


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
