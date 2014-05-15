package cz.muni.fi.civ.newohybat.persistence.services.iface;

import cz.muni.fi.civ.newohybat.persistence.entities.TradeRoute;

public interface TradeRouteService {

	TradeRoute create(TradeRoute route);
	
	void update(TradeRoute route);
	
	void delete(TradeRoute route);
	
	TradeRoute getById(Long id);
	
	
	
}
