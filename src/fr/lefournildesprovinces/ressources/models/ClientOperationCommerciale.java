package fr.lefournildesprovinces.ressources.models;

public class ClientOperationCommerciale {
	String adresseIndividu;
	String age;
	String civiliteIndividu;
	String codePostalIndividu;
	String dateNaissanceIndividu;
	String email;
	int idclient;
	String libelleoperationcommerciale;
	String newsletterIndividu;
	String nomIndividu;
	String Nommagasin;
	String numerofixe;
	String numeroportable;
	String prenomIndividu;
	String villeIndividu;

	public String getAdresseIndividu() {
		return this.adresseIndividu;
	}

	public String getAge() {
		return this.age;
	}

	public String getCiviliteIndividu() {
		return this.civiliteIndividu;
	}

	public String getCodePostalIndividu() {
		return this.codePostalIndividu;
	}

	public String getDateNaissanceIndividu() {
		return this.dateNaissanceIndividu;
	}

	public String getEmail() {
		return this.email;
	}

	public int getIdclient() {
		return this.idclient;
	}

	public String getLibelleoperationcommerciale() {
		return this.libelleoperationcommerciale;
	}

	public String getNewsletterIndividu() {
		return this.newsletterIndividu;
	}

	public String getNomIndividu() {
		return this.nomIndividu;
	}

	public String getNommagasin() {
		return this.Nommagasin;
	}

	public String getNumerofixe() {
		return this.numerofixe;
	}

	public String getNumeroportable() {
		return this.numeroportable;
	}

	public String getPrenomIndividu() {
		return this.prenomIndividu;
	}

	public String getVilleIndividu() {
		return this.villeIndividu;
	}

	public void setAdresseIndividu(final String adresseIndividu) {
		this.adresseIndividu = adresseIndividu;
	}

	public void setAge(final String age) {
		this.age = age;
	}

	public void setCiviliteIndividu(final String civiliteIndividu) {
		this.civiliteIndividu = civiliteIndividu;
	}

	public void setCodePostalIndividu(final String codePostalIndividu) {
		this.codePostalIndividu = codePostalIndividu;
	}

	public void setDateNaissanceIndividu(final String dateNaissanceIndividu) {
		this.dateNaissanceIndividu = dateNaissanceIndividu;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public void setIdclient(final int idclient) {
		this.idclient = idclient;
	}

	public void setLibelleoperationcommerciale(
			final String libelleoperationcommerciale) {
		this.libelleoperationcommerciale = libelleoperationcommerciale;
	}

	public void setNewsletterIndividu(final String newsletterIndividu) {
		this.newsletterIndividu = newsletterIndividu;
	}

	public void setNomIndividu(final String nomIndividu) {
		this.nomIndividu = nomIndividu;
	}

	public void setNommagasin(final String nommagasin) {
		this.Nommagasin = nommagasin;
	}

	public void setNumerofixe(final String numerofixe) {
		this.numerofixe = numerofixe;
	}

	public void setNumeroportable(final String numeroportable) {
		this.numeroportable = numeroportable;
	}

	public void setPrenomIndividu(final String prenomIndividu) {
		this.prenomIndividu = prenomIndividu;
	}

	public void setVilleIndividu(final String villeIndividu) {
		this.villeIndividu = villeIndividu;
	}

	@Override
	public String toString() {
		return "ClientOperationCommerciale [idclient=" + this.idclient
				+ ", civiliteIndividu=" + this.civiliteIndividu
				+ ", nomIndividu=" + this.nomIndividu + ", prenomIndividu="
				+ this.prenomIndividu + ", adresseIndividu="
				+ this.adresseIndividu + ", villeIndividu="
				+ this.villeIndividu + ", codePostalIndividu="
				+ this.codePostalIndividu + ", dateNaissanceIndividu="
				+ this.dateNaissanceIndividu + ", email=" + this.email
				+ ", newsletterIndividu=" + this.newsletterIndividu
				+ ", Nommagasin=" + this.Nommagasin
				+ ", libelleoperationcommerciale="
				+ this.libelleoperationcommerciale + ", numerofixe="
				+ this.numerofixe + ", numeroportable=" + this.numeroportable
				+ ", age=" + this.age + "]";
	}

}
