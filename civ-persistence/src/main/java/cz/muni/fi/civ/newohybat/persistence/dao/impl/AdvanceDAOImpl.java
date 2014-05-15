package cz.muni.fi.civ.newohybat.persistence.dao.impl;



import java.util.List;

import javax.persistence.Query;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.AdvanceDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Advance;

public class AdvanceDAOImpl extends BaseDAOImpl<Advance> implements AdvanceDAO {

	@Override
	protected boolean isValid(Advance object) {
		return object.getEnabledGovernments()!=null
				&& object.getEnabledCityImprovements()!=null
				&& object.getEnabledUnitTypes()!=null
				&& object.getIdent()!=null && !object.getIdent().isEmpty()
				&& object.getName()!=null && !object.getName().isEmpty();
	}

	public Advance getByIdent(String ident) {
		Query q = getEntityManager().createQuery("SELECT a FROM Advance a WHERE a.ident=:ident");
		q.setParameter("ident", ident);
		List<Advance> actionList = q.getResultList();
		if(!actionList.isEmpty()){
			return actionList.get(0);
		}
		return null;
	}

}
