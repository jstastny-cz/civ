package cz.muni.fi.civ.newohybat.persistence.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.TileImprovementDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.TileImprovement;
import cz.muni.fi.civ.newohybat.persistence.services.iface.TileImprovementService;

@Stateless
public class TileImprovementServiceImpl implements TileImprovementService {
	@Inject
	private TileImprovementDAO dao;
	

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public TileImprovement create(TileImprovement improvement) {
		return dao.create(improvement);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(TileImprovement improvement) {
		dao.update(improvement);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(TileImprovement improvement) {
		dao.delete(improvement);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public TileImprovement getById(Long id) {
		return dao.getById(id);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public TileImprovement getByIdent(String ident) {
		return dao.getByIdent(ident);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<TileImprovement> getAll() {
		return dao.getAll();
	}

}
