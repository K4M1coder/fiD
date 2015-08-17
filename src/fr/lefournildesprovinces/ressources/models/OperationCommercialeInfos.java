package fr.lefournildesprovinces.ressources.models;

import java.util.Date;

public class OperationCommercialeInfos {

	Date datebutOperationCommerciale;
	Date datefinOperationCommerciale;
	String libelleOperationCommerciale;

	public Date getDatebutOperationCommerciale() {
		return this.datebutOperationCommerciale;
	}

	public Date getDatefinOperationCommerciale() {
		return this.datefinOperationCommerciale;
	}

	public String getLibelleOperationCommerciale() {
		return this.libelleOperationCommerciale;
	}

	public void setDatebutOperationCommerciale(
			final Date datebutOperationCommerciale) {
		this.datebutOperationCommerciale = datebutOperationCommerciale;
	}

	public void setDatefinOperationCommerciale(
			final Date datefinOperationCommerciale) {
		this.datefinOperationCommerciale = datefinOperationCommerciale;
	}

	public void setLibelleOperationCommerciale(
			final String libelleOperationCommerciale) {
		this.libelleOperationCommerciale = libelleOperationCommerciale;
	}

	@Override
	public String toString() {
		return "OperationCommercialeInfos [libelleOperationCommerciale="
				+ this.libelleOperationCommerciale
				+ ", datebutOperationCommerciale="
				+ this.datebutOperationCommerciale
				+ ", datefinOperationCommerciale="
				+ this.datefinOperationCommerciale + "]";
	}

}
