package estaleiroNaval;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import persistencia.FabricaConexao;

public class Compra {

	private String nomeMaterial;
	private String precoMaterial;
	
	public void cadastrarMaterial() {
		//Implementado na classe da tela, poss�vel mudan�a no futuro
	}
	
	public void comprarMaterial() {
		//Implementado na classe da tela, poss�vel mudan�a no futuro
	}
	
	//Remo��o do material no estoque
	//********************************************************************************************************
	public void removerMaterial() {
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement removerMat = conexao.createStatement();
			System.out.println("Conex�o com o BD realizada para remo��o de material!");
			
			removerMat.execute("USE estaleiro_naval;");
			removerMat.execute("DELETE FROM compra WHERE nomeMaterial ='" +this.getNomeMaterial()+"'");
			
			conexao.close();
			System.out.println("Conex�o para remo��o de material finalizada!");
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	}
	
	//Realiza o retorno da arraylist para exibi��o na tela
	//********************************************************************************************************
	public ArrayList<Compra> listarCompra() {
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement stmt = conexao.createStatement();
			System.out.println("Conex�o com o BD realizada para listagem de materiais!");
			
			String queryListarCompras = "SELECT * FROM estaleiro_naval.compra";
			
			ResultSet resultado = stmt.executeQuery(queryListarCompras);
			
			ArrayList<Compra> listaCompra = new ArrayList<Compra>();
			
			while(resultado.next()) {
				Compra comp = new Compra();
				
				comp.setNomeMaterial(resultado.getString("nomeMaterial"));
				comp.setPrecoMaterial(resultado.getString("precoMaterial"));
				
				listaCompra.add(comp);
				
			}
			
			conexao.close();
			System.out.println("Conex�o para listagem de materiais finalizada!");
			
			return listaCompra;
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		return null;
	}
	
	//Realiza a altera��o no BD
	//********************************************************************************************************
	public void alterarDados() {
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement alterarComp = conexao.createStatement();
			System.out.println("Conex�o com o BD realizada para altera��o de material realizada!");
			
			alterarComp.execute("USE estaleiro_naval;");
			alterarComp.execute("UPDATE compra SET precoMaterial ='"+this.getPrecoMaterial()+"' WHERE nomeMaterial = '" +this.getNomeMaterial()+"';");
			
			JOptionPane.showMessageDialog(null, "Pre�o do Material "+this.getNomeMaterial()+" alterado");
			conexao.close();
			System.out.println("Conex�o para altera��o de material finalizada!");
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
	}
	
	//Sets e Gets
	public String getNomeMaterial() {
		return nomeMaterial;
	}
	public void setNomeMaterial(String nomeMaterial) {
		this.nomeMaterial = nomeMaterial;
	}
	public String getPrecoMaterial() {
		return precoMaterial;
	}
	public void setPrecoMaterial(String precoMaterial) {
		this.precoMaterial = precoMaterial;
	}

	

	
	
	
	
}
