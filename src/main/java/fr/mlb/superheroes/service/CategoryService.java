package fr.mlb.superheroes.service;

import java.util.List;

import fr.mlb.superheroes.bo.Category;

public interface CategoryService {
	public Category createOrUpdate(Category category);
	public void delete(Category category);
	public Category findById(Long id);
	public List<Category> findAll();
	public Category findByName(String name);
}
