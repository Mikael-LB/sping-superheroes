package fr.mlb.superheroes.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.mlb.superheroes.bo.Category;
import fr.mlb.superheroes.bo.SuperHero;
import fr.mlb.superheroes.bo.SuperPower;

public class Utils {
	
	public static List<SuperHero> InitListe() {
		List<SuperHero>lstSuperHeros = new ArrayList<SuperHero>();
		lstSuperHeros.add(new SuperHero(
				"Iron Man",
				new SuperPower("Armure"),
				"Iron",
				"Man",
				LocalDate.now(),
				new Category("Fly")));
		lstSuperHeros.add(new SuperHero(
				"Wonderwoman",
				new SuperPower("Fouet"),
				"Super",
				"Woman",
				LocalDate.now(),
				new Category("Run")));
		
		return lstSuperHeros;
	}
	
	public static List<SuperPower> InitSuperPowerList(){
		List<SuperPower> lstSuperPower = new ArrayList<SuperPower>();
		lstSuperPower.add(new SuperPower("Armure"));
		lstSuperPower.add(new SuperPower("Fouet"));
		lstSuperPower.add(new SuperPower("Laser"));
		return lstSuperPower;
	}

}
