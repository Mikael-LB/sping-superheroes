package fr.mlb.superheroes.dal;

import org.springframework.data.repository.CrudRepository;

import fr.mlb.superheroes.bo.SuperPower;

public interface SuperPowerDAO extends CrudRepository<SuperPower, Long> {

}
