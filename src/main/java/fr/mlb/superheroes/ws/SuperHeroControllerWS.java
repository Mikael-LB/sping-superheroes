package fr.mlb.superheroes.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.mlb.superheroes.bo.SuperHero;
import fr.mlb.superheroes.service.SuperHeroService;

@RestController
@RequestMapping("/api")
public class SuperHeroControllerWS {
	@Autowired
	SuperHeroService superHeroService;
	
	/**
	 * Method to get one SuperHero by his id
	 * @param idString
	 * @return a Http ResponseEntity with status
	 * - OK if it is found
	 * - BAD REQUEST if the id param can't be cast in Long
	 * - NOT_FOUND if this SuperHero can't be found or any other Exception
	 */
	@GetMapping("/superhero/{id}")
	public ResponseEntity<SuperHero> apiGetOneSuperHero(@PathVariable("id") String idString){
		Long id = 0l;
		SuperHero sh;
		try {
			id = Long.parseLong(idString);
			sh = superHeroService.findById(id);
		}catch(NumberFormatException nfe) {
			return new ResponseEntity<SuperHero>(HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			return new ResponseEntity<SuperHero>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<SuperHero>(sh, HttpStatus.OK);
	}
	
	/**
	 * Method to get all SuperHero
	 * @return a Http ResponseEntity with status :
	 * - OK if all work fine
	 * - NOT_FOUND if there is an Exception
	 */
	@GetMapping("/superhero")
	public ResponseEntity<List<SuperHero>> apiGetAllSuperHeroes(){
		List<SuperHero> lstSH;
		try {
			lstSH = superHeroService.findAll();
		}catch (Exception e) {
			return new ResponseEntity<List<SuperHero>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<SuperHero>>(lstSH, HttpStatus.OK);
	}
	
	/**
	 * Method to create a new SuperHero
	 * @param sh
	 * @return the SuperHeroCreated with status CREATED if ok, otherwise status CONFLICT
	 */
	@PostMapping("/superhero")
	public ResponseEntity<SuperHero> apiCreateOneSuperHero(
			@RequestBody SuperHero sh){
		SuperHero shCreated;
		try {
			shCreated=superHeroService.createOrUpdate(sh);
		}catch (Exception e) {
			return new ResponseEntity<SuperHero>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<SuperHero>(shCreated, HttpStatus.CREATED);
	}
	
	/**
	 * Method to update a SuperHero
	 * @param sh
	 * @return the SuperHeroCreated with status OK if ok, otherwise status CONFLICT
	 */
	@PutMapping("/superhero")
	public ResponseEntity<SuperHero> apiUpdateOneSuperHero(
			@RequestBody SuperHero sh){
		SuperHero shCreated;
		try {
			shCreated=superHeroService.createOrUpdate(sh);
		}catch (Exception e) {
			return new ResponseEntity<SuperHero>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<SuperHero>(shCreated, HttpStatus.OK);
	}
	
	/**
	 * Method to delete a SuperHero
	 * @param idString
	 * @return the status code :
	 * - OK if everything is ok
	 * - BAD_REQUEST if param idString can't be cast in Long
	 * - CONFLICT if SuperHero can't be find and/or delete
	 */
	@DeleteMapping("/superhero/{id}")
	public ResponseEntity<Void> apiDeleteOneSuperHero(
			@PathVariable("id") String idString){
		Long id = 0l;
		SuperHero sh;
		try {
			id = Long.parseLong(idString);
			sh=superHeroService.findById(id);
			superHeroService.delete(sh);
		}catch(NumberFormatException nfe) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
