package fr.mlb.superheroes.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.mlb.superheroes.bo.SuperHero;

public interface SuperHeroDAO extends CrudRepository<SuperHero, Long> {

	List<SuperHero> findAllByOrderByNicknameAsc();

	List<SuperHero> findAllByOrderByNicknameDesc();

	List<SuperHero> findAllByOrderByFirstnameAsc();

	List<SuperHero> findAllByOrderByFirstnameDesc();

	List<SuperHero> findAllByOrderByLastnameAsc();

	List<SuperHero> findAllByOrderByLastnameDesc();

}
