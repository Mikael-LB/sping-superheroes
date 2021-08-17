package fr.mlb.superheroes.bo;

public class SuperHero {
	
	private String nickname;
	private String superpower;
	private String firstname;
	private String lastname;
	
	public SuperHero() {
		super();
	}

	public SuperHero(String nickname, String superpower, String firstname, String lastname) {
		super();
		this.nickname = nickname;
		this.superpower = superpower;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSuperpower() {
		return superpower;
	}

	public void setSuperpower(String superpower) {
		this.superpower = superpower;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "SuperHero [nickname=" + nickname + ", superpower=" + superpower + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}
}
