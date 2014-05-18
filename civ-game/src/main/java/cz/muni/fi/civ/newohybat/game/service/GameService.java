package cz.muni.fi.civ.newohybat.game.service;

import java.util.Collection;

import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import cz.muni.fi.civ.newohybat.persistence.facade.dto.AdvanceDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.CityDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.CityImprovementDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.GovernmentDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.PlayerDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.SpecialDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.TerrainDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.TileDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.TileImprovementDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.UnitDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.UnitTypeDTO;

public interface GameService {
	/**
	 * Method used as input to working memory. When the object is present within the memory it gets replace, 
	 * otherwise it is inserted fresh new. Decision is based upon equals and hashCode methods of object.
	 * @param o object to be inserted
	 */
	void insert(Object o);
	/**
	 * Method inserts each item from collection as a fact
	 * @param objects to be inserted
	 */
	void insertAll(Collection<? extends Object> objects);
	
	/**
	 * Method used to start the turn regime
	 */
	void startGame();
	/**
	 * Method used to stop the turn regime
	 */
	void stopGame();
	/**
	 * Method used to initialize knowledgesession before first use
	 */
	void init();
	/**
	 * Method used to load knowledgesession when persistence employed
	 * @param sessionId
	 */
	void load(Integer sessionId);
	/**
	 * Method getAdvance returns AdvanceDTO object for given ident from working memory.
	 * @param ident Identificator of desired AdvanceDTO 
	 * @return AdvanceDTO with given ident
	 */
	AdvanceDTO getAdvance(String ident);
	/**
	 * Method returns all AdvanceDTO objects for given identificators.
	 * @param idents
	 * @return collection of AdvanceDTO
	 */
	Collection<AdvanceDTO> getAdvances(Collection<String> idents);
	/**
	 * Method for getting all AdvanceDTO objects in game.
	 * @return
	 */
	Collection<AdvanceDTO> getAdvances();
	/**
	 * Method getCity serves to retreive a CityDTO object based on its id.
	 * @param id Long id of CityDTO
	 * @return	CityDTO with given id
	 */
	CityDTO getCity(Long id);
	/**
	 * Method used to retreive CityDTO objects based on their ids.
	 * @param ids
	 * @return
	 */
	Collection<CityDTO> getCities(Collection<Long> ids);
	/**
	 * Method used to retreive all CityDTO objects.
	 * @return
	 */
	Collection<CityDTO> getCities();
	/**
	 * Method getCityImprovement retreives CityImprovementDTO object with given ident.
	 * @param ident Ident of the CityImprovementDTO
	 * @return CityImprovementDTO with given ident
	 */
	CityImprovementDTO getCityImprovement(String ident);
	/**
	 * Method used to get object based on its identificator.
	 * @param idents
	 * @return
	 */
	Collection<CityImprovementDTO> getCityImprovements(Collection<String> idents);
	/**
	 * Method used to get objects based on their identificators.
	 * @return
	 */
	Collection<CityImprovementDTO> getCityImprovements();
	/**
	 * Method used to initiate construction of given CityImprovementDTO in given CityDTO
	 * @param cityId Long id of the city
	 * @param impIdent String ident of the improvement
	 */
	void cityBeginCityImprovement(Long cityId,String impIdent);
	/**
	 * Method used to abort construction of city improvement in a city
	 * @param cityId Long id of the city
	 */
	void cityStopCityImprovement(Long cityId);
	/**
	 * Method used to initiate creation of given UnitTypeDTO in given CityDTO
	 * @param cityId Long id of the city
	 * @param impIdent String ident of the unit type
	 */
	void cityBeginUnit(Long cityId, String unitTypeIdent);
	/**
	 * Method used to abort creation of new unit in a city
	 * @param cityId Long id of the city
	 */
	void cityStopUnit(Long cityId);
	/**
	 * Method used to get object based on its identificator.
	 * @param ident
	 * @return
	 */
	GovernmentDTO getGovernment(String ident);
	/**
	 * Method used to get objects based on their identificators.
	 * @param idents
	 * @return
	 */
	Collection<GovernmentDTO> getGovernments(Collection<String> idents);
	/**
	 * Method used to get objects.
	 * @return Collection<GovernmentDTO>
	 */
	Collection<GovernmentDTO> getGovernments();
	/**
	 * Method used to get object based on its identificator.
	 * @param id
	 * @return PlayerDTO player
	 */
	PlayerDTO getPlayer(Long id);
	/**
	 * Method used to get objects based on their identificators.
	 * @param ids
	 * @return Collection<PlayerDTO> players
	 */
	Collection<PlayerDTO> getPlayers(Collection<Long> ids);
	/**
	 * Method used to retreive all the players.
	 * @return
	 */
	Collection<PlayerDTO> getPlayers();
	/**
	 * Method used to initiate advance research for given player.
	 * @param playerId Long id of the player
	 * @param advanceIdent String ident of the AdvanceDTO
	 */
	void playerBeginAdvance(Long playerId, String advanceIdent);
	/**
	 * Method used to abort research for given player.
	 * @param playerId Long id of the player
	 */
	void playerStopAdvance(Long playerId);
	/**
	 * Method used to change government for the player.
	 * @param playerId Long id of the player
	 * @param governmentId String ident of the AdvanceDTO
	 */
	void playerChangeGovernment(Long playerId, String governmentId);
	/**
	 * Method used to get object based on its identificator.
	 * @param ident String
	 * @return SpecialDTO
	 */
	SpecialDTO getSpecial(String ident);
	/**
	 * Method used to get objects based on their identificators.
	 * @param idents Collection<String>
	 * @return Collection<SpecialDTO>
	 */
	Collection<SpecialDTO> getSpecials(Collection<String> idents);
	/**
	 * Method used to get all the SpecialDTO objects.
	 * @return Collection<SpecialDTO>
	 */
	Collection<SpecialDTO> getSpecials();
	/**
	 * Method used to get object based on its identificator.
	 * @param ident String ident
	 * @return TerrainDTO
	 */
	TerrainDTO getTerrain(String ident);
	/**
	 * Method used to get objects based on their identificators.
	 * @param idents Collection<String>
	 * @return Collection<TerrainDTO> terrains
	 */
	Collection<TerrainDTO> getTerrains(Collection<String> idents);
	/**
	 * Method to retreive all the TerrainDTO objects.
	 * @return Collection<TerrainDTO> terrains
	 */
	Collection<TerrainDTO> getTerrains();
	
