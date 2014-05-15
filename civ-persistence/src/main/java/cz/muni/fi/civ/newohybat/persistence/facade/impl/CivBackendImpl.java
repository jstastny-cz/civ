package cz.muni.fi.civ.newohybat.persistence.facade.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Stateless;
import javax.inject.Inject;
//
//import com.google.common.collect.HashBasedTable;
//import com.google.common.collect.Table;










import cz.muni.fi.civ.newohybat.persistence.entities.Action;
import cz.muni.fi.civ.newohybat.persistence.entities.Advance;
import cz.muni.fi.civ.newohybat.persistence.entities.City;
import cz.muni.fi.civ.newohybat.persistence.entities.CityImprovement;
import cz.muni.fi.civ.newohybat.persistence.entities.Government;
import cz.muni.fi.civ.newohybat.persistence.entities.Player;
import cz.muni.fi.civ.newohybat.persistence.entities.Special;
import cz.muni.fi.civ.newohybat.persistence.entities.Terrain;
import cz.muni.fi.civ.newohybat.persistence.entities.Tile;
import cz.muni.fi.civ.newohybat.persistence.entities.TileImprovement;
import cz.muni.fi.civ.newohybat.persistence.entities.Unit;
import cz.muni.fi.civ.newohybat.persistence.entities.UnitType;
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
import cz.muni.fi.civ.newohybat.persistence.facade.helpers.DTOHelper;
import cz.muni.fi.civ.newohybat.persistence.facade.iface.CivBackend;
import cz.muni.fi.civ.newohybat.persistence.services.iface.ActionService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.AdvanceService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.CityImprovementService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.CityService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.GovernmentService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.PlayerService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.SpecialService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.TerrainService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.TileImprovementService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.TileService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.TradeRouteService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.UnitService;
import cz.muni.fi.civ.newohybat.persistence.services.iface.UnitTypeService;

@Stateless
public class CivBackendImpl implements CivBackend {
	@Inject
	private ActionService actionServ;
	@Inject
	private AdvanceService advanceServ;
	@Inject
	private PlayerService playerServ;
	@Inject
	private CityService cityServ;
	@Inject
	private GovernmentService govServ;
	@Inject
	private UnitService unitServ;
	@Inject
	private TileService tileServ;
	@Inject
	private CityImprovementService cityImpServ;
	@Inject
	private TileImprovementService tileImpServ;
	@Inject
	private UnitTypeService unitTypeServ;
	@Inject
	private SpecialService specialServ;
	@Inject
	private TerrainService terrainServ;
	@Inject
	private TradeRouteService tradeServ;
	
	public void update(Object o){
		if (o instanceof ActionDTO){
			update((ActionDTO)o);
		}else if(o instanceof AdvanceDTO){
			update((AdvanceDTO)o);
		}else if(o instanceof CityImprovementDTO){
			update((CityImprovementDTO)o);
		}else if(o instanceof CityDTO){
			update((CityDTO)o);
		}else if(o instanceof GovernmentDTO){
			update((GovernmentDTO)o);
		}else if(o instanceof PlayerDTO){
			update((PlayerDTO)o);
		}else if(o instanceof SpecialDTO){
			update((SpecialDTO)o);
		}else if(o instanceof TerrainDTO){
			update((TerrainDTO)o);
		}else if(o instanceof TileImprovementDTO){
			update((TileImprovementDTO)o);
		}else if(o instanceof TileDTO){
			update((TileDTO)o);
		}else if(o instanceof TradeRouteDTO){
			update((TradeRouteDTO)o);
		}else if(o instanceof UnitDTO){
			update((UnitDTO)o);
		}else if(o instanceof UnitTypeDTO){
			update((UnitTypeDTO)o);
		}else{
			throw new IllegalArgumentException("Unsupported DTO class to update.");
		}
	}
	
	public ActionDTO create(ActionDTO action) {
		return DTOHelper.getActionDTO(actionServ.create(DTOHelper.getAction(action)));
	}
	public void update(ActionDTO action) {
		actionServ.update(DTOHelper.getAction(action));
	}
	public void delete(ActionDTO action) {
		actionServ.delete(DTOHelper.getAction(action));
	}
	public ActionDTO getActionById(Long id) {
		return DTOHelper.getActionDTO(actionServ.getById(id));
	}
	public ActionDTO getActionByIdent(String ident) {
		return DTOHelper.getActionDTO(actionServ.getByIdent(ident));
	}
	public List<ActionDTO> getActions(){
		List<ActionDTO>actions = new ArrayList<ActionDTO>();
		for(Action a: actionServ.getAll()){
			actions.add(DTOHelper.getActionDTO(a));
		}
		return actions;
	}
	public AdvanceDTO create(AdvanceDTO advance){
		return DTOHelper.getAdvanceDTO(advanceServ.create(DTOHelper.getAdvance(advance)));
	}
	public void update(AdvanceDTO advance){
		advanceServ.update(DTOHelper.getAdvance(advance));
	}
	public void delete(AdvanceDTO advance){
		advanceServ.delete(DTOHelper.getAdvance(advance));
	}
	
