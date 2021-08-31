package fr.mlb.superheroes.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@OneToMany(mappedBy = "id")
	private List<SuperHero>lstSuperHero;

	public Category() {
		super();
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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

	public List<SuperHero> getLstSuperHero() {
		return lstSuperHero;
	}

	public void setLstSuperHero(List<SuperHero> lstSuperHero) {
		this.lstSuperHero = lstSuperHero;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
}
