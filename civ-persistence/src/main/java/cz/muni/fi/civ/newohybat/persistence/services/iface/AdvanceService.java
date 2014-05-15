package cz.muni.fi.civ.newohybat.persistence.services.iface;

import java.util.List;

import cz.muni.fi.civ.newohybat.persistence.entities.Advance;

public interface AdvanceService {
	Advance create(Advance advance);
	
	void update(Advance advance);
	
	void delete(Advance advance);
	
	Advance getById(Long id);
	
	Advance getByIdent(String ident);
	
	List<Advance> getAll();
}