	public AdvanceDTO getAdvanceById(Long id) {
		return DTOHelper.getAdvanceDTO(advanceServ.getById(id));
	}

	public AdvanceDTO getAdvanceByIdent(String ident) {
		return DTOHelper.getAdvanceDTO(advanceServ.getByIdent(ident));
	}
	
	public List<AdvanceDTO> getAdvances(){
		List<AdvanceDTO> result = new ArrayList<AdvanceDTO>();
		for(Advance a:advanceServ.getAll()){
			result.add(DTOHelper.getAdvanceDTO(a));
		}
		return result;
	}

	public Map<String, AdvanceDTO> getAdvancesAsMap() {
		Map<String,AdvanceDTO> advances = new HashMap<String, AdvanceDTO>();
		for(Advance a:advanceServ.getAll()){
			advances.put(a.getIdent(), DTOHelper.getAdvanceDTO(a));
		}
		return advances;
	}
	
	public CityImprovementDTO create(CityImprovementDTO imp) {
		return DTOHelper.getCityImprovementDTO(cityImpServ.create(DTOHelper.getCityImprovement(imp)));
	}
	public void update(CityImprovementDTO imp) {
		cityImpServ.update(DTOHelper.getCityImprovement(imp));
	}
	public void delete(CityImprovementDTO imp) {
		cityImpServ.delete(DTOHelper.getCityImprovement(imp));
	}

	public CityImprovementDTO getCityImprovementById(Long id) {
		return DTOHelper.getCityImprovementDTO(cityImpServ.getById(id));
	}

	public CityImprovementDTO getCityImprovementByIdent(String ident) {
		return DTOHelper.getCityImprovementDTO(cityImpServ.getByIdent(ident));
	}
	public List<CityImprovementDTO> getCityImprovements() {
		List<CityImprovementDTO> imps = new ArrayList<CityImprovementDTO>();
		for(CityImprovement c:cityImpServ.getAll()){
			imps.add(DTOHelper.getCityImprovementDTO(c));
		}
		return imps;
	}
	public Map<String, CityImprovementDTO> getCityImprovementsAsMap() {
		Map<String,CityImprovementDTO> imps = new HashMap<String, CityImprovementDTO>();
		for(CityImprovement imp:cityImpServ.getAll()){
			imps.put(imp.getIdent(), DTOHelper.getCityImprovementDTO(imp));
		}
		return imps;
	}

	public CityDTO create(CityDTO city) {
		return DTOHelper.getCityDTO(cityServ.create(DTOHelper.getCity(city)));
	}

	public void update(CityDTO city) {
		cityServ.update(DTOHelper.getCity(city));
	}

	public void delete(CityDTO city) {
		cityServ.delete(DTOHelper.getCity(city));
	}

	public CityDTO getCityById(Long id) {
		return DTOHelper.getCityDTO(cityServ.getById(id));
	}

	public List<CityDTO> getCities() {
		List<CityDTO> cities = new ArrayList<CityDTO>();
		for(City c: cityServ.getAll()){
			cities.add(DTOHelper.getCityDTO(c));
		}
		return cities;
	}
	
	public GovernmentDTO create(GovernmentDTO imp) {
		return DTOHelper.getGovernmentDTO(govServ.create(DTOHelper.getGovernment(imp)));
	}
	public void update(GovernmentDTO imp) {
		govServ.update(DTOHelper.getGovernment(imp));
	}
	public void delete(GovernmentDTO imp) {
		govServ.delete(DTOHelper.getGovernment(imp));
			}
	public GovernmentDTO getGovernmentById(Long id) {
		return DTOHelper.getGovernmentDTO(govServ.getById(id));
	}
	public GovernmentDTO getGovernmentByIdent(String ident) {
		return DTOHelper.getGovernmentDTO(govServ.getByIdent(ident));
	}
	public List<GovernmentDTO> getGovernments() {
		List<GovernmentDTO> govs = new ArrayList<GovernmentDTO>();
		for(Government g:govServ.getAll()){
			govs.add(DTOHelper.getGovernmentDTO(g));
		}
		return govs;
	}
	public Map<String, GovernmentDTO> getGovernmentsAsMap() {
		Map<String,GovernmentDTO> govs = new HashMap<String, GovernmentDTO>();
		for(Government g:govServ.getAll()){
			govs.put(g.getIdent(), DTOHelper.getGovernmentDTO(g));
		}
		return govs;
	}

