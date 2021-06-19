package estaleiroNaval;

import java.sql.SQLException;

import com.sun.jdi.event.EventQueue;

import persistencia.CriarBD;
import telas.TelaPrincipal;


public class EstaleiroMain {


	public static void main(String[] args) throws SQLException { //Verificar a senha root na classe CriarBD no pacote persistencia
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		System.out.println("Aplicação Finalizada!");
	}

}
