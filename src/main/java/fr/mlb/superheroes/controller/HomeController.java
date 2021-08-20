package fr.mlb.superheroes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.mlb.superheroes.bo.SuperHero;
import fr.mlb.superheroes.service.SuperPowerService;
import fr.mlb.superheroes.utils.Utils;

@RestController
public class HomeController {
	@Autowired
	SuperPowerService spService;
	
	@RequestMapping("/")
	public ModelAndView index() {
		Utils.InitSuperPowerList(spService);
		ModelAndView mav = new ModelAndView("frontoffice/index");
		return mav;
	}
}
