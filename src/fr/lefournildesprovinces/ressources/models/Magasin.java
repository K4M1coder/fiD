package fr.lefournildesprovinces.ressources.models;

public class Magasin {

	int idMagasin;
	String nomMagasin;

	public Magasin() {
		this.idMagasin = 0;
		this.nomMagasin = "";
	}
	
	public int getIdMagasin() {
		return this.idMagasin;
	}

	public String getNomMagasin() {
		return this.nomMagasin;
	}

	public void setIdMagasin(final int idMagasin) {
		this.idMagasin = idMagasin;
	}

	public void setNomMagasin(final String nomMagasin) {
		this.nomMagasin = nomMagasin;
	}

	@Override
	public String toString() {
		return this.nomMagasin;
	}

}
