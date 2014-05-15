package cz.muni.fi.civ.newohybat.persistence.dao.impl;



import java.util.List;

import javax.persistence.Query;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.SpecialDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Special;

public class SpecialDAOImpl extends BaseDAOImpl<Special> implements SpecialDAO {

	@Override
	protected boolean isValid(Special object) {
		return object.getIdent()!=null&&!object.getIdent().isEmpty()
				&& object.getName()!=null&&!object.getName().isEmpty()
				//&& object.getEffects()!=null;
				;
	}

	public Special getByIdent(String ident) {
		Query q = getEntityManager().createQuery("SELECT s FROM Special s WHERE s.ident=:ident");
		q.setParameter("ident", ident);
		List<Special> actionList = q.getResultList();
		if(!actionList.isEmpty()){
			return actionList.get(0);
		}
		return null;
	}




}
