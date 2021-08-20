package fr.mlb.superheroes.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import fr.mlb.superheroes.bo.Category;
import fr.mlb.superheroes.bo.CategoryEnum;
import fr.mlb.superheroes.bo.SuperHero;
import fr.mlb.superheroes.bo.SuperPower;
import fr.mlb.superheroes.service.CategoryService;
import fr.mlb.superheroes.service.SuperHeroService;
import fr.mlb.superheroes.service.SuperPowerService;

public class Utils {
	
	/**
	 * Method to initialize db's data with Super Heroes
	 */
	public static List<SuperHero> InitSuperHeroList(
			SuperHeroService shService,
			SuperPowerService spService,
			CategoryService categoryService
			) {
		List<SuperHero>lstSuperHeros = new ArrayList<SuperHero>();
		if(shService.findAll().isEmpty()) {
			List<SuperPower>lstSuperPower = spService.findAll();
			List<Category>lstCategory = categoryService.findAll();

			lstSuperHeros.add(
				shService.createOrUpdate(
						new SuperHero(
								"Iron Man",
								lstSuperPower.get(0),
								"Iron",
								"Man",
								LocalDate.now(),
								lstCategory.get(0)
								)
						)
				);
			lstSuperHeros.add(
				shService.createOrUpdate(
						new SuperHero(
								"Wonderwoman",
								lstSuperPower.get(1),								"Super",
								"Woman",
								LocalDate.now(),
								lstCategory.get(1)
								)
						)
				);
		}else {
			lstSuperHeros = shService.findAll();
		}
		return lstSuperHeros;
	}
	
	/**
	 * Method to initialize db's data with Super-Powers
	 */
	public static List<SuperPower> InitSuperPowerList(SuperPowerService spService){
		List<SuperPower> lstSuperPower = new ArrayList<SuperPower>();
		if (spService.findAll().isEmpty()) {
			lstSuperPower.add(
					spService.createOrUpdate(
							new SuperPower("Armure")));
			lstSuperPower.add(
					spService.createOrUpdate(
							new SuperPower("Fouet")));
			lstSuperPower.add(
					spService.createOrUpdate(
							new SuperPower("Laser")));
		}else {
			lstSuperPower = spService.findAll();
		}
		return lstSuperPower;
	}
	
	/**
	 * Method to initialize db's data with some Categories
	 */
	public static List<Category> InitCategoryList(CategoryService categoryService){
		List<Category> lstCategory = new ArrayList<Category>();
		if (categoryService.findAll().isEmpty()) {
			for(CategoryEnum cat : CategoryEnum.values()){
				lstCategory.add(
						categoryService.createOrUpdate(
								new Category(cat.getMessage())));
			}
		}else {
			lstCategory = categoryService.findAll();
		}
		return lstCategory;
	}
}
