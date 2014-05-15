package cz.muni.fi.civ.newohybat.persistence.services.iface;

import java.util.List;

import cz.muni.fi.civ.newohybat.persistence.entities.Unit;

public interface UnitService {

	Unit create(Unit unit);
	
	void update(Unit unit);
	
	void delete(Unit unit);
	
	Unit getById(Long id);
	
	List<Unit> getAll();
}
