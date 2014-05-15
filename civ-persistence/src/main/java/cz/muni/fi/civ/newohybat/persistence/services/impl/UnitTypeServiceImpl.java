package cz.muni.fi.civ.newohybat.persistence.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.UnitTypeDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.UnitType;
import cz.muni.fi.civ.newohybat.persistence.services.iface.UnitTypeService;

@Stateless
public class UnitTypeServiceImpl implements UnitTypeService {

	@Inject
	private UnitTypeDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public UnitType create(UnitType type) {
		return dao.create(type);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(UnitType type) {
		dao.update(type);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(UnitType type) {
		dao.delete(type);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public UnitType getById(Long id) {
		return dao.getById(id);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public UnitType getByIdent(String ident) {
		return dao.getByIdent(ident);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<UnitType> getAll() {
		return dao.getAll();
	}

}
