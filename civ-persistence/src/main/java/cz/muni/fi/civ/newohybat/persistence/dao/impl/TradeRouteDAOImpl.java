package cz.muni.fi.civ.newohybat.persistence.dao.impl;



import cz.muni.fi.civ.newohybat.persistence.dao.iface.TradeRouteDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.TradeRoute;

public class TradeRouteDAOImpl extends BaseDAOImpl<TradeRoute> implements
		TradeRouteDAO {

	@Override
	protected boolean isValid(TradeRoute object) {
		return object.getDestination()!=null;
	}


}