	public PlayerDTO create(PlayerDTO player) {
		return DTOHelper.getPlayerDTO(playerServ.create(DTOHelper.getPlayer(player)));
	}

	public void update(PlayerDTO player) {
		playerServ.update(DTOHelper.getPlayer(player));
	}

	public void delete(PlayerDTO player) {
		playerServ.delete(DTOHelper.getPlayer(player));
	}

	public PlayerDTO getPlayerById(Long id) {
		return DTOHelper.getPlayerDTO(playerServ.getById(id));
	}

	public List<PlayerDTO> getPlayers() {
		List<PlayerDTO> players = new ArrayList<PlayerDTO>();
		for(Player p: playerServ.getAll()){
			players.add(DTOHelper.getPlayerDTO(p));
		}
		return players;
	}
	public SpecialDTO create(SpecialDTO special) {
		return DTOHelper.getSpecialDTO(specialServ.create(DTOHelper.getSpecial(special)));
	}
	public void update(SpecialDTO special) {
		specialServ.update(DTOHelper.getSpecial(special));
	}
	public void delete(SpecialDTO special) {
		specialServ.delete(DTOHelper.getSpecial(special));
	}
	
	public List<SpecialDTO> getSpecials(){
		List<SpecialDTO> specials = new ArrayList<SpecialDTO>();
		for(Special s: specialServ.getAll()){
			specials.add(DTOHelper.getSpecialDTO(s));
		}
		return specials;
	}
	public SpecialDTO getSpecialById(Long id) {
		return DTOHelper.getSpecialDTO(specialServ.getById(id));
	}
	public SpecialDTO getSpecialByIdent(String ident) {
		return DTOHelper.getSpecialDTO(specialServ.getByIdent(ident));
	}
	
	public Map<String, SpecialDTO> getSpecialsAsMap() {
		Map<String,SpecialDTO> specials = new HashMap<String, SpecialDTO>();
		for(Special s:specialServ.getAll()){
			specials.put(s.getIdent(), DTOHelper.getSpecialDTO(s));
		}
		return specials;
	}
	public TerrainDTO create(TerrainDTO terrain) {
		return DTOHelper.getTerrainDTO(terrainServ.create(DTOHelper.getTerrain(terrain)));
	}
	public void update(TerrainDTO terrain) {
		terrainServ.update(DTOHelper.getTerrain(terrain));
	}
	public void delete(TerrainDTO terrain) {
		terrainServ.delete(DTOHelper.getTerrain(terrain));
	}
	public TerrainDTO getTerrainById(Long id) {
		return DTOHelper.getTerrainDTO(terrainServ.getById(id));
	}
	public TerrainDTO getTerrainByIdent(String ident) {
		return DTOHelper.getTerrainDTO(terrainServ.getByIdent(ident));
	}
	public List<TerrainDTO> getTerrains(){
		List<TerrainDTO> terrains = new ArrayList<TerrainDTO>();
		for(Terrain t: terrainServ.getAll()){
			terrains.add(DTOHelper.getTerrainDTO(t));
		}
		return terrains;
	}
	public Map<String, TerrainDTO> getTerrainsAsMap() {
		Map<String,TerrainDTO> terrains = new HashMap<String, TerrainDTO>();
		for(Terrain t:terrainServ.getAll()){
			terrains.put(t.getIdent(), DTOHelper.getTerrainDTO(t));
		}
		return terrains;
	}
	
	public TileImprovementDTO create(TileImprovementDTO imp) {
		return DTOHelper.getTileImprovementDTO(tileImpServ.create(DTOHelper.getTileImprovement(imp)));
	}
	public void update(TileImprovementDTO imp) {
		tileImpServ.update(DTOHelper.getTileImprovement(imp));
	}
	public void delete(TileImprovementDTO imp) {
		tileImpServ.delete(DTOHelper.getTileImprovement(imp));
	}
	public TileImprovementDTO getTileImprovementById(Long id) {
		return DTOHelper.getTileImprovementDTO(tileImpServ.getById(id));
	}

	public TileImprovementDTO getTileImprovementByIdent(String ident) {
		return DTOHelper.getTileImprovementDTO(tileImpServ.getByIdent(ident));
	}

	public List<TileImprovementDTO> getTileImprovements(){
		List<TileImprovementDTO> imps = new ArrayList<TileImprovementDTO>();
		for(TileImprovement t: tileImpServ.getAll()){
			imps.add(DTOHelper.getTileImprovementDTO(t));
		}
		return imps;
	}
	
