package fr.mlb.superheroes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.mlb.superheroes.bo.Category;
import fr.mlb.superheroes.bo.CategoryEnum;
import fr.mlb.superheroes.bo.SuperHero;
import fr.mlb.superheroes.utils.Utils;

@RestController
public class SuperHeroController {
	private List<SuperHero> lstSuperHeros = Utils.InitListe();

	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("frontoffice/listSuperHeros");

		mav.addObject("listSuperHero", lstSuperHeros);
		return mav;
	}

	@GetMapping("/detail")
	public ModelAndView detailOne(String idInString) {
		ModelAndView mav = new ModelAndView("frontoffice/detailOneSuperHero");
		int id = 0;
		try {
			id = Integer.parseInt(idInString);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		SuperHero sh = lstSuperHeros.get(id);
		mav.addObject("superHero", sh);
		return mav;
	}

	/**
	 * Method to acces to the form page to create a new SuperHero
	 * @return
	 */
	@GetMapping("/create")
	public ModelAndView showCreateForm() {
		ModelAndView mav = new ModelAndView("frontoffice/createSuperHero");
		CategoryEnum[] categoryEnum = CategoryEnum.values();
		mav.addObject("categoryEnum", categoryEnum);
		return mav;
	}
	
	/**
	 * Method to create a new SuperHero with user entries
	 * @param nickname
	 * @param superpower
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	@PostMapping("/createPost")
	public ModelAndView create(
			@RequestParam("nickname") String nickname,
			@RequestParam("superpower") String superpower,
			@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			@RequestParam("category") CategoryEnum categoryEnum
			) {
		ModelAndView mav = new ModelAndView("frontoffice/detailOneSuperHero");
		Category category = null;
		
		try {
			category = new Category(categoryEnum.getMessage());
		}catch (Exception e) {
			System.out.println("Erreur de conversion en Enum de la catégorie");
		}
		
		SuperHero sh = new SuperHero(nickname,superpower,firstname,lastname, category);		
		lstSuperHeros.add(sh);
		
		mav.addObject("superHero",sh);
		return mav;
	}
}
