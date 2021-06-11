package estaleiroNaval;

public class Lancha extends Projeto{
	
	private String nomeLancha;
	private String potenciaMotor;
	
	//Criar o Super Construtor
	public Lancha() {
		// TODO Auto-generated constructor stub
	}

	//Sets e Gets
	
	public String getNomeLancha() {
		return nomeLancha;
	}

	public void setNomeLancha(String nomeLancha) {
		this.nomeLancha = nomeLancha;
	}

	public String getPotenciaMotor() {
		return potenciaMotor;
	}

	public void setPotenciaMotor(String potenciaMotor) {
		this.potenciaMotor = potenciaMotor;
	}

}
