package cz.muni.fi.civ.newohybat.persistence.dao.impl;



import java.util.List;

import javax.persistence.Query;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.CityImprovementDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.CityImprovement;

public class CityImprovementDAOImpl extends BaseDAOImpl<CityImprovement> implements
		CityImprovementDAO {

	@Override
	protected boolean isValid(CityImprovement object) {
		return object.getName()!=null && !object.getName().isEmpty()
				&& object.getIdent()!=null && !object.getIdent().isEmpty();
	}

	public CityImprovement getByIdent(String ident) {
		Query q = getEntityManager().createQuery("SELECT c FROM CityImprovement c WHERE c.ident=:ident");
		q.setParameter("ident", ident);
		List<CityImprovement> actionList = q.getResultList();
		if(!actionList.isEmpty()){
			return actionList.get(0);
		}
		return null;
	}


	

}
