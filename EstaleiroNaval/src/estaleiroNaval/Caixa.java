package estaleiroNaval;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import persistencia.FabricaConexao;

public class Caixa {

	private double totalCaixa;

	public void venderProjeto() {
		//Implementar
	}
	
	
	public double consultarTotal() throws SQLException{
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement stmt = conexao.createStatement();
			System.out.println("Conexão com o BD realizada para consultar saldo!");
			
			String queryListarFuncionario = "SELECT * FROM estaleiro_naval.caixa";
			
			ResultSet resultado = stmt.executeQuery(queryListarFuncionario);
			
			double caixa = 0;
			
			while(resultado.next()) {
				caixa = resultado.getDouble("totalCaixa");
			}
			
			conexao.close();
			System.out.println("Conexão para consulta de saldo finalizada!");
			
			return caixa;
			
		} catch (Exception e1) {
			System.err.println("Falhou aqui na classe Caixa - Consultar Total."+e1);
		}
		
		return 1;
	}
	
	//Sets e Gets
	public double getTotalCaixa() {
		return totalCaixa;
	}

	public void setTotalCaixa(double totalCaixa) {
		this.totalCaixa = totalCaixa;
	}
	
	
}
