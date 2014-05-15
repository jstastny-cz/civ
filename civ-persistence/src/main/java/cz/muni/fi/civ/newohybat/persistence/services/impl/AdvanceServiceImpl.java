package cz.muni.fi.civ.newohybat.persistence.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.AdvanceDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Advance;
import cz.muni.fi.civ.newohybat.persistence.services.iface.AdvanceService;

@Stateless
public class AdvanceServiceImpl implements AdvanceService {
	@Inject
	private AdvanceDAO dao;
	

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Advance create(Advance advance) {
		return dao.create(advance);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Advance advance) {
		dao.update(advance);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Advance advance) {
		dao.delete(advance);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Advance getById(Long id) {
		return dao.getById(id);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Advance getByIdent(String ident) {
		return dao.getByIdent(ident);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Advance> getAll() {
		return dao.getAll();
	}

}
