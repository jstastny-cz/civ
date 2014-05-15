package cz.muni.fi.civ.newohybat.persistence.dao.iface;

import cz.muni.fi.civ.newohybat.persistence.entities.Terrain;

public interface TerrainDAO extends BaseDAO<Terrain> {
	Terrain getByIdent(String ident);
}
