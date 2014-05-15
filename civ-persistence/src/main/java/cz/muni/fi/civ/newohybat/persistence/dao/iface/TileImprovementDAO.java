package cz.muni.fi.civ.newohybat.persistence.dao.iface;



import cz.muni.fi.civ.newohybat.persistence.entities.TileImprovement;

public interface TileImprovementDAO extends BaseDAO<TileImprovement> {
	TileImprovement getByIdent(String ident);
}
