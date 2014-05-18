package cz.muni.fi.civ.newohybat.persistence.facade.iface;

import java.util.List;
import java.util.Map;

//import com.google.common.collect.Table;




import cz.muni.fi.civ.newohybat.persistence.facade.dto.ActionDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.AdvanceDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.CityDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.CityImprovementDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.GovernmentDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.PlayerDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.SpecialDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.TerrainDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.TileDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.TileImprovementDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.TradeRouteDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.UnitDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.UnitTypeDTO;
/**
 * Serves as interface to a component which manages persisting objects.
 * @author newohybat
 *
 */
public interface CivBackend {
	/**
	 * Updates given object in db.
	 * @param o
	 */
	void update(Object o);
	/**
	 * Creates a new action in db.
	 * @param action
	 * @return
	 */
	ActionDTO create(ActionDTO action);
	/**
	 * Updates given action in db.
	 * @param action
	 */
	void update(ActionDTO action);
	/**
	 * Deletes given action from db.
	 * @param action
	 */
	void delete(ActionDTO action);
	/**
	 * Retreives action by its ident.
	 * @param ident
	 * @return
	 */
	ActionDTO getActionByIdent(String ident);
	/**
	 * Lists all the actions.
	 * @return
	 */
	List<ActionDTO> getActions();
	/**
	 * create advance object in db.
	 * @param advance
	 * @return
	 */
	AdvanceDTO create(AdvanceDTO advance);
	/**
	 * update given advance in db.
	 * @param advance
	 */
	void update(AdvanceDTO advance);
	/**
	 * delete given advance from db.
	 * @param advance
	 */
	void delete(AdvanceDTO advance);
	AdvanceDTO getAdvanceById(Long id);
		
	AdvanceDTO getAdvanceByIdent(String ident);
	
	List<AdvanceDTO> getAdvances();
	
	Map<String, AdvanceDTO> getAdvancesAsMap();
	
	CityDTO create(CityDTO city);
	
	void update(CityDTO city);
	
	void delete(CityDTO city);
	
	CityDTO getCityById(Long id);
	
	List<CityDTO> getCities();
	
	CityImprovementDTO create(CityImprovementDTO imp);
	
	void update(CityImprovementDTO imp);
	
	void delete(CityImprovementDTO imp);
	
	CityImprovementDTO getCityImprovementById(Long id);
	
	CityImprovementDTO getCityImprovementByIdent(String ident);
	
	List<CityImprovementDTO> getCityImprovements();
	
	Map<String,CityImprovementDTO> getCityImprovementsAsMap();
	
	GovernmentDTO create(GovernmentDTO imp);
	
	void update(GovernmentDTO imp);
	
	void delete(GovernmentDTO imp);
	
	GovernmentDTO getGovernmentById(Long id);
	
	GovernmentDTO getGovernmentByIdent(String ident);
	
	List<GovernmentDTO> getGovernments();
	
	Map<String,GovernmentDTO> getGovernmentsAsMap();
		
	PlayerDTO create(PlayerDTO player);
	
	void update(PlayerDTO player);
	
	void delete(PlayerDTO player);
	
	PlayerDTO getPlayerById(Long id);
	
	List<PlayerDTO> getPlayers();
	
	SpecialDTO create(SpecialDTO special);
	
	void update(SpecialDTO special);
	
	void delete(SpecialDTO special);
	
	SpecialDTO getSpecialById(Long id);
	
	SpecialDTO getSpecialByIdent(String ident);
	
	List<SpecialDTO> getSpecials();
	
	Map<String,SpecialDTO> getSpecialsAsMap();
	
	TerrainDTO create(TerrainDTO terrain);
	
	void update(TerrainDTO terrain);
	
	void delete(TerrainDTO terrain);
	
	TerrainDTO getTerrainById(Long id);
	
	TerrainDTO getTerrainByIdent(String ident);
	
	List<TerrainDTO> getTerrains();
	
	Map<String,TerrainDTO> getTerrainsAsMap();
	
	TileDTO create(TileDTO tile);
	
	void update(TileDTO tile);
	
	void delete(TileDTO tile);
	
	TileDTO getTileById(Long id);
	
	TileDTO getTileByPosition(Long posX, Long posY);
	
	Map<Long,List<TileDTO>> getTilesInRectangle(Long topLeftX, Long topLeftY, Long bottomRightX, Long bottomRightY);
	
	List<TileDTO> getTiles();
	
	TileImprovementDTO create(TileImprovementDTO imp);
	
	void update(TileImprovementDTO imp);
	
	void delete(TileImprovementDTO imp);
	
	TileImprovementDTO getTileImprovementById(Long id);
	
	TileImprovementDTO getTileImprovementByIdent(String ident);
	
	List<TileImprovementDTO> getTileImprovements();

	Map<String, TileImprovementDTO> getTileImprovementsAsMap();
	
	TradeRouteDTO create(TradeRouteDTO route);
	
	void update(TradeRouteDTO route);
	
	void delete(TradeRouteDTO route);
	
	TradeRouteDTO getTradeRouteById(Long id);
	
	UnitDTO create(UnitDTO unit);
	
	void update(UnitDTO unit);
	
	void delete(UnitDTO unit);
	
	UnitDTO getUnitById(Long id);
	
	List<UnitDTO> getUnits();
	
	UnitTypeDTO create(UnitTypeDTO unit);
	
	void update(UnitTypeDTO unit);
	
	void delete(UnitTypeDTO unit);
	
	UnitTypeDTO getUnitTypeById(Long id);
	
	UnitTypeDTO getUnitTypeByIdent(String ident);
	
	List<UnitTypeDTO> getUnitTypes();
	
	Map<String,UnitTypeDTO> getUnitTypesAsMap();
	
}
