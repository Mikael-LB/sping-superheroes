package fr.mlb.superheroes.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mlb.superheroes.bo.SuperPower;
import fr.mlb.superheroes.dal.SuperPowerDAO;

@Service
public class SuperPowerServiceImpl implements SuperPowerService {
	
	@Autowired
	SuperPowerDAO superPowerDao;

	@Override
	@Transactional
	public SuperPower createOrUpdate(SuperPower sp) {
		return superPowerDao.save(sp);
	}

	@Override	
	@Transactional
	public void delete(Long id) {
		superPowerDao.deleteById(id);

	}

	@Override
	public SuperPower findById(Long id) {
		return superPowerDao.findById(id).get();
	}

	@Override
	public List<SuperPower> findAll() {
		return (List<SuperPower>) superPowerDao.findAll();
	}

}
