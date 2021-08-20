package fr.mlb.superheroes.service;

import java.util.List;
import java.util.Optional;

import fr.mlb.superheroes.bo.SuperPower;

public interface SuperPowerService {
	public SuperPower createOrUpdate(SuperPower sp);
	public void delete(Long id);
	public SuperPower findById(Long id);
	public List<SuperPower> findAll();
}
