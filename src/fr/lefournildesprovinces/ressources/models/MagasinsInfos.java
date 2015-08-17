package fr.lefournildesprovinces.ressources.models;

public class MagasinsInfos {

	String AdresseMagasin;
	String CodePostalMagasin;
	String FaxMagasin;
	String MailMagasin;
	String NomMagasin;
	String telephoneMagasin;
	String VilleMagasin;

	public String getAdresseMagasin() {
		return this.AdresseMagasin;
	}

	public String getCodePostalMagasin() {
		return this.CodePostalMagasin;
	}

	public String getFaxMagasin() {
		return this.FaxMagasin;
	}

	public String getMailMagasin() {
		return this.MailMagasin;
	}

	public String getNomMagasin() {
		return this.NomMagasin;
	}

	public String getTelephoneMagasin() {
		return this.telephoneMagasin;
	}

	public String getVilleMagasin() {
		return this.VilleMagasin;
	}

	public void setAdresseMagasin(final String adresseMagasin) {
		this.AdresseMagasin = adresseMagasin;
	}

	public void setCodePostalMagasin(final String codePostalMagasin) {
		this.CodePostalMagasin = codePostalMagasin;
	}

	public void setFaxMagasin(final String faxMagasin) {
		this.FaxMagasin = faxMagasin;
	}

	public void setMailMagasin(final String mailMagasin) {
		this.MailMagasin = mailMagasin;
	}

	public void setNomMagasin(final String nomMagasin) {
		this.NomMagasin = nomMagasin;
	}

	public void setTelephoneMagasin(final String telephoneMagasin) {
		this.telephoneMagasin = telephoneMagasin;
	}

	public void setVilleMagasin(final String villeMagasin) {
		this.VilleMagasin = villeMagasin;
	}

	@Override
	public String toString() {
		return "MagasinsInfos [NomMagasin=" + this.NomMagasin
				+ ", AdresseMagasin=" + this.AdresseMagasin + ", VilleMagasin="
				+ this.VilleMagasin + ", CodePostalMagasin="
				+ this.CodePostalMagasin + ", telephoneMagasin="
				+ this.telephoneMagasin + ", FaxMagasin=" + this.FaxMagasin
				+ ", MailMagasin=" + this.MailMagasin + "]";
	}

}
