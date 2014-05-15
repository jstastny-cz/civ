package cz.muni.fi.civ.newohybat.persistence.dao.impl;


import cz.muni.fi.civ.newohybat.persistence.dao.iface.PlayerDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Player;

public class PlayerDAOImpl extends BaseDAOImpl<Player> implements PlayerDAO {

	@Override
	protected boolean isValid(Player object) {
		return object.getName()!=null && !object.getName().isEmpty()
				&& object.getAdvances()!=null;
	}


}
