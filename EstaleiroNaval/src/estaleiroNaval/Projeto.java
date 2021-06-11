package estaleiroNaval;

public abstract class Projeto {
	
	private String codigoProjeto;
	private int quantidadeFerro;
	private int ferroUtilizado;
	private int quantidadeMaquinario;
	private int maquinarioUtilizado;
	private int quantidadeEletronicos;
	private int eletronicosUtilizados;
	private int quantidadeMadeira;
	private int madeiraUtilizada;
	private boolean vendido;
	private double valorEmbarcaçao;
	
	public Projeto() {
		
	}
	
	public void listarProjetos() {
		
	}
	
	//Sets e Gets
	
	public String getCodigoProjeto() {
		return codigoProjeto;
	}
	public void setCodigoProjeto(String codigoProjeto) {
		this.codigoProjeto = codigoProjeto;
	}
	public int getQuantidadeFerro() {
		return quantidadeFerro;
	}
	public void setQuantidadeFerro(int quantidadeFerro) {
		this.quantidadeFerro = quantidadeFerro;
	}
	public int getFerroUtilizado() {
		return ferroUtilizado;
	}
	public void setFerroUtilizado(int ferroUtilizado) {
		this.ferroUtilizado = ferroUtilizado;
	}
	public int getQuantidadeMaquinario() {
		return quantidadeMaquinario;
	}
	public void setQuantidadeMaquinario(int quantidadeMaquinario) {
		this.quantidadeMaquinario = quantidadeMaquinario;
	}
	public int getMaquinarioUtilizado() {
		return maquinarioUtilizado;
	}
	public void setMaquinarioUtilizado(int maquinarioUtilizado) {
		this.maquinarioUtilizado = maquinarioUtilizado;
	}
	public int getQuantidadeEletronicos() {
		return quantidadeEletronicos;
	}
	public void setQuantidadeEletronicos(int quantidadeEletronicos) {
		this.quantidadeEletronicos = quantidadeEletronicos;
	}
	public int getEletronicosUtilizados() {
		return eletronicosUtilizados;
	}
	public void setEletronicosUtilizados(int eletronicosUtilizados) {
		this.eletronicosUtilizados = eletronicosUtilizados;
	}
	public int getQuantidadeMadeira() {
		return quantidadeMadeira;
	}
	public void setQuantidadeMadeira(int quantidadeMadeira) {
		this.quantidadeMadeira = quantidadeMadeira;
	}
	public int getMadeiraUtilizada() {
		return madeiraUtilizada;
	}
	public void setMadeiraUtilizada(int madeiraUtilizada) {
		this.madeiraUtilizada = madeiraUtilizada;
	}
	public boolean isVendido() {
		return vendido;
	}
	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
	public double getValorEmbarcaçao() {
		return valorEmbarcaçao;
	}
	public void setValorEmbarcaçao(double valorEmbarcaçao) {
		this.valorEmbarcaçao = valorEmbarcaçao;
	}
	
	
}
