package fr.lefournildesprovinces.ressources.models.imports;

public enum Civilite {
	MR("MR"), //
	MME("MME"),
	NR("");

 private final String code;

 Civilite(final String code){
	 this.code=code;
 }
 public static Civilite valueOfByCode(final String code){
	 switch (code) {
	 case "MR":
		 return MR;
	 case "MME":
		 return MME;
	 case "" : case "NR":
		 return NR;
	default:
		throw new IllegalArgumentException("invalid civilite");

	 }
 }

 public Boolean isEmpty(){
	 return this == NR;
 }

 public String getCode(){

	 return code;
 }
}

