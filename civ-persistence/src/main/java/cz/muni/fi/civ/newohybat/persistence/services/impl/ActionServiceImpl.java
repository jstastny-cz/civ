package cz.muni.fi.civ.newohybat.persistence.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.ActionDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Action;
import cz.muni.fi.civ.newohybat.persistence.services.iface.ActionService;

@Stateless
public class ActionServiceImpl implements ActionService {
	@Inject
	private ActionDAO dao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Action create(Action action) {
		return dao.create(action);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Action action) {
		dao.update(action);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(Action action) {
		dao.delete(action);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Action getById(Long id) {
		return dao.getById(id);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Action getByIdent(String ident) {
		return dao.getByIdent(ident);
	}
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Action> getAll() {
		return dao.getAll();
	}

}
