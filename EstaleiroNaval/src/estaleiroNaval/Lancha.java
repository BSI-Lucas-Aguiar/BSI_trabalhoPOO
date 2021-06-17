package estaleiroNaval;

public class Lancha extends Projeto{
	
	private String nomeLancha;

	public Lancha(String nomeLancha, String codigoProjeto, int quantidadeMaterial, int materialUtilizado, boolean vendido,
			double valorEmbarcacao) {
		super(codigoProjeto, quantidadeMaterial,  materialUtilizado, vendido, valorEmbarcacao);
		this.nomeLancha=nomeLancha;
	}

	public void listarProjetos() {
		//Implementar
	}
	
	//Sets e Gets
	public String getNomeLancha() {
		return nomeLancha;
	}

	public void setNomeLancha(String nomeLancha) {
		this.nomeLancha = nomeLancha;
	}

}
