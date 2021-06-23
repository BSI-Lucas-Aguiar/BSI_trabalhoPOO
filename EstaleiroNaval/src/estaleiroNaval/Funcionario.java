package estaleiroNaval;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import persistencia.FabricaConexao;

public class Funcionario {

	private String nome;
	private String cargo;
	private String projetoAtual;
	
	//Retorno para a lista de funcion�rios na tela Funcion�rios
	//********************************************************************************************************
	public ArrayList<Funcionario> listarFuncionario(){
		
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement stmt = conexao.createStatement();
			System.out.println("Conex�o com o BD realizada para cadastro!");
			
			String queryListarFuncionario = "SELECT * FROM estaleiro_naval.funcionario";
			
			ResultSet resultado = stmt.executeQuery(queryListarFuncionario);
			
			ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
			
			while(resultado.next()) {
				Funcionario fun = new Funcionario();
				
				fun.setNome(resultado.getString("nome"));
				fun.setCargo(resultado.getString("cargo"));
				fun.setProjetoAtual(resultado.getString("projetoAtual"));
				
				listaFuncionario.add(fun);
				
			}
			
			conexao.close();
			System.out.println("Conex�o para listagem de funcion�rios finalizada!");
			
			return listaFuncionario;
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		return null;
	}
	
	//Realizando a remo��o do funcion�rio do BD
	//********************************************************************************************************
	public void demitirFuncionario() {
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement demitirFun = conexao.createStatement();
			System.out.println("Conex�o com o BD realizada para demiss�o realizada!");
			
			demitirFun.execute("USE estaleiro_naval;");
			demitirFun.execute("DELETE FROM funcionario WHERE nome ='" +this.getNome()+"'");
			
			conexao.close();
			System.out.println("Conex�o para demiss�o finalizada!");
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	}
	
	public void cadastrarFuncionario() {
		//Sendo feito na classe da tela, poss�vel altera��o futura
	}
	
	//Sendo utilizado para alterar os dados, com exce��o 
	//********************************************************************************************************
	public void alterarDados() {
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement alterarFun = conexao.createStatement();
			System.out.println("Conex�o com o BD realizada para altera��o realizada!");
			
			alterarFun.execute("USE estaleiro_naval;");
			alterarFun.execute("UPDATE funcionario SET cargo ='"+this.getCargo()+"', projetoAtual = '"+this.getProjetoAtual()+"' WHERE nome = '" +this.getNome()+"'");
			
			JOptionPane.showMessageDialog(null, "Dados do funcion�rio "+this.getNome()+" alterados!");
			conexao.close();
			System.out.println("Conex�o para altera��o finalizada!");
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	}
	
	//Sets e Gets
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getProjetoAtual() {
		return projetoAtual;
	}
	public void setProjetoAtual(String projetoAtual) {
		this.projetoAtual = projetoAtual;
	}
	
	
}