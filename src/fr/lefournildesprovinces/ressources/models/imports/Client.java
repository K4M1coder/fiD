package fr.lefournildesprovinces.ressources.models.imports;

import java.io.Serializable;
import java.util.Date;

public interface Client extends Serializable {

	String getCivilite();
	String getNom();
	String getPrenom();
	String getAdresse();
	String getVille();
	Integer getCodePostal();
	Date getDateNaissance();
	String getAge();
	String getMail();
	Boolean getNewsletter();
	String getNumCli();
	String getMagasin();
	Integer getTelFix();
	Integer getTelMob();

}
