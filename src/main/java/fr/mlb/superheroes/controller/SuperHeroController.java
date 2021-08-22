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
	
	@Autowired
	private SuperHeroService superHeroService;
	@Autowired
	private SuperPowerService superPowerService;
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/list/{sortBy}")
	public ModelAndView list(@PathVariable("sortBy")String sortBy) {
		List<SuperHero> lstSuperHeros = null;
		switch (sortBy) {
		case "sortByNicknameAsc":
			lstSuperHeros = superHeroService.findAllSortByNicknameAsc();
			break;
		case "sortByNicknameDesc":
			lstSuperHeros = superHeroService.findAllSortByNicknameDesc();
			break;
		case "sortByFirstameAsc":
			lstSuperHeros = superHeroService.findAllSortByFirstnameAsc();
			break;
		case "sortByFirstnameDesc":
			lstSuperHeros = superHeroService.findAllSortByFirstnameDesc();
			break;
		case "sortByLastnameAsc":
			lstSuperHeros = superHeroService.findAllSortByLastnameAsc();
			break;
		case "sortByLastnameDesc":
			lstSuperHeros = superHeroService.findAllSortByLastnameDesc();
			break;
		default:
			lstSuperHeros = superHeroService.findAll();
			break;
		}
		
		
		ModelAndView mav = new ModelAndView("frontoffice/listSuperHeros");
		mav.addObject("listSuperHero", lstSuperHeros);
		return mav;
	}

	@GetMapping("/detail/{id}")
	public ModelAndView detailOne(@PathVariable("id") String idInString) {		
		Long id = 0L;
		
		try {
			id = Long.parseLong(idInString);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		SuperHero sh = superHeroService.findById(id);
		
		ModelAndView mav = new ModelAndView("frontoffice/detailOneSuperHero");
		mav.addObject("superHero", sh);
		return mav;
	}

	/**
	 * Method to acces to the form page to create a new SuperHero
	 * @return
	 */
	@GetMapping("/create")
	public ModelAndView showCreateForm() {
		CategoryEnum[] categoryEnum = CategoryEnum.values();
		
		ModelAndView mav = new ModelAndView("frontoffice/createSuperHero");
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
			category = categoryService.findByName(categoryEnum.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());;
		}
		
		Long id = Long.parseLong(superpowerIdString);
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SuperPower sp = superPowerService.findById(id);
		
		SuperHero sh = new SuperHero(nickname,sp,firstname,lastname,
				LocalDate.parse(dateOfBirth,df),category);		
		sh = superHeroService.createOrUpdate(sh);
		
		//Memory : redirect:route and not redirect:nameOfJspFile
		ModelAndView mav = new ModelAndView("redirect:/superheros/detail/"
											+sh.getId());
		mav.addObject("superHero",sh);
		return mav;
	}
}
