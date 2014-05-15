package cz.muni.fi.civ.newohybat.persistence.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.CityDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.City;
import cz.muni.fi.civ.newohybat.persistence.services.iface.CityService;

@Stateless
public class CityServiceImpl implements CityService {

	@Inject
	private CityDAO dao;
	

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public City create(City city) {
		return dao.create(city);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(City city) {
		dao.update(city);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(City city) {
		dao.delete(city);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public City getById(Long id) {
		return dao.getById(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<City> getAll() {
		return dao.getAll();
	}

}
