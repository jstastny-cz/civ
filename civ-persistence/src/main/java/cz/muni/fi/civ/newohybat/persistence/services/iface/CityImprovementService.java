package cz.muni.fi.civ.newohybat.persistence.services.iface;

import java.util.List;

import cz.muni.fi.civ.newohybat.persistence.entities.CityImprovement;

public interface CityImprovementService {
	CityImprovement create(CityImprovement improvement);
	
	void update(CityImprovement improvement);
	
	void delete(CityImprovement improvement);
	
	CityImprovement getById(Long id);
	
	CityImprovement getByIdent(String ident);
	
	List<CityImprovement> getAll();
}
