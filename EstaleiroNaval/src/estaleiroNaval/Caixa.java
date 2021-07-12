package estaleiroNaval;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import persistencia.FabricaConexao;

public class Caixa {

	private double totalCaixa;
	
	//Função Vender Projeto
	//********************************************************************************************************
	public void venderProjeto(String projetoVenda) {
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement venderProjeto = conexao.createStatement();
			Statement consultarSaldo = conexao.createStatement();
			System.out.println("Conexão com o BD realizada para Vender Projeto!");
			
			String queryConsultarProjeto = "SELECT * FROM estaleiro_naval.lancha WHERE codigoProjeto = '"+projetoVenda+"';";
			String queryConsultarSaldo = "SELECT * FROM estaleiro_naval.caixa";
			
			ResultSet resultadoConsulta = venderProjeto.executeQuery(queryConsultarProjeto);
			ResultSet resultadoSaldo = consultarSaldo.executeQuery(queryConsultarSaldo);
			
			double caixa = 0;
			
			while(resultadoSaldo.next()) {
				caixa = resultadoSaldo.getDouble("totalCaixa");
			}

			boolean vendido = false;
			double valorEmbarcacao = 0;
			
			String comparacaoProjeto = "Projeto Inexistente";
			while(resultadoConsulta.next()) {
				comparacaoProjeto = resultadoConsulta.getString("codigoProjeto");
				vendido = resultadoConsulta.getBoolean("vendido");
				valorEmbarcacao = resultadoConsulta.getDouble("valorEmbarcacao");
			}
			
			if(comparacaoProjeto.equals(projetoVenda) == true) {
				if(vendido == false) {
					caixa = (caixa + valorEmbarcacao);
					venderProjeto.executeUpdate("UPDATE estaleiro_naval.caixa SET totalCaixa = '"+caixa+"';");
					venderProjeto.executeUpdate("UPDATE estaleiro_naval.lancha SET vendido ='"+1+"' WHERE codigoProjeto = '"+projetoVenda+"';");
					JOptionPane.showMessageDialog(null, projetoVenda+" vendido por: R$"+valorEmbarcacao);
					
				}else {
					JOptionPane.showMessageDialog(null, "O projeto : "+projetoVenda+" já está vendido!");
				}
			}
			
			resultadoSaldo.close();
			resultadoConsulta.close();
						
			conexao.close();
			System.out.println("Conexão para Vender Projeto finalizada!");

		}
		catch (SQLException e1) {
			System.err.println("Falhou aqui na classe Caixa SQL - Vender Projeto. "+e1);
		}
		catch (Exception e1) {
			System.err.println("Falhou aqui na classe Caixa - Vender Projeto. "+e1);
		}
	}
	
	//Função Consultar Projeto
	//********************************************************************************************************
	public double consultarTotal() throws SQLException{
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement stmt = conexao.createStatement();
			System.out.println("Conexão com o BD para Consultar Saldo realizada!");
			
			String queryListarFuncionario = "SELECT * FROM estaleiro_naval.caixa";
			
			ResultSet resultado = stmt.executeQuery(queryListarFuncionario);
			
			double caixa = 0;
			
			while(resultado.next()) {
				caixa = resultado.getDouble("totalCaixa");
			}
			
			conexao.close();
			System.out.println("Conexão para Consulta de Saldo finalizada!");
			
			return caixa;
			
		} catch (Exception e1) {
			System.err.println("Falhou na função Consultar Total - classe Caixa. "+e1);
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
