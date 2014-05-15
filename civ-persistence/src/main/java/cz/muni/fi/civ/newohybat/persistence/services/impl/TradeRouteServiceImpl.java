package cz.muni.fi.civ.newohybat.persistence.services.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.TradeRouteDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.TradeRoute;
import cz.muni.fi.civ.newohybat.persistence.services.iface.TradeRouteService;

@Stateless
public class TradeRouteServiceImpl implements TradeRouteService {
	@Inject
	private TradeRouteDAO dao;
	

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public TradeRoute create(TradeRoute route) {
		return dao.create(route);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(TradeRoute route) {
		dao.update(route);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(TradeRoute route) {
		dao.delete(route);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public TradeRoute getById(Long id) {
		return dao.getById(id);
	}

}
