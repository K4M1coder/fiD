package fr.lefournildesprovinces.ressources.models;

public class DateNaissanceClient {

	String datenaissance;

	public String getDatenaissance() {
		return this.datenaissance;
	}

	public void setDatenaissance(final String datenaissance) {
		this.datenaissance = datenaissance;
	}

	@Override
	public String toString() {
		return this.datenaissance;
	}

}
