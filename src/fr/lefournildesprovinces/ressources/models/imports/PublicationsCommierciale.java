package fr.lefournildesprovinces.ressources.models.imports;

public enum PublicationsCommierciale {

	ALLOWED(true), //
	DENNIED(false),
	EMPTY(null);

	private final Boolean outputCode;

	PublicationsCommierciale(final Boolean code) {
		this.outputCode = code;

	}

	public static PublicationsCommierciale valueOfByCode(final String inputCode) {
		switch (inputCode) {
			case "OUI":
				return ALLOWED;
			case "NON": case "DESINSCRIT":
				return DENNIED;
			case "":
				return EMPTY;
			default:
				throw new IllegalArgumentException("invalid publicationCommerciale : "+ inputCode);
		}
	}

	public Boolean getCode() {
		return outputCode;
	}
}