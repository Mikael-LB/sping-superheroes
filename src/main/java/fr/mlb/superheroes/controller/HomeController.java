package fr.mlb.superheroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.mlb.superheroes.service.CategoryService;
import fr.mlb.superheroes.service.SuperHeroService;
import fr.mlb.superheroes.service.SuperPowerService;
import fr.mlb.superheroes.utils.Utils;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView index() {
		
		ModelAndView mav = new ModelAndView("frontoffice/index");
		return mav;
	}
}
