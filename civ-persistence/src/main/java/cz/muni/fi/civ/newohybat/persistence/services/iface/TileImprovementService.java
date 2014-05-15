package cz.muni.fi.civ.newohybat.persistence.services.iface;

import java.util.List;

import cz.muni.fi.civ.newohybat.persistence.entities.TileImprovement;

public interface TileImprovementService {
	TileImprovement create(TileImprovement improvement);
	
	void update(TileImprovement improvement);
	
	void delete(TileImprovement improvement);
	
	TileImprovement getById(Long id);
	
	TileImprovement getByIdent(String ident);
	
	List<TileImprovement> getAll();
}
