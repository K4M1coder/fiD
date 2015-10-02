package fr.lefournildesprovinces.ressources.models;

public class Magasin implements Comparable<Magasin>{

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

	@Override
	public int compareTo(Magasin other) {
		// compareTo should return < 0 if this is supposed to be
		// less than other, > 0 if this is supposed to be greater than
		// other and 0 if they are supposed to be equal
		int last = 10;
		if (other != null){
			last = -10;
			if (this.nomMagasin != null){
				last = this.nomMagasin.compareTo(other.nomMagasin);
				}
		}
		return last;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    Magasin other = (Magasin) obj;
	    if (nomMagasin == null) {
	        if (other.nomMagasin != null)
	            return false;
	    } else if (!nomMagasin.equals(other.nomMagasin))
	        return false;
	    if (idMagasin == 0) {
	        if (other.idMagasin != 0)
	            return false;
	    } else if (!(idMagasin == (other.idMagasin)))
	        return false;
	    return true;
	}

}
