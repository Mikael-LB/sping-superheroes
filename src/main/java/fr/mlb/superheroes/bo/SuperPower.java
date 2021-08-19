package fr.mlb.superheroes.bo;

public class SuperPower {
	private Integer id;
	private String name;

	/**
	 * Constructor empty
	 */
	public SuperPower() {
		super();
	}

	/**
	 * Constructor with no id
	 * @param name
	 */
	public SuperPower(String name) {
		super();
		this.name = name;
	}

	/**
	 * Constructor with id
	 * @param id
	 * @param name
	 */
	public SuperPower(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * Getters and Setters
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "SuperPower [id=" + id + ", name=" + name + "]";
	}
}
