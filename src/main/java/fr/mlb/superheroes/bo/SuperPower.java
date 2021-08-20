package fr.mlb.superheroes.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SuperPower{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
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
	public SuperPower(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * Getters and Setters
	 * @return
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
