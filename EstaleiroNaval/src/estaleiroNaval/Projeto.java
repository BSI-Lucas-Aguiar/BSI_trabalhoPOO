package estaleiroNaval;

public abstract class Projeto {
	
	protected String codigoProjeto;
	protected int quantidadeMaterial;
	protected int materialUtilizado;
	protected boolean vendido;
	protected double valorEmbarcacao;
	protected String tipo;
	
	public Projeto(String codigoProjeto, int quantidadeMaterial, int materialUtilizado, boolean vendido, double valorEmbarcacao) {
		this.codigoProjeto = codigoProjeto;
		this.quantidadeMaterial = quantidadeMaterial;
		this.materialUtilizado = materialUtilizado;
		this.vendido = vendido;
		this.valorEmbarcacao = valorEmbarcacao;
	}
	
	

	public void listarProjetos() {
		//Implementar
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