	public Map<String, TileImprovementDTO> getTileImprovementsAsMap() {
		Map<String,TileImprovementDTO> imps = new HashMap<String, TileImprovementDTO>();
		for(TileImprovement imp:tileImpServ.getAll()){
			imps.put(imp.getIdent(), DTOHelper.getTileImprovementDTO(imp));
		}
		return imps;
	}
	
	public TileDTO create(TileDTO tile){
		return DTOHelper.getTileDTO(tileServ.create(DTOHelper.getTile(tile)));
	}
	
	public void update(TileDTO tile) {
		tileServ.update(DTOHelper.getTile(tile));
	}
	
	public void delete(TileDTO tile) {
		tileServ.delete(DTOHelper.getTile(tile));
		
	}
	public TileDTO getTileByPosition(Long posX, Long posY) {
		return DTOHelper.getTileDTO(tileServ.getByPosition(posX,posY));
	}
	public Map<Long,List<TileDTO>> getTilesInRectangle(Long topLeftX,
			Long topLeftY, Long bottomRightX, Long bottomRightY) {
		Map<Long,List<TileDTO>> dtos = new HashMap<Long, List<TileDTO>>();
		for(Entry<Long, List<Tile>> entry:tileServ.getTilesInRectangle(topLeftX, topLeftY, bottomRightX, bottomRightY).entrySet()){
			dtos.put(entry.getKey(), new ArrayList<TileDTO>());
			for(Tile t: entry.getValue()){
				dtos.get(entry.getKey()).add(DTOHelper.getTileDTO(t));
			}
		}
		return dtos;
	}
	public List<TileDTO> getTiles() {
		List<TileDTO> tiles = new ArrayList<TileDTO>();
		for(Tile t:tileServ.getAll()){
			tiles.add(DTOHelper.getTileDTO(t));
		}
		return tiles;
	}
	
	public TileDTO getTileById(Long id) {
		return DTOHelper.getTileDTO(tileServ.getById(id));
	}
	
	public TradeRouteDTO create(TradeRouteDTO route) {
		return DTOHelper.getTradeRouteDTO(tradeServ.create(DTOHelper.getTradeRoute(route)));
	}
	public void update(TradeRouteDTO route) {
		tradeServ.update(DTOHelper.getTradeRoute(route));
	}
	public void delete(TradeRouteDTO route) {
		tradeServ.delete(DTOHelper.getTradeRoute(route));
	}
	public TradeRouteDTO getTradeRouteById(Long id) {
		return DTOHelper.getTradeRouteDTO(tradeServ.getById(id));
	}
	
	public UnitDTO create(UnitDTO unit) {
		return DTOHelper.getUnitDTO(unitServ.create(DTOHelper.getUnit(unit)));
	}

	public void update(UnitDTO unit) {
		unitServ.update(DTOHelper.getUnit(unit));
	}

	public void delete(UnitDTO unit) {
		unitServ.delete(DTOHelper.getUnit(unit));
	}

	public UnitDTO getUnitById(Long id) {
		return DTOHelper.getUnitDTO(unitServ.getById(id));
	}

	public List<UnitDTO> getUnits() {
		List<UnitDTO> units = new ArrayList<UnitDTO>();
		for(Unit u: unitServ.getAll()){
			units.add(DTOHelper.getUnitDTO(u));
		}
		return units;
	}

	public UnitTypeDTO create(UnitTypeDTO unit) {
		return DTOHelper.getUnitTypeDTO(unitTypeServ.create(DTOHelper.getUnitType(unit)));
	}
	public void update(UnitTypeDTO unit) {
		unitTypeServ.update(DTOHelper.getUnitType(unit));
	}
	public void delete(UnitTypeDTO unit) {
		unitTypeServ.delete(DTOHelper.getUnitType(unit));
	}
	public UnitTypeDTO getUnitTypeById(Long id) {
		return DTOHelper.getUnitTypeDTO(unitTypeServ.getById(id));
	}
	public UnitTypeDTO getUnitTypeByIdent(String ident) {
		return DTOHelper.getUnitTypeDTO(unitTypeServ.getByIdent(ident));
	}
	public List<UnitTypeDTO> getUnitTypes() {
		List<UnitTypeDTO> types = new ArrayList<UnitTypeDTO>();
		for(UnitType u:unitTypeServ.getAll()){
			types.add(DTOHelper.getUnitTypeDTO(u));
		}
		return types;
	}
	public Map<String, UnitTypeDTO> getUnitTypesAsMap() {
		Map<String,UnitTypeDTO> types = new HashMap<String, UnitTypeDTO>();
		for(UnitType type:unitTypeServ.getAll()){
			types.put(type.getIdent(), DTOHelper.getUnitTypeDTO(type));
		}
		return types;
	}
	


	
	
	
}
