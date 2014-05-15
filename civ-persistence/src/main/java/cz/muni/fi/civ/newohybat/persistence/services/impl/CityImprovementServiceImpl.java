package cz.muni.fi.civ.newohybat.persistence.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.CityImprovementDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.CityImprovement;
import cz.muni.fi.civ.newohybat.persistence.services.iface.CityImprovementService;

@Stateless
public class CityImprovementServiceImpl implements CityImprovementService {
	@Inject
	CityImprovementDAO dao;
		

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public CityImprovement create(CityImprovement improvement) {
		return dao.create(improvement);

	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(CityImprovement improvement) {
		dao.update(improvement);

	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(CityImprovement improvement) {
		dao.delete(improvement);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public CityImprovement getById(Long id) {
		return dao.getById(id);
	}


	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public CityImprovement getByIdent(String ident) {
		return dao.getByIdent(ident);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<CityImprovement> getAll() {
		return dao.getAll();
	}

}
