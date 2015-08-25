package fr.lefournildesprovinces.ressources.models.imports;

import java.util.Date;

public class FicheClient implements Client{

	/**
	 *
	 */
	private static final long serialVersionUID = 4805401902480534385L;
	private String numCli;
	private String civilite;
	private String nom;
	private String prenom;
	private String adresse;
	private String ville;
	private Integer codePostal;
	private String age;
	private String mail;
	private Boolean newsletter;
	private String magasin;
	private Integer telFix;
	private Integer telMob;
	private Date dateNaissance;

	public FicheClient() {
		// rien ...
	}

	public FicheClient(final String numCli) {
		this.numCli=numCli;
	}

	public FicheClient(final String civilite, final String nom, final String prenom, final String adresse , final String ville, final Integer codePostal, final Date dateNaissance, final String age, final String mail, final Boolean newsletter, final String numCli, final String magasin, final Integer telFix, final Integer telMob){
		this(numCli);
		this.civilite=civilite;
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.ville=ville;
		this.codePostal=codePostal;
		this.dateNaissance=dateNaissance;
		this.age=age;
		this.mail=mail;
		this.newsletter=newsletter;
		this.magasin=magasin;
		this.telFix=telFix;
		this.telMob=telMob;

	}

	@Override
	public String toString(){
		return "Client [nom= "+nom+" prenom= "+prenom+"]";

	}

	public String getNumCli() {
		return numCli;
	}

	public void setNumCli(String numCli) {
		this.numCli = numCli;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Boolean getNewsletter() {
		return newsletter;
	}

	public void setNewsletter(Boolean newsletter) {
		this.newsletter = newsletter;
	}

	public String getMagasin() {
		return magasin;
	}

	public void setMagasin(String magasin) {
		this.magasin = magasin;
	}

	public Integer getTelFix() {
		return telFix;
	}

	public void setTelFix(Integer telFix) {
		this.telFix = telFix;
	}

	public Integer getTelMob() {
		return telMob;
	}

	public void setTelMob(Integer telMob) {
		this.telMob = telMob;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date date) {
		this.dateNaissance = date;
	}



}
