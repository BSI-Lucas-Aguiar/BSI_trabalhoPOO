package estaleiroNaval;

public class Funcionario {

	private String nome;
	private String cargo;
	private String projetoAtual;
	
	public Funcionario(String nome, String cargo, String projetoAtual) {
		this.nome = nome;
		this.cargo = cargo;
		this.projetoAtual = projetoAtual;
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