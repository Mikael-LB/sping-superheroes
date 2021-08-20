package fr.mlb.superheroes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.mlb.superheroes.bo.SuperPower;
import fr.mlb.superheroes.service.SuperPowerService;

@RestController
@RequestMapping("/superpower")
public class SuperPowerController {
	@Autowired
	private SuperPowerService superPowerService;
	
	@GetMapping("/add")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView("/frontoffice/createSuperPower");
		mav.addObject("superPowerForm",new SuperPower());
		return mav;
	}

	@PostMapping("/add")
	public ModelAndView createSuperPower(
			@ModelAttribute("superPowerForm") SuperPower sp
			) {
		ModelAndView mav = new ModelAndView("/frontoffice/createSuperPower");
		
		superPowerService.createOrUpdate(sp);
		
		return mav;
	}
	
	@GetMapping("/list")
	public ModelAndView showList() {
		ModelAndView mav = new ModelAndView("/frontoffice/listSuperPower");
		List<SuperPower>lstSuperPower = new ArrayList<SuperPower>();
		lstSuperPower = superPowerService.findAll();
		mav.addObject("lstSuperPower", lstSuperPower);
		return mav;
	}
	
	@PostMapping("/delete")
	public ModelAndView deleteSuperPower(
			@RequestParam("id") Long id
			) {
		//Memory : redirect:route and not redirect:nameOfJspFile
		ModelAndView mav = new ModelAndView("redirect:/superpower/list");
		superPowerService.delete(id);
		return mav;
	}
}
