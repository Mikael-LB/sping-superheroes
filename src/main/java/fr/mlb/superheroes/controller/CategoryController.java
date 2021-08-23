package fr.mlb.superheroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.mlb.superheroes.bo.Category;
import fr.mlb.superheroes.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/create")
	public ModelAndView showFormCreateCategory() {
		ModelAndView mav = new ModelAndView("/frontoffice/createCategory");
		Category categoryForm = new Category();
		mav.addObject("categoryForm", categoryForm);
		mav.addObject("categoryList", categoryService.findAll());
		return mav;
	}
	
	@PostMapping("/create")
	public ModelAndView createCategory(@ModelAttribute("categoryForm") Category cat) {
		ModelAndView mav = new ModelAndView("redirect:/category/create");
		categoryService.createOrUpdate(cat);
		return mav;
	}
}
