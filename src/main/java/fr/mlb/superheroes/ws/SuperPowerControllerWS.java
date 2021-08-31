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

import fr.mlb.superheroes.bo.SuperPower;
import fr.mlb.superheroes.service.SuperPowerService;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
public class SuperPowerControllerWS {
	@Autowired
	SuperPowerService superPowerService;
	
	/**
	 * Method to get one SuperPower by his id
	 * @param idString
	 * @return a Http ResponseEntity with status
	 * - OK if it is found
	 * - BAD REQUEST if the id param can't be cast in Long
	 * - NOT_FOUND if this SuperPower can't be found or any other Exception
	 */
	@GetMapping("/superpower/{id}")
	public ResponseEntity<SuperPower> apiGetOneSuperPower(@PathVariable("id") String idString){
		Long id = 0l;
		SuperPower sp;
		try {
			id = Long.parseLong(idString);
			sp = superPowerService.findById(id);
		}catch(NumberFormatException nfe) {
			return new ResponseEntity<SuperPower>(HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			return new ResponseEntity<SuperPower>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<SuperPower>(sp, HttpStatus.OK);
	}
	
	/**
	 * Method to get all SuperPower
	 * @return a Http ResponseEntity with status :
	 * - OK if all work fine
	 * - NOT_FOUND if there is an Exception
	 */
	@GetMapping("/superpower")
	public ResponseEntity<List<SuperPower>> apiGetAllSuperPower(){
		List<SuperPower> lstSH;
		try {
			lstSH = superPowerService.findAll();
		}catch (Exception e) {
			return new ResponseEntity<List<SuperPower>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<SuperPower>>(lstSH, HttpStatus.OK);
	}
	
	/**
	 * Method to create a new SuperPower
	 * @param sh
	 * @return the SuperPowerCreated with status CREATED if ok, otherwise status CONFLICT
	 */
	@PostMapping("/superpower")
	public ResponseEntity<SuperPower> apiCreateOneSuperPower(
			@RequestBody SuperPower sh){
		SuperPower spCreated;
		try {
			spCreated=superPowerService.createOrUpdate(sh);
		}catch (Exception e) {
			return new ResponseEntity<SuperPower>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<SuperPower>(spCreated, HttpStatus.CREATED);
	}
	
	/**
	 * Method to update a SuperPower
	 * @param sh
	 * @return the SuperPowerCreated with status OK if ok, otherwise status CONFLICT
	 */
	@PutMapping("/superpower")
	public ResponseEntity<SuperPower> apiUpdateOneSuperPower(
			@RequestBody SuperPower sh){
		SuperPower spCreated;
		try {
			spCreated=superPowerService.createOrUpdate(sh);
		}catch (Exception e) {
			return new ResponseEntity<SuperPower>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<SuperPower>(spCreated, HttpStatus.OK);
	}
	
	/**
	 * Method to delete a SuperPower
	 * @param idString
	 * @return the status code :
	 * - OK if everything is ok
	 * - BAD_REQUEST if param idString can't be cast in Long
	 * - CONFLICT if SuperPower can't be find and/or delete
	 */
	@DeleteMapping("/superpower/{id}")
	public ResponseEntity<Void> apiDeleteOneSuperPower(
			@PathVariable("id") String idString){
		Long id = 0l;
		SuperPower sp;
		try {
			id = Long.parseLong(idString);
			sp=superPowerService.findById(id);
			superPowerService.delete(id);
		}catch(NumberFormatException nfe) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
