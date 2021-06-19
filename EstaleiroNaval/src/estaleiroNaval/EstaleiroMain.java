package estaleiroNaval;
import java.sql.SQLException;
import persistencia.CriarBD;
import telas.TelaPrincipal;


public class EstaleiroMain {


	public static void main(String[] args) throws SQLException { //Verificar a senha root na classe CriarBD no pacote persistencia
		
		CriarBD.iniciarBD();
		
		new TelaPrincipal();
		
		System.out.println("Aplicação Finalizada!");
	}

}
