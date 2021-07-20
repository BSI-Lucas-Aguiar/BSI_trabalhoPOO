package estaleiroNaval;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import persistencia.FabricaConexao;

public class Estoque {
	private int estoqueMaterial;
	
	//Função Listar Estoque
	//********************************************************************************************************
	public int listarEstoque() {
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement totalEstoque = conexao.createStatement();
			System.out.println("Conexão com o BD realizada para Consultar Estoque!");
			
			String queryListarEstoque = "SELECT * FROM estaleiro_naval.estoque";
			
			ResultSet resultado = totalEstoque.executeQuery(queryListarEstoque);
			
			int total = 0 ;
			
			while(resultado.next()) {
				total = resultado.getInt("estoqueMaterial");
			}
			
			conexao.close();
			System.out.println("Conexão para Consultar Estoque finalizada!");
			
			return total;
			
		} catch (Exception e1) {
			System.err.println("Erro na função Listar Estoque - Classe Estoque. "+e1);
		}
		
		return 0;
	}
	
	//Retirar Material
	//********************************************************************************************************
	public void retirarMaterial(int qtdMaterial, String projeto) {
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement stmt = conexao.createStatement();
			System.out.println("Conexão com o BD reatirar material!");
						
			stmt.executeUpdate("UPDATE estaleiro_naval.lancha SET materialUtilizado = materialUtilizado + '"+qtdMaterial+"'WHERE codigoProjeto = '"+projeto+"';");
			stmt.executeUpdate("UPDATE estaleiro_naval.estoque SET estoqueMaterial = estoqueMaterial - '"+qtdMaterial+"'WHERE idEstoque = 1;");
			
			conexao.close();
			System.out.println("Conexão para retirar material finalizada!");
			
		} catch (SQLException e) {
			System.err.println("Erro na hora de Retirar do Estoque / Adicionar no Projeto " +e);
		}
	}
	
	//Função Comprar Material
	//********************************************************************************************************
	public void comprarMaterial(String nomeMaterialBD, int quantidadeMaterial) {
		try {
			//Verificação do Saldo em caixa
			Connection conexao = FabricaConexao.getConexao();
			Statement stmt = conexao.createStatement();
			System.out.println("Conexão com o BD para comprar material realizada!");
			
			String queryListarSaldo = "SELECT * FROM estaleiro_naval.caixa";
			
			ResultSet resultado = stmt.executeQuery(queryListarSaldo);
			
			double caixa = 0;
			
			while(resultado.next()) {
				caixa = resultado.getDouble("totalCaixa");
			}
			
			//Verificação do Preço
			Statement precoMaterial = conexao.createStatement();
			
			String queryListarPrecoMaterial = "SELECT * FROM estaleiro_naval.compra precoMaterial WHERE nomeMaterial = '"+nomeMaterialBD+"';";
			ResultSet resultado2 = precoMaterial.executeQuery(queryListarPrecoMaterial);
			
			double precoMaterialBD = 0;
			
			while(resultado2.next()) {
				precoMaterialBD =  resultado2.getDouble("precoMaterial");
			}
			
			double totalCompra = (quantidadeMaterial * precoMaterialBD);
			
			//Confirmação de compra
			int verificacao = JOptionPane.showConfirmDialog(null, "Você possui: R$ "+caixa+" em caixa. Deseja realizar a compra por: R$ "+totalCompra+" ?", "Confiamação de Compra", JOptionPane.YES_NO_OPTION);
			
			if(verificacao == 0) {
				if(caixa < totalCompra) {
					JOptionPane.showMessageDialog(null, "Saldo em caixa insuficiente");
				}
				if(caixa >= totalCompra) {
					String queryAtualizarSaldo = "UPDATE estaleiro_naval.caixa SET totalCaixa = totalCaixa -'"+totalCompra+"';";
					stmt.executeUpdate(queryAtualizarSaldo) ;
					
					String queryAtualizarEstoque = "UPDATE estaleiro_naval.estoque SET estoqueMaterial = estoqueMaterial +'"+quantidadeMaterial+"'WHERE idEstoque = 1;";
					stmt.executeUpdate(queryAtualizarEstoque) ;
					
					JOptionPane.showMessageDialog(null, "Compra de "+quantidadeMaterial+" materiais, realizada por: R$ "+totalCompra);
				}
			}
			
			conexao.close();
			System.out.println("Conexão para comprar material realizada!");
			
		} catch (Exception e1) {
			System.err.println("Falhou na função comprar material - Classe Estoque "+e1);
		}
		
	}
	
	//Sets e Gets
	public int getEstoqueMaterial() {
		return estoqueMaterial;
	}

	public void setEstoqueMaterial(int estoqueMaterial) {
		this.estoqueMaterial = estoqueMaterial;
	}

	
}
