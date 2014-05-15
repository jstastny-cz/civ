package cz.muni.fi.civ.newohybat.persistence.services.iface;

import java.util.List;

import cz.muni.fi.civ.newohybat.persistence.entities.UnitType;

public interface UnitTypeService {
	UnitType create(UnitType type);
	
	void update(UnitType type);
	
	void delete(UnitType type);
	
	UnitType getById(Long id);
	
	UnitType getByIdent(String ident);
	
	List<UnitType> getAll();
}
