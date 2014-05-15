package cz.muni.fi.civ.newohybat.persistence.dao.impl;



import java.util.List;

import javax.persistence.Query;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.UnitTypeDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.UnitType;

public class UnitTypeDAOImpl extends BaseDAOImpl<UnitType> implements
		UnitTypeDAO {

	@Override
	protected boolean isValid(UnitType object) {
		return object.getIdent()!=null && !object.getIdent().isEmpty()
				&& object.getName()!=null && !object.getName().isEmpty();
	}

	public UnitType getByIdent(String ident) {
		Query q = getEntityManager().createQuery("SELECT u FROM UnitType u WHERE u.ident=:ident");
		q.setParameter("ident", ident);
		List<UnitType> actionList = q.getResultList();
		if(!actionList.isEmpty()){
			return actionList.get(0);
		}
		return null;
	}


}
