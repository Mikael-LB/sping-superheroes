package fr.mlb.superheroes.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.mlb.superheroes.bo.Category;
import fr.mlb.superheroes.bo.CategoryEnum;
import fr.mlb.superheroes.bo.SuperHero;
import fr.mlb.superheroes.bo.SuperPower;
import fr.mlb.superheroes.service.CategoryService;
import fr.mlb.superheroes.service.SuperHeroService;
import fr.mlb.superheroes.service.SuperPowerService;
import fr.mlb.superheroes.utils.Utils;

@RestController
@RequestMapping("/superheros")
public class SuperHeroController {
	private List<SuperHero> lstSuperHeros = Utils.InitListe();
	@Autowired
	private SuperHeroService superHeroService;
	@Autowired
	private SuperPowerService superPowerService;
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("frontoffice/listSuperHeros");

		mav.addObject("listSuperHero", lstSuperHeros);
		return mav;
	}

	@GetMapping("/detail/{id}")
	public ModelAndView detailOne(@PathVariable("id") String idInString) {
		ModelAndView mav = new ModelAndView("frontoffice/detailOneSuperHero");
		Long id = 0L;
		try {
			id = Long.parseLong(idInString);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("ici");
		SuperHero sh = superHeroService.findById(id);
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
		mav.addObject("superPowerList",superPowerService.findAll());
		mav.addObject("categoryEnum", categoryEnum);
		mav.addObject("superheroForm",
				new SuperHero("",
						new SuperPower(),
						"",
						"",
						LocalDate.now(),
						new Category()));
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
	@PostMapping("/create")
	public ModelAndView create(
			/*@ModelAttribute("superheroForm") SuperHero sh */
			@RequestParam("nickname") String nickname,
			@RequestParam("superpower") String superpowerIdString,
			@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			@RequestParam("dateOfBirth") String dateOfBirth,
			@RequestParam("category") CategoryEnum categoryEnum
			) {
		
		Category category = null;
		try {
			category = new Category(categoryEnum.getMessage());
			categoryService.createOrUpdate(category);
		}catch (Exception e) {
			System.out.println("Erreur de conversion en Enum de la catégorie");
		}
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Long id = Long.parseLong(superpowerIdString);
		System.out.println(id);
		SuperPower sp = superPowerService.findById(id);
		SuperHero sh = new SuperHero(nickname,sp,firstname,lastname,
				LocalDate.parse(dateOfBirth,df),category);		
		sh = superHeroService.createOrUpdate(sh);
		System.out.println(sh);
		//Memory : redirect:route and not redirect:nameOfJspFile
		ModelAndView mav = new ModelAndView("redirect:/superheros/detail/"
											+sh.getId());
		mav.addObject("superHero",sh);
		return mav;
	}
}
