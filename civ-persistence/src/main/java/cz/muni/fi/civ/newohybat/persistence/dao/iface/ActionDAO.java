package cz.muni.fi.civ.newohybat.persistence.dao.iface;

import java.util.Set;

import cz.muni.fi.civ.newohybat.persistence.entities.Action;

public interface ActionDAO extends BaseDAO<Action> {
	Action getByIdent(String ident);
	
	Set<Action> getActions(Set<String> idents);
}
