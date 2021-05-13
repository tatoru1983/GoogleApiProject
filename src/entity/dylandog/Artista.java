package entity.dylandog;

public class Artista {
	
	private String nomeCognome;

	public String getNomeCognome() {
		return nomeCognome;
	}

	public void setNomeCognome(String nomeCognome) {
		this.nomeCognome = nomeCognome;
	}

	@Override
	public String toString() {
		return "Artista [nomeCognome=" + nomeCognome + "]";
	}

}
