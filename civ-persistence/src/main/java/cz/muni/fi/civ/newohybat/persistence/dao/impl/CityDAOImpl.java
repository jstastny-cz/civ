package cz.muni.fi.civ.newohybat.persistence.dao.impl;



import cz.muni.fi.civ.newohybat.persistence.dao.iface.CityDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.City;

public class CityDAOImpl extends BaseDAOImpl<City> implements CityDAO {

	@Override
	protected boolean isValid(City object) {
		return object.getHomeUnits()!=null
				&& object.getImprovements()!=null
				&& object.getSize()!=null
				&& object.getTradeRoutes()!=null;
	}

	protected boolean isIn(City object) {
		return this.getById(object.getId())!=null;
	}


}
