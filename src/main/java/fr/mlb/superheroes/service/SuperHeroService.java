package fr.mlb.superheroes.service;

import java.util.List;

import fr.mlb.superheroes.bo.SuperHero;

public interface SuperHeroService {
	public SuperHero createOrUpdate(SuperHero superHero);
	public void delete(SuperHero superHero);
	public SuperHero findById(Long id);
	public List<SuperHero> findAll();
	public List<SuperHero> findAllSortByNicknameAsc();
	public List<SuperHero> findAllSortByNicknameDesc();
	public List<SuperHero> findAllSortByFirstnameAsc();
	public List<SuperHero> findAllSortByFirstnameDesc();
	public List<SuperHero> findAllSortByLastnameAsc();
	public List<SuperHero> findAllSortByLastnameDesc();
}
