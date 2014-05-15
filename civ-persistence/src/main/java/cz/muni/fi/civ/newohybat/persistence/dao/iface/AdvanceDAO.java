package cz.muni.fi.civ.newohybat.persistence.dao.iface;

import cz.muni.fi.civ.newohybat.persistence.entities.Advance;

public interface AdvanceDAO extends BaseDAO<Advance> {
	Advance getByIdent(String ident);
}
