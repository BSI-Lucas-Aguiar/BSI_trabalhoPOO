package estaleiroNaval;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import persistencia.FabricaConexao;

public class Estoque {
	private int estoqueMaterial;
	
	public int listarEstoque() {
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement totalEstoque = conexao.createStatement();
			System.out.println("Conexão com o BD realizada para consultar estoque!");
			
			String queryListarEstoque = "SELECT * FROM estaleiro_naval.estoque";
			
			ResultSet resultado = totalEstoque.executeQuery(queryListarEstoque);
			
			int total = 0 ;
			
			while(resultado.next()) {
				total = resultado.getInt(estoqueMaterial);
			}
			
			conexao.close();
			System.out.println("Conexão para demissão finalizada!");
			
			return total;
			
		} catch (Exception e1) {
		System.err.println("Erro na busca pelo total."+e1);
		}
		
		
		return 0;
	}
	
	public void retirarMaterial() {
		//Implementar
	}

	
	//Sets e Gets
	public int getEstoqueMaterial() {
		return estoqueMaterial;
	}

	public void setEstoqueMaterial(int estoqueMaterial) {
		this.estoqueMaterial = estoqueMaterial;
	}
}
