package cz.muni.fi.civ.newohybat.persistence.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.TerrainDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Terrain;
import cz.muni.fi.civ.newohybat.persistence.services.iface.TerrainService;

@Stateless
public class TerrainServiceImpl implements TerrainService {
	@Inject
	private TerrainDAO dao;
	

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Terrain create(Terrain terrain) {
		return dao.create(terrain);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Terrain terrain) {
		dao.update(terrain);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Terrain terrain) {
		dao.delete(terrain);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Terrain getById(Long id) {
		return dao.getById(id);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Terrain getByIdent(String ident) {
		return dao.getByIdent(ident);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Terrain> getAll() {
		return dao.getAll();
	}

}
