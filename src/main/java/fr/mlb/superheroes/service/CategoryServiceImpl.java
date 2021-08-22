package fr.mlb.superheroes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mlb.superheroes.bo.Category;
import fr.mlb.superheroes.dal.CategoryDAO;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDAO categorieDao;

	@Override
	@Transactional
	public Category createOrUpdate(Category category) {
		return categorieDao.save(category);
	}

	@Override
	@Transactional
	public void delete(Category category) {
		categorieDao.delete(category);
	}

	@Override
	public Category findById(Long id) {
		return categorieDao.findById(id).get();
	}

	@Override
	public List<Category> findAll() {
		return (List<Category>) categorieDao.findAll();
	}

	@Override
	public Category findByName(String name) {
		return categorieDao.findByName(name);
	}

}
