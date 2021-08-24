package fr.mlb.superheroes.bo;

public enum CategoryEnum {
	Gentil("good"),
	Méchant("bad"),
	GentilMéchant("goodbad");
	
	private String message;

	CategoryEnum(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
