package estaleiroNaval;

public class Iate extends Projeto {

	private String nomeIate;
	private boolean cozinha;
	private boolean quarto;
	private boolean banheiro;
	private boolean piscina;
	
	//Criar o super Construtor
	public Iate() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNomeIate() {
		return nomeIate;
	}

	public void setNomeIate(String nomeIate) {
		this.nomeIate = nomeIate;
	}

	public boolean isCozinha() {
		return cozinha;
	}

	public void setCozinha(boolean cozinha) {
		this.cozinha = cozinha;
	}

	public boolean isQuarto() {
		return quarto;
	}

	public void setQuarto(boolean quarto) {
		this.quarto = quarto;
	}

	public boolean isBanheiro() {
		return banheiro;
	}

	public void setBanheiro(boolean banheiro) {
		this.banheiro = banheiro;
	}

	public boolean isPiscina() {
		return piscina;
	}

	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}

}
