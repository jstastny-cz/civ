package cz.muni.fi.civ.newohybat.persistence.dao.impl;



import java.util.List;

import javax.persistence.Query;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.GovernmentDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Government;

public class GovernmentDAOImpl extends BaseDAOImpl<Government> implements
		GovernmentDAO {

	@Override
	protected boolean isValid(Government object) {
		return object.getIdent()!=null && !object.getIdent().isEmpty()
				&& object.getName()!=null && !object.getName().isEmpty();
	}

	public Government getByIdent(String ident) {
		Query q = getEntityManager().createQuery("SELECT g FROM Government g WHERE g.ident=:ident");
		q.setParameter("ident", ident);
		List<Government> actionList = q.getResultList();
		if(!actionList.isEmpty()){
			return actionList.get(0);
		}
		return null;
	}

}
