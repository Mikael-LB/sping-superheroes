package fr.mlb.superheroes.dal;

import org.springframework.data.repository.CrudRepository;

import fr.mlb.superheroes.bo.Category;

public interface CategoryDAO extends CrudRepository<Category, Long> {

	Category findByName(String name);

}
