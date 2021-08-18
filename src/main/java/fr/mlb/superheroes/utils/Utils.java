package fr.mlb.superheroes.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.mlb.superheroes.bo.Category;
import fr.mlb.superheroes.bo.SuperHero;

public class Utils {
	
	public static List<SuperHero> InitListe() {
		List<SuperHero>lstSuperHeros = new ArrayList<SuperHero>();
		lstSuperHeros.add(new SuperHero("Iron Man", "Armure","Iron","Man",
				LocalDate.now(),
				new Category("Fly")));
		lstSuperHeros.add(new SuperHero("Wonderwoman", "Fouet","Super","Woman",
				LocalDate.now(),
				new Category("Run")));
		
		return lstSuperHeros;
	}

}
