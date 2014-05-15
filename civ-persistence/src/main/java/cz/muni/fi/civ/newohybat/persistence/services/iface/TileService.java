package cz.muni.fi.civ.newohybat.persistence.services.iface;

import java.util.List;
import java.util.Map;

import cz.muni.fi.civ.newohybat.persistence.entities.Tile;

public interface TileService {
	Tile create(Tile tile);
	
	void update(Tile tile);
	
	void delete(Tile tile);
	
	Tile getById(Long id);
	
	List<Tile> getAll();
	
	Tile getByPosition(Long x, Long y);
	
	/**
	 * Method retreives all the tiles specified by borders of rectangle specified by its top left and bottom right corners.
	 * @param topLeftX
	 * @param topLeftY
	 * @param bottomRightX
	 * @param bottomRightY
	 * @return Map where keys are x coordinates, values are lists of Tiles ordered by y coordinate.
	 */
	Map<Long,List<Tile>> getTilesInRectangle(Long topLeftX, Long topLeftY,
			Long bottomRightX, Long bottomRightY);
}
