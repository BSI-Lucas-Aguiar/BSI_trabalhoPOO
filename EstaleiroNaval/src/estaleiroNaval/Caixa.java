package estaleiroNaval;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import persistencia.FabricaConexao;

public class Caixa {

	private double totalCaixa;

	public void venderProjeto(String projetoVenda) {
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement venderProjeto = conexao.createStatement();
			Statement consultarSaldo = conexao.createStatement();
			System.out.println("Conexão com o BD realizada para vender Projeto!");
			
			String queryConsultarProjeto = "SELECT * FROM estaleiro_naval.lancha WHERE codigoProjeto = '"+projetoVenda+"'";
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
					venderProjeto.executeUpdate("UPDATE estaleiro_naval.caixa SET totalCaixa = '"+caixa+"'");
					venderProjeto.executeUpdate("UPDATE estaleiro_naval.lancha SET vendido ='"+1+"' WHERE codigoProjeto = '"+projetoVenda+"'");
					JOptionPane.showMessageDialog(null, projetoVenda+" vendido por: R$"+valorEmbarcacao);
					
				}else {
					JOptionPane.showMessageDialog(null, "O projeto : "+projetoVenda+" já está vendido!");
				}
			}
			
//			JOptionPane.showMessageDialog(null, "."+comparacaoProjeto+". ."+projetoVenda+".");

			
			
//			JOptionPane.showMessageDialog(null, comparacaoProjeto+"\n"+vendido);
			
//			System.out.println("Antes do while");

//			while(resultadoConsulta.next()) {
//				System.out.println("Dentro do while");
//				String comparacao = resultadoConsulta.getString("codigoProjeto");
//				if(projetoVenda == comparacao) {
//					System.out.println("Dentro do primeiro if");
//					if(resultadoConsulta.getInt("vendido") == 0) {
//						System.out.println("Dentro do segundo if");
//						caixa = (caixa + resultadoConsulta.getDouble("valorEmbarcacao"));
//						
//						venderProjeto.executeUpdate("UPDATE estaleiro_naval.caixa SET totalCaixa = totalCaixa + '"+caixa+"'");
//						
//						
//						JOptionPane.showMessageDialog(null, "O Projeto "+projetoVenda +" foi vendido por: R$"+resultadoSaldo);
//						JOptionPane.showMessageDialog(null, "teste");
//					}
//				}
//			}
			resultadoSaldo.close();
			resultadoConsulta.close();
						
			conexao.close();
			System.out.println("Conexão para consulta de saldo finalizada!");

			
		}
		catch (SQLException e1) {
			System.err.println("Falhou aqui na classe Caixa SQL - Vender Projeto."+e1);
		}
		catch (Exception e1) {
			System.err.println("Falhou aqui na classe Caixa - Vender Projeto."+e1);
		}
		
		
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
