package cz.muni.fi.civ.newohybat.persistence.services.iface;

import java.util.List;

import cz.muni.fi.civ.newohybat.persistence.entities.City;

public interface CityService {
	City create(City city);
	
	void update(City city);
	
	void delete(City city);
	
	City getById(Long id);
	
	List<City> getAll();
}
