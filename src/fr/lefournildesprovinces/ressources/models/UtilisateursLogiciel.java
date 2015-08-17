package fr.lefournildesprovinces.ressources.models;

public class UtilisateursLogiciel {
	String identifiant;
	String Motdepasse;
	String numeroutilisateur;

	public String getIdentifiant() {
		return this.identifiant;
	}

	public String getMotdepasse() {
		return this.Motdepasse;
	}

	public String getNumeroutilisateur() {
		return this.numeroutilisateur;
	}

	public void setIdentifiant(final String identifiant) {
		this.identifiant = identifiant;
	}

	public void setMotdepasse(final String motdepasse) {
		this.Motdepasse = motdepasse;
	}

	public void setNumeroutilisateur(final String numeroutilisateur) {
		this.numeroutilisateur = numeroutilisateur;
	}

	@Override
	public String toString() {
		return " " + this.identifiant;
	}

}
