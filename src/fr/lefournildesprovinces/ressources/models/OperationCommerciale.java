package fr.lefournildesprovinces.ressources.models;

public class OperationCommerciale {

	int idOperationCommerciale;
	String LibelleOperationCommerciale;

	public int getIdOperationCommerciale() {
		return this.idOperationCommerciale;
	}

	public String getLibelleOperationCommerciale() {
		return this.LibelleOperationCommerciale;
	}

	public void setIdOperationCommerciale(final int idOperationCommerciale) {
		this.idOperationCommerciale = idOperationCommerciale;
	}

	public void setLibelleOperationCommerciale(
			final String libelleOperationCommerciale) {
		this.LibelleOperationCommerciale = libelleOperationCommerciale;
	}

	@Override
	public String toString() {
		return this.LibelleOperationCommerciale;
	}

}
