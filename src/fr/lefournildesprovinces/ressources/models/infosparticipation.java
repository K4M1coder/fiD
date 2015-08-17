package fr.lefournildesprovinces.ressources.models;

public class infosparticipation {

	String date;
	String libelleoperationcommerciale;
	String nommagasin;

	public String getDate() {
		return this.date;
	}

	public String getLibelleoperationcommerciale() {
		return this.libelleoperationcommerciale;
	}

	public String getNommagasin() {
		return this.nommagasin;
	}

	public void setDate(final String date) {
		this.date = date;
	}

	public void setLibelleoperationcommerciale(
			final String libelleoperationcommerciale) {
		this.libelleoperationcommerciale = libelleoperationcommerciale;
	}

	public void setNommagasin(final String nommagasin) {
		this.nommagasin = nommagasin;
	}

	@Override
	public String toString() {
		return this.libelleoperationcommerciale + " " + this.nommagasin + " "
				+ this.date;
	}

}