	/**
	 * Method used to get object based on its identificator.
	 * @param id Long id of the tile
	 * @return TileDTO
	 */
	TileDTO getTile(Long id);
	/**
	 * Method used to get objects based on their identificators.
	 * @param ids Collection<Long>
	 * @return Collection<TileDTO>
	 */
	Collection<TileDTO> getTiles(Collection<Long> ids);
	/**
	 * Retreives all the TileDTO objects.
	 * @return
	 */
	Collection<TileDTO> getTiles();
	/**
	 * Method used to get object based on its identificator.
	 * @param ident String 
	 * @return Collection<TileImprovementDTO>
	 */
	TileImprovementDTO getTileImprovement(String ident);
	/**
	 * Method used to get objects based on their identificators.
	 * @param ident Collection<String>
	 * @return Collection<TileImprovementDTO>
	 */
	Collection<TileImprovementDTO> getTileImprovements(Collection<String> ident);
	/**
	 * Retreive all the TileImprovementDTO objects.
	 * @return
	 */
	Collection<TileImprovementDTO> getTileImprovements();
	
	/**
	 * Method used to get object based on its identificator.
	 * @param id
	 * @return
	 */
	UnitDTO getUnit(Long id);
	/**
	 * Method used to get objects based on their identificators.
	 * @param ids
	 * @return
	 */
	Collection<UnitDTO> getUnits(Collection<Long> ids);
	/**
	 * Retreives all the UnitDTO objects.
	 * @return
	 */
	Collection<UnitDTO> getUnits();
	/**
	 * Initiates given action for given unit.
	 * @param unitId Long id of the unit
	 * @param actionIdent String ident of the ActionDTO
	 */
	void unitBeginAction(Long unitId, String actionIdent);
	/**
	 * Begin move to target for given unit.
	 * @param id Long id of the unit
	 * @param actionIdent String ident of the action
	 * @param targetTile Long id of target
	 */
	void unitBeginMove(Long id, String actionIdent, Long targetTile);
	/**
	 * Stops current action for given unit.
	 * @param id
	 */
	void unitStopAction(Long id);
	/**
	 * Stops current move for given unit.
	 * @param id
	 */
	void unitStopMove(Long id);
	/**
	 * Remove unit if is stated as dead.
	 * @param id
	 */
	void removeDeadUnit(Long id);
	/**
	 * Method used to get object based on its identificator.
	 * @param ident
	 * @return
	 */
	UnitTypeDTO getUnitType(String ident);
	/**
	 * Method used to get objects based on their identificators.
	 * @param idents
	 * @return
	 */
	Collection<UnitTypeDTO> getUnitTypes(Collection<String>idents);
	/**
	 * Retreives all the UnitTypeDTO objects.
	 * @return
	 */
	Collection<UnitTypeDTO> getUnitTypes();
}
