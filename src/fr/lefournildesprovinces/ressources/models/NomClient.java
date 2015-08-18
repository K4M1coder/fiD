	package fr.lefournildesprovinces.ressources.models;

//import java.util.Comparator;

public class NomClient implements Comparable<NomClient> {

	String nom;

	public String getNom() {
		return this.nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return this.nom;
	}

	@Override
	public int compareTo(NomClient other) {
		// compareTo should return < 0 if this is supposed to be
		// less than other, > 0 if this is supposed to be greater than
		// other and 0 if they are supposed to be equal
		int last = 10;
		if (other != null){
			last = -10;
			if (this.nom != null){
				last = this.nom.compareTo(other.nom);
				}
		}
		return last;


		// last = (other.nom.equals(null)) ? -10 : (this.nom.equals(null)) ? 10 : this.nom.compareTo(other.nom);
		// return last == 0 ? this.nom.compareTo(other.nom) : last;
		// return Comparators.NAME.compare(this, other);

		//
		// the following could be used later...
		//
		// /**
		// * List the authors. Sort them by name so it will look good.
		// */
		// public List<NomClient> listNomClient(){
		// List<NomClient> nomClients = readNomClientsFromFileOrSomething();
		// Collections.sort(authors);
		// return authors;
		// }
		//
		// /**
		// * List unique authors. Sort them by name so it will look good.
		// */
		// public SortedSet<NomClient> listUniqueNomClients(){
		// List<NomClient> nomClients = readNomClientsFromFileOrSomething();
		// return new TreeSet<NomClient>(nomClients);
		// }

	}
//	public static class Comparators {
//
//        public static Comparator<NomClient> NAME = new Comparator<NomClient>() {
//            @Override
//            public int compare(NomClient o1, NomClient o2) {
//                int result = 10;
//                if (o2 != null){
//                	result =-10;
//                	if (o1 != null){
//                		result = o1.nom.compareTo(o2.nom);
//                	}
//                }
//                System.out.println(o2);
//
////                result = o1.nom.compareTo("o2"+ o2.nom);
//                return result;
//            }
//        };
//        public static Comparator<NomClient> AGE = new Comparator<NomClient>() {
//            @Override
//            public int compare(NomClient o1, NomClient o2) {
//                return o1.age - o2.age;
//            }
//        };
//        public static Comparator<NomClient> NAMEANDAGE = new Comparator<NomClient>() {
//            @Override
//            public int compare(NomClient o1, NomClient o2) {
//                int i = o1.name.compareTo(o2.name);
//                if (i == 0) {
//                    i = o1.age - o2.age;
//                }
//                return i;
//            }
//        };
    }
