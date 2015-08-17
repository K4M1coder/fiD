package fr.lefournildesprovinces.ressources.models;

public class Ville {
	String codePostalVille;
	int idville;
	String nomVille;

	public Ville() {
		this.idville = -1;
		this.codePostalVille = "";
		this.nomVille = "";
	}
	
	public String getCodePostalVille() {
		return this.codePostalVille;
	}

	public int getIdville() {
		return this.idville;
	}

	public String getNomVille() {
		return this.nomVille;
	}

	public void setCodePostalVille(final String codePostalVille) {
		this.codePostalVille = codePostalVille;
	}

	public void setIdville(final int idville) {
		this.idville = idville;
	}

	public void setNomVille(final String nomVille) {
		this.nomVille = nomVille;
	}

	@Override
	public String toString() {
		return this.nomVille;
	}

}
