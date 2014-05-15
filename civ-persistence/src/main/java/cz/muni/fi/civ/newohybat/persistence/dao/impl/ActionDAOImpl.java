package cz.muni.fi.civ.newohybat.persistence.dao.impl;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.ActionDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Action;

public class ActionDAOImpl extends BaseDAOImpl<Action> implements ActionDAO {

	@Override
	protected boolean isValid(Action object) {
		return object.getIdent()!=null && !object.getIdent().isEmpty()
				&& object.getName()!=null && !object.getName().isEmpty();
	}


	public Action getByIdent(String ident) {
		Query q = getEntityManager().createQuery("SELECT a FROM Action a WHERE a.ident=:ident");
		q.setParameter("ident", ident);
		List<Action> actionList = q.getResultList();
		if(!actionList.isEmpty()){
			return actionList.get(0);
		}
		return null;
	}


	public Set<Action> getActions(Set<String> idents) {
		Query q = getEntityManager().createQuery("SELECT a FROM Action a WHERE a.ident IN :idents", Action.class);
		q.setParameter("idents",idents);
		List<Action> actions = q.getResultList();
		return new HashSet<Action>(actions);
	}

	
}
