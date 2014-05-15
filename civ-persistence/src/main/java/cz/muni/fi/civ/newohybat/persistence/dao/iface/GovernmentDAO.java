package cz.muni.fi.civ.newohybat.persistence.dao.iface;

import cz.muni.fi.civ.newohybat.persistence.entities.Government;

public interface GovernmentDAO extends BaseDAO<Government> {
	Government getByIdent(String ident);
}
