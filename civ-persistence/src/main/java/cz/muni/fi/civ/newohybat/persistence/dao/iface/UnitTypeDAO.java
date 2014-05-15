package cz.muni.fi.civ.newohybat.persistence.dao.iface;

import cz.muni.fi.civ.newohybat.persistence.entities.UnitType;

public interface UnitTypeDAO extends BaseDAO<UnitType> {
	UnitType getByIdent(String ident);
}
