package fr.mlb.superheroes.dal.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import fr.mlb.superheroes.service.CategoryService;
import fr.mlb.superheroes.service.SuperHeroService;
import fr.mlb.superheroes.service.SuperPowerService;
import fr.mlb.superheroes.utils.Utils;

@Component
public class FixturesData {
	@Autowired
	SuperPowerService spService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	SuperHeroService shService;

	@EventListener
	public void appReady(ApplicationEvent event) {
		// init data in db
		Utils.InitSuperPowerList(spService);
		Utils.InitCategoryList(categoryService);
		Utils.InitSuperHeroList(shService, spService, categoryService);
	}
}
