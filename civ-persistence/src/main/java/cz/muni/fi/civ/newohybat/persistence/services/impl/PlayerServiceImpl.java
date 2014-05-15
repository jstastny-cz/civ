package cz.muni.fi.civ.newohybat.persistence.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.PlayerDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Player;
import cz.muni.fi.civ.newohybat.persistence.services.iface.PlayerService;

@Stateless
public class PlayerServiceImpl implements PlayerService {
	@Inject
	PlayerDAO dao;
	

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Player create(Player player) {
		return dao.create(player);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Player player) {
		dao.update(player);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Player player) {
		dao.delete(player);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Player getById(Long id) {
		return dao.getById(id);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Player> getAll() {
		return dao.getAll();
	}

}
