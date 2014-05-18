package cz.muni.fi.civ.newohybat.game.init;

import cz.muni.fi.civ.newohybat.persistence.facade.dto.CityDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.UnitDTO;
/**
 * PersistenceHelper is a component which is responsible for actions connected with persisting
 * changes made by knowledge runtime.
 * @author newohybat
 *
 */
public interface PersistenceHelper {
	/**
	 * Method used to persist all altered objects from knowledgesession
	 */
	void persistDirtyObjects();
	/**
	 * Method used to create new city in database.
	 * @param city
	 * @return city with assigned id
	 */
	public CityDTO persistNewCity(CityDTO city);
	/**
	 * Method used to create new unit in database.
	 * @param unit
	 * @return unit with assigned id.
	 */
	public UnitDTO persistNewUnit(UnitDTO unit);
}
