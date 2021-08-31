package fr.mlb.superheroes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView index() {
		
		ModelAndView mav = new ModelAndView("frontoffice/index");
		return mav;
	}
}
