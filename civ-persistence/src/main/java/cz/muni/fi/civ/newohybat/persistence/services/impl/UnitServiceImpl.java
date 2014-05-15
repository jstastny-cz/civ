package cz.muni.fi.civ.newohybat.persistence.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.UnitDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Unit;
import cz.muni.fi.civ.newohybat.persistence.services.iface.UnitService;

@Stateless
public class UnitServiceImpl implements UnitService {

	@Inject
	private UnitDAO dao;
	

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Unit create(Unit unit) {
		return dao.create(unit);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Unit unit) {
		dao.update(unit);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Unit unit) {
		dao.delete(unit);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Unit getById(Long id) {
		return dao.getById(id);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Unit> getAll() {
		return dao.getAll();
	}

}
