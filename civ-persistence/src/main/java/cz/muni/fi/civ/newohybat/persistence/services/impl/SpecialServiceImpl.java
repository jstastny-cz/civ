package cz.muni.fi.civ.newohybat.persistence.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.SpecialDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Special;
import cz.muni.fi.civ.newohybat.persistence.services.iface.SpecialService;

@Stateless
public class SpecialServiceImpl implements SpecialService {
	@Inject
	private SpecialDAO dao;
	

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Special create(Special special) {
		return dao.create(special);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Special special) {
		dao.update(special);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Special special) {
		dao.delete(special);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Special getById(Long id) {
		return dao.getById(id);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Special getByIdent(String ident) {
		return dao.getByIdent(ident);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Special> getAll() {
		return dao.getAll();
	}

}
