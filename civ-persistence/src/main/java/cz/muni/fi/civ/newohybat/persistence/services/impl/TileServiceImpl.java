package cz.muni.fi.civ.newohybat.persistence.services.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.TileDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Tile;
import cz.muni.fi.civ.newohybat.persistence.services.iface.TileService;

@Stateless
public class TileServiceImpl implements TileService {
	@Inject
	private TileDAO dao;
	

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Tile create(Tile tile) {
		return dao.create(tile);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Tile tile) {
		dao.update(tile);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Tile tile) {
		dao.delete(tile);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Tile getById(Long id) {
		return dao.getById(id);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Tile> getAll() {
		return dao.getAll();
	}


	public Tile getByPosition(Long x, Long y) {
		return dao.getByPosition(x,y);
	}


	public Map<Long, List<Tile>> getTilesInRectangle(Long topLeftX,
			Long topLeftY, Long bottomRightX, Long bottomRightY) {
		return dao.getTilesInRectangle(topLeftX, topLeftY, bottomRightX, bottomRightY);
	}

}
