package estaleiroNaval;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import persistencia.FabricaConexao;

public class Projeto {
	
	private String codigoProjeto;
	private int quantidadeMaterial;
	private int materialUtilizado;
	private boolean vendido;
	private double valorEmbarcacao;
	private String tipo;
	
	//Fun��o Listar Projeto
	//********************************************************************************************************
	public ArrayList<Projeto> listarProjetos() {
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement stmt = conexao.createStatement();
			System.out.println("Conex�o com o BD realizada para listagem de Projeto!");
			
			String queryListarProjeto = "SELECT * FROM estaleiro_naval.lancha";
			
			ResultSet resultado = stmt.executeQuery(queryListarProjeto);
			
			ArrayList<Projeto> listaProjeto = new ArrayList<Projeto>();
			
			while(resultado.next()) {
				Projeto proj = new Projeto();
				
				proj.setCodigoProjeto(resultado.getString("codigoProjeto"));
				proj.setQuantidadeMaterial(resultado.getInt("quantidadeMaterial"));
				proj.setMaterialUtilizado(resultado.getInt("materialUtilizado"));
				proj.setVendido(resultado.getBoolean("vendido"));
				proj.setValorEmbarcacao(resultado.getDouble("valorEmbarcacao"));
				proj.setTipo(resultado.getString("tipo"));
				
				listaProjeto.add(proj);
				
			}
			
			conexao.close();
			System.out.println("Conex�o para listagem de Projetos finalizada!");
			
			return listaProjeto;
			
		} catch (Exception e1) {
			System.err.println("Erro no cadastro de projeto"+e1);
		}
		
		
		return null;
	}
	
	//Fun��o Alterar Projeto
	//********************************************************************************************************
	public void alterarProjeto() {
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement alterarProj = conexao.createStatement();
			System.out.println("Conex�o com o BD realizada para altera��o de projeto realizada!");
			
			alterarProj.execute("USE estaleiro_naval;");
			alterarProj.execute("UPDATE lancha SET valorEmbarcacao ='"+this.getValorEmbarcacao()+"', quantidadeMaterial = '"+this.getQuantidadeMaterial()+"' WHERE codigoProjeto = '" +this.getCodigoProjeto()+"'");
			
			JOptionPane.showMessageDialog(null, "Dados do Projeto "+this.getCodigoProjeto()+" alterados!");
			conexao.close();
			System.out.println("Conex�o para altera��o de projeto finalizada!");
			
		} catch (Exception e1) {
			System.err.println("Erro fun��o Alterar Projeto - Classe Projeto. "+e1);
		}
	}
	
	//Fun��o Deletar Projeto
	//********************************************************************************************************
	public void deletarProjeto() {
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement deletarProj = conexao.createStatement();
			System.out.println("Conex�o com o BD realizada para exclus�o de projeto!");
			
			deletarProj.execute("USE estaleiro_naval;");
			deletarProj.execute("DELETE FROM lancha WHERE codigoProjeto ='" +this.getCodigoProjeto()+"'");
			
			conexao.close();
			System.out.println("Conex�o para exclus�o de projeto finalizada!");
			
		} catch (Exception e1) {
			System.err.println("Erro na fun��o deletar Projeto - Classe Projeto. "+e1);
		}
	}
	
	
	//Sets e Gets
	public String getCodigoProjeto() {
		return codigoProjeto;
	}
	public void setCodigoProjeto(String codigoProjeto) {
		this.codigoProjeto = codigoProjeto;
	}
	public int getQuantidadeMaterial() {
		return quantidadeMaterial;
	}
	public void setQuantidadeMaterial(int quantidadeMaterial) {
		this.quantidadeMaterial = quantidadeMaterial;
	}
	public int getMaterialUtilizado() {
		return materialUtilizado;
	}
	public void setMaterialUtilizado(int materialUtilizado) {
		this.materialUtilizado = materialUtilizado;
	}
	public boolean isVendido() {
		return vendido;
	}
	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
	public double getValorEmbarcacao() {
		return valorEmbarcacao;
	}
	public void setValorEmbarcacao(double valorEmbarcacao) {
		this.valorEmbarcacao = valorEmbarcacao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
}
