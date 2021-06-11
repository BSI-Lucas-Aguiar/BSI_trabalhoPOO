package estaleiroNaval;

import java.util.Date;

public class Funcionario {

	private String login;
	private String senha;
	private String nome;
	private Date dataNascimento;
	private String cargo;
	private int projetoAtual;
	private boolean funcionarioAtivo;
	
	public Funcionario(String login, String senha, String nome, Date dataNascimento, String cargo, int projetoAtual) {
		this.login=login;
		this.senha=senha;
		this.nome=nome;
		this.dataNascimento=dataNascimento;
		this.cargo=cargo;
		this.projetoAtual=projetoAtual;
		this.funcionarioAtivo=true; //O funcionário é cadastrado como ativo
		
	}
	
	public void cadastrarFuncionario() {
		
	}
	
	public void demitirFuncionario() {
		
	}

	public void readmitirFuncionario() {
	
	}

	public void listarFuncionario() {
	
	}
	
	//Sets e Gets
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getProjetoAtual() {
		return projetoAtual;
	}
	public void setProjetoAtual(int projetoAtual) {
		this.projetoAtual = projetoAtual;
	}
	public boolean isFuncionarioAtivo() {
		return funcionarioAtivo;
	}
	public void setFuncionarioAtivo(boolean funcionarioAtivo) {
		this.funcionarioAtivo = funcionarioAtivo;
	}
	
}
