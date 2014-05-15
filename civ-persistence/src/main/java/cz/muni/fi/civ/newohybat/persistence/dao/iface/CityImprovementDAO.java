package cz.muni.fi.civ.newohybat.persistence.dao.iface;

import cz.muni.fi.civ.newohybat.persistence.entities.CityImprovement;

public interface CityImprovementDAO extends BaseDAO<CityImprovement> {
	CityImprovement getByIdent(String ident);
}
