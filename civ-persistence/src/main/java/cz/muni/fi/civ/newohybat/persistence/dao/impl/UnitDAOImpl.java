package cz.muni.fi.civ.newohybat.persistence.dao.impl;



import cz.muni.fi.civ.newohybat.persistence.dao.iface.UnitDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Unit;

public class UnitDAOImpl extends BaseDAOImpl<Unit> implements UnitDAO {

	@Override
	protected boolean isValid(Unit object) {
		return object.getActions()!=null
				&& object.getOwner()!=null
				&& object.getTile()!=null
				&& object.getType()!=null;
	}


	
}
