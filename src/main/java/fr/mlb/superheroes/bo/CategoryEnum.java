package fr.mlb.superheroes.bo;

public enum CategoryEnum {
	Gentil("Gentil"),
	Méchant("Méchant"),
	GentilMéchant("Gentil/Méchant");
	
	private String message;

	CategoryEnum(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
