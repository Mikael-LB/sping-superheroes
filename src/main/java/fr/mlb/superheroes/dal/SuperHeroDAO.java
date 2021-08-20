package fr.mlb.superheroes.dal;

import org.springframework.data.repository.CrudRepository;

import fr.mlb.superheroes.bo.SuperHero;

public interface SuperHeroDAO extends CrudRepository<SuperHero, Long> {

}
