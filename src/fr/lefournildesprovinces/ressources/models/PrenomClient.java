package fr.lefournildesprovinces.ressources.models;

public class PrenomClient implements Comparable<PrenomClient> {

	String prenom;

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return this.prenom;
	}

	@Override
	public int compareTo(PrenomClient other) {
//		int last = this.prenom.compareTo(other.prenom);
//		return last == 0 ? this.prenom.compareTo(other.prenom) : last;
		int last = 10;
		if (other != null){
			System.out.println("nom to string : "+this.prenom.toString());
			last = -10;
			if (this.prenom != null){
				System.out.println("compare to : "+other.prenom.toString());
				last = this.prenom.compareTo(other.prenom);
				}
		}
		return last;
	}

}
