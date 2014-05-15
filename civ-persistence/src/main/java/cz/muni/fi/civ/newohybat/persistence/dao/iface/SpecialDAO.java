package cz.muni.fi.civ.newohybat.persistence.dao.iface;

import cz.muni.fi.civ.newohybat.persistence.entities.Special;

public interface SpecialDAO extends BaseDAO<Special> {
	Special getByIdent(String ident);
}
