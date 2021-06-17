package estaleiroNaval;

public abstract class Projeto {
	
	protected String codigoProjeto;
	protected int quantidadeMaterial;
	protected int materialUtilizado;
	protected boolean vendido;
	protected double valorEmbarcacao;
	
	public Projeto(String codigoProjeto, int quantidadeMaterial, int materialUtilizado, boolean vendido, double valorEmbarcacao) {
		this.codigoProjeto = codigoProjeto;
		this.quantidadeMaterial = quantidadeMaterial;
		this.materialUtilizado = materialUtilizado;
		this.vendido = vendido;
		this.valorEmbarcacao = valorEmbarcacao;
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
	
	
	
}
