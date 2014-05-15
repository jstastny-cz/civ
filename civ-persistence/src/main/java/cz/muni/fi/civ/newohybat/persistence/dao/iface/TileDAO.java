package cz.muni.fi.civ.newohybat.persistence.dao.iface;

import java.util.List;
import java.util.Map;

import cz.muni.fi.civ.newohybat.persistence.entities.Tile;

public interface TileDAO extends BaseDAO<Tile> {
	Tile getByPosition(Long x, Long y);
	
	Map<Long,List<Tile>> getTilesInRectangle(Long topLeftX,Long topLeftY, Long bottomRightX, Long bottomRightY);
}
