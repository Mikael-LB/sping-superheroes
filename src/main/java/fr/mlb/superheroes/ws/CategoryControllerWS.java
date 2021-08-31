package fr.mlb.superheroes.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.mlb.superheroes.bo.Category;
import fr.mlb.superheroes.service.CategoryService;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
public class CategoryControllerWS {
	@Autowired
	CategoryService categoryService;
	
	/**
	 * Method to get one Category by his id
	 * @param idString
	 * @return a Http ResponseEntity with status
	 * - OK if it is found
	 * - BAD REQUEST if the id param can't be cast in Long
	 * - NOT_FOUND if this Category can't be found or any other Exception
	 */
	@GetMapping("/category/{id}")
	public ResponseEntity<Category> apiGetOneCategory(@PathVariable("id") String idString){
		Long id = 0l;
		Category c;
		try {
			id = Long.parseLong(idString);
			c = categoryService.findById(id);
		}catch(NumberFormatException nfe) {
			return new ResponseEntity<Category>(HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Category>(c, HttpStatus.OK);
	}
	
	/**
	 * Method to get all Category
	 * @return a Http ResponseEntity with status :
	 * - OK if all work fine
	 * - NOT_FOUND if there is an Exception
	 */
	@GetMapping("/category")
	public ResponseEntity<List<Category>> apiGetAllCategory(){
		List<Category> lstSH;
		try {
			lstSH = categoryService.findAll();
		}catch (Exception e) {
			return new ResponseEntity<List<Category>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Category>>(lstSH, HttpStatus.OK);
	}
	
	/**
	 * Method to create a new Category
	 * @param sh
	 * @return the CategoryCreated with status CREATED if ok, otherwise status CONFLICT
	 */
	@PostMapping("/category")
	public ResponseEntity<Category> apiCreateOneCategory(
			@RequestBody Category c){
		Category catCreated;
		try {
			catCreated=categoryService.createOrUpdate(c);
		}catch (Exception e) {
			return new ResponseEntity<Category>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Category>(catCreated, HttpStatus.CREATED);
	}
	
	/**
	 * Method to update a Category
	 * @param sh
	 * @return the CategoryCreated with status OK if ok, otherwise status CONFLICT
	 */
	@PutMapping("/category")
	public ResponseEntity<Category> apiUpdateOneCategory(
			@RequestBody Category c){
		Category catCreated;
		try {
			catCreated=categoryService.createOrUpdate(c);
		}catch (Exception e) {
			return new ResponseEntity<Category>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Category>(catCreated, HttpStatus.OK);
	}
	
	/**
	 * Method to delete a Category
	 * @param idString
	 * @return the status code :
	 * - OK if everything is ok
	 * - BAD_REQUEST if param idString can't be cast in Long
	 * - CONFLICT if Category can't be find and/or delete
	 */
	@DeleteMapping("/category/{id}")
	public ResponseEntity<Void> apiDeleteOneCategory(
			@PathVariable("id") String idString){
		Long id = 0l;
		Category c;
		try {
			id = Long.parseLong(idString);
			c=categoryService.findById(id);
			categoryService.delete(c);
		}catch(NumberFormatException nfe) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
