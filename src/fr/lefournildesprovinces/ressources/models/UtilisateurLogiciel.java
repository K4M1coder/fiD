package fr.lefournildesprovinces.ressources.models;

public class UtilisateurLogiciel {
	String identifiant;
	String Motdepasse;
	String numeroutilisateur;
	String privilege;

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

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(final String privilege) {
		this.privilege = privilege;
	}

	@Override
	public String toString() {
		return " " + this.identifiant;
	}

}
