package cz.muni.fi.civ.newohybat.persistence.services.iface;

import java.util.List;

import cz.muni.fi.civ.newohybat.persistence.entities.Action;

public interface ActionService {

	Action create(Action action);
	
	void update(Action action);
	
	void delete(Action action);
	
	Action getById(Long id);
	
	Action getByIdent(String ident);
	
	List<Action> getAll();
}
