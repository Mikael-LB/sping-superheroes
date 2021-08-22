package fr.mlb.superheroes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mlb.superheroes.bo.SuperHero;
import fr.mlb.superheroes.dal.SuperHeroDAO;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {
	@Autowired
	SuperHeroDAO superHeroDao;

	@Override
	@Transactional
	public SuperHero createOrUpdate(SuperHero superHero) {
		return superHeroDao.save(superHero);
	}

	@Override
	@Transactional
	public void delete(SuperHero superHero) {
		superHeroDao.delete(superHero);
	}

	@Override
	public SuperHero findById(Long id) {
		return superHeroDao.findById(id).get();
	}

	@Override
	public List<SuperHero> findAll() {
		return (List<SuperHero>) superHeroDao.findAll();
	}

	@Override
	public List<SuperHero> findAllSortByNicknameAsc() {
		return (List<SuperHero>) superHeroDao.findAllByOrderByNicknameAsc();
	}

	@Override
	public List<SuperHero> findAllSortByNicknameDesc() {
		return (List<SuperHero>) superHeroDao.findAllByOrderByNicknameDesc();
	}

	@Override
	public List<SuperHero> findAllSortByFirstnameAsc() {
		return (List<SuperHero>) superHeroDao.findAllByOrderByFirstnameAsc();
	}

	@Override
	public List<SuperHero> findAllSortByFirstnameDesc() {
		return (List<SuperHero>) superHeroDao.findAllByOrderByFirstnameDesc();
	}

	@Override
	public List<SuperHero> findAllSortByLastnameAsc() {
		return (List<SuperHero>) superHeroDao.findAllByOrderByLastnameAsc();
	}

	@Override
	public List<SuperHero> findAllSortByLastnameDesc() {
		return (List<SuperHero>) superHeroDao.findAllByOrderByLastnameDesc();
	}

}
