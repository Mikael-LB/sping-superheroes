package fr.mlb.superheroes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.mlb.superheroes.bo.SuperHero;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {

	@Override
	public SuperHero createOrUpdate(SuperHero superHero) {
		System.out.println("création de : " +superHero);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		System.out.println("suppression de l'id : " +id);
		// TODO Auto-generated method stub

	}

	@Override
	public SuperHero findById(int id) {
		System.out.println("recherche du super héros avec id : " +id);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SuperHero> findAll() {
		System.out.println("Récupération de la liste des super héros");
		// TODO Auto-generated method stub
		return null;
	}

}
