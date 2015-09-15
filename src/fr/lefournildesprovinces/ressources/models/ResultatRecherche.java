package fr.lefournildesprovinces.ressources.models;

public class ResultatRecherche {

	String adresseIndividu;
	String age;
	String civiliteIndividu;
	String codePostalIndividu;
	String dateNaissanceIndividu;
	String email;
	String newsletterIndividu;
	String nomIndividu;
	String Nommagasin;
	String numerocarte;
	String vIP;
	String prenomIndividu;
	String telephonefixe;
	String telephonemobile;
	String villeIndividu;

	public String getAdresseIndividu() {
		return this.adresseIndividu;
	}

	public String getVIP() {
		return vIP;
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

	public String getNewsletterIndividu() {
		return this.newsletterIndividu;
	}

	public String getNomIndividu() {
		return this.nomIndividu;
	}

	public String getNommagasin() {
		return this.Nommagasin;
	}

	public String getNumerocarte() {
		return this.numerocarte;
	}

	public String getPrenomIndividu() {
		return this.prenomIndividu;
	}

	public String getTelephonefixe() {
		return this.telephonefixe;
	}

	public String getTelephonemobile() {
		return this.telephonemobile;
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

	public void setNewsletterIndividu(final String newsletterIndividu) {
		this.newsletterIndividu = newsletterIndividu;
	}

	public void setNomIndividu(final String nomIndividu) {
		this.nomIndividu = nomIndividu;
	}

	public void setNommagasin(final String nommagasin) {
		this.Nommagasin = nommagasin;
	}

	public void setNumerocarte(final String numerocarte) {
		this.numerocarte = numerocarte;
	}

	public void setPrenomIndividu(final String prenomIndividu) {
		this.prenomIndividu = prenomIndividu;
	}

	public void setTelephonefixe(final String telephonefixe) {
		this.telephonefixe = telephonefixe;
	}

	public void setTelephonemobile(final String telephonemobile) {
		this.telephonemobile = telephonemobile;
	}

	public void setVilleIndividu(final String villeIndividu) {
		this.villeIndividu = villeIndividu;
	}

	public void setVIP(final String vip) {
		vIP = vip;
	}

	@Override
	public String toString() {
		return "ResultatRecherche [civiliteIndividu=" + this.civiliteIndividu
				+ ", nomIndividu=" + this.nomIndividu + ", prenomIndividu="
				+ this.prenomIndividu + ", adresseIndividu="
				+ this.adresseIndividu + ", villeIndividu="
				+ this.villeIndividu + ", codePostalIndividu="
				+ this.codePostalIndividu + ", dateNaissanceIndividu="
				+ this.dateNaissanceIndividu + ", email=" + this.email
				+ ", newsletterIndividu=" + this.newsletterIndividu
				+ ", numerocarte=" + this.numerocarte + ", Nommagasin="
				+ this.Nommagasin + ", telephonefixe=" + this.telephonefixe
				+ ", telephonemobile=" + this.telephonemobile + ", age="
				+ this.age + ((this.vIP.equals("true"))?"client privilege":"")+"]";
	}

}
