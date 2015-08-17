package fr.lefournildesprovinces.ressources.models;

public class infostemporaire {

	int idMagasinTemporaire;
	int idoperationTemporaire;

	public int getIdMagasinTemporaire() {
		return this.idMagasinTemporaire;
	}

	public int getIdoperationTemporaire() {
		return this.idoperationTemporaire;
	}

	public void setIdMagasinTemporaire(final int idMagasinTemporaire) {
		this.idMagasinTemporaire = idMagasinTemporaire;
	}

	public void setIdoperationTemporaire(final int idoperationTemporaire) {
		this.idoperationTemporaire = idoperationTemporaire;
	}

	@Override
	public String toString() {
		return "infostemporaire [idMagasinTemporaire="
				+ this.idMagasinTemporaire + ", idoperationTemporaire="
				+ this.idoperationTemporaire + "]";
	}

}
