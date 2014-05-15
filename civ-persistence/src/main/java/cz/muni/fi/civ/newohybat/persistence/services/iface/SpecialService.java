package cz.muni.fi.civ.newohybat.persistence.services.iface;

import java.util.List;

import cz.muni.fi.civ.newohybat.persistence.entities.Special;

public interface SpecialService {
	Special create(Special special);
	
	void update(Special special);
	
	void delete(Special special);
	
	Special getById(Long id);
	
	Special getByIdent(String ident);
	
	List<Special> getAll();
}
