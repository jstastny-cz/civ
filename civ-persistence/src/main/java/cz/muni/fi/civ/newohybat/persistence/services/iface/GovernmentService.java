package cz.muni.fi.civ.newohybat.persistence.services.iface;

import java.util.List;

import cz.muni.fi.civ.newohybat.persistence.entities.Government;

public interface GovernmentService {
	Government create(Government government);
	
	void update(Government government);
	
	void delete(Government government);
	
	Government getById(Long id);
	
	Government getByIdent(String ident);
	
	List<Government> getAll();
}
