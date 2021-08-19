package fr.mlb.superheroes.service;

import java.util.List;

import fr.mlb.superheroes.bo.SuperHero;

public interface SuperHeroService {
	public SuperHero createOrUpdate(SuperHero superHero);
	public void delete(int id);
	public SuperHero findById(int id);
	public List<SuperHero> findAll();
}
