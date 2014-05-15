package cz.muni.fi.civ.newohybat.persistence.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.GovernmentDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Government;
import cz.muni.fi.civ.newohybat.persistence.services.iface.GovernmentService;

@Stateless
public class GovernmentServiceImpl implements GovernmentService {

	@Inject
	private GovernmentDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Government create(Government government) {
		return dao.create(government);

	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Government government) {
		dao.update(government);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Government government) {
		dao.delete(government);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Government getById(Long id) {
		return dao.getById(id);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Government getByIdent(String ident) {
		return dao.getByIdent(ident);
	}
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Government> getAll(){
		return dao.getAll();
	}
	
}
