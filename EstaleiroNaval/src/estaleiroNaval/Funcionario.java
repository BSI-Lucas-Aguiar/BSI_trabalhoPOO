package estaleiroNaval;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import persistencia.FabricaConexao;

public class Funcionario {

	private String nome;
	private String cargo;
	private String projetoAtual;
	
	//Retorno para a lista de funcionários na tela Funcionários
	public ArrayList<Funcionario> listarFuncionario(){
		
		try {
			Connection conexao = FabricaConexao.getConexao();
			Statement stmt = conexao.createStatement();
			System.out.println("Conexão com o BD realizada para cadastro!");
			
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
			System.out.println("Conexão para listagem de funcionários finalizada!");
			
			return listaFuncionario;
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		return null;
	}
	
	
	public void cadastrarFuncionario() {
		//Implementar
	}
	
	public void demitirFuncionario() {
		//Implementar
	}
	
	
	public void alterarProjeto() {
		//Implementar
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