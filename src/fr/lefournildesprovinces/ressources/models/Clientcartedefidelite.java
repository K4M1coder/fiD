package fr.lefournildesprovinces.ressources.models;

public class Clientcartedefidelite {

	String adresseIndividu;
	String age;
	String civiliteIndividu;
	String codePostalIndividu;
	String dateNaissanceIndividu;
	String email;
	int idclient;
	String mobile;
	String newsletterIndividu;
	String nomIndividu;
	String Nommagasin;
	String numerocarte;
	String prenomIndividu;
	String telfixe;
	String villeIndividu;
	Boolean vip;

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

	public String getMobile() {
		return this.mobile;
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

	public String getTelfixe() {
		return this.telfixe;
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

	public void setMobile(final String mobile) {
		this.mobile = mobile;
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

	public void setTelfixe(final String telfixe) {
		this.telfixe = telfixe;
	}

	public void setVilleIndividu(final String villeIndividu) {
		this.villeIndividu = villeIndividu;
	}

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}

	@Override
	public String toString() {
//		return "Clientcartedefidelite [idclient=" + this.idclient
//				+ ", numerocarte=" + this.numerocarte
//				+ ", Nommagasin=" + this.Nommagasin
//				+ ", civiliteIndividu=" + this.civiliteIndividu
//				+ ", nomIndividu="+ this.nomIndividu
//				+ ", prenomIndividu=" + this.prenomIndividu
//				+ ", adresseIndividu="+ this.adresseIndividu
//				+ ", villeIndividu=" + this.villeIndividu
//				+ ", codePostalIndividu="+ this.codePostalIndividu
//				+ ", dateNaissanceIndividu=" + this.dateNaissanceIndividu
//				+ ", email=" + this.email
//				+ ", newsletterIndividu=" + this.newsletterIndividu
//				+ ", age=" + this.age
//				+ ", telfixe=" + this.telfixe
//				+ ", mobile=" + this.mobile + "]";

		String phone = new String(
				(this.mobile != null) ?
						this.mobile
						: (this.telfixe != null) ?
								this.telfixe
								: "inconu"
		);

		String date=(this.dateNaissanceIndividu!=null)?	date =this.dateNaissanceIndividu:"?";

		System.out.print("vip : " +(this.vip) != null? this.vip:"null");
		return this.age + " ans"
				+ " - date " + date
				+ " - tél. " + phone
//				+ " - " + this.villeIndividu
				+ " > " + this.Nommagasin
				+" - VIP : "+(this.vip != null ? ((this.vip = true) ? "OUI":"NON"):"?");
	}

}
