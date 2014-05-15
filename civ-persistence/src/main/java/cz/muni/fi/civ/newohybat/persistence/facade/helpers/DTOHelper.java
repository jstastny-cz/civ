package cz.muni.fi.civ.newohybat.persistence.facade.helpers;

import java.util.HashSet;
import java.util.Set;

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
import cz.muni.fi.civ.newohybat.persistence.entities.TradeRoute;
import cz.muni.fi.civ.newohybat.persistence.entities.Unit;
import cz.muni.fi.civ.newohybat.persistence.entities.UnitType;
import cz.muni.fi.civ.newohybat.persistence.enums.MovementArea;
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

public class DTOHelper {
	
	public static City getCity(CityDTO cityDto){
		City c = new City();
		
		if(cityDto.getOwner()!=null)c.setOwner(DTOHelper.getPlayer(cityDto.getOwner()));
		
		if(cityDto.getCityCentre()!=null)c.setCityCentre(DTOHelper.getTile(cityDto.getCityCentre()));
		
		c.setId(cityDto.getId());
		
		c.setName(cityDto.getName());
		
		Set<CityImprovement> improvements = new HashSet<CityImprovement>();
		if(cityDto.getImprovements()!=null){
			for(String ident:cityDto.getImprovements()){
				improvements.add(DTOHelper.getCityImprovement(ident));
			}
		}
		c.setImprovements(improvements);
		
		Set<CityImprovement> enabledImprovements = new HashSet<CityImprovement>();
		if(cityDto.getEnabledImprovements()!=null){
			for(String ident:cityDto.getEnabledImprovements()){
				enabledImprovements.add(DTOHelper.getCityImprovement(ident));
			}
		}
		c.setEnabledImprovements(enabledImprovements);
		
		Set<UnitType> enabledUnitTypes = new HashSet<UnitType>();
		if(cityDto.getEnabledUnitTypes()!=null){
			for(String ident:cityDto.getEnabledUnitTypes()){
				enabledUnitTypes.add(DTOHelper.getUnitType(ident));
			}
		}
		c.setEnabledUnitTypes(enabledUnitTypes);
		
		Set<Unit> homeUnits = new HashSet<Unit>();
		if(cityDto.getHomeUnits()!=null){
			for(Long u:cityDto.getHomeUnits()){
				homeUnits.add(DTOHelper.getUnit(u));
			}
		}
		c.setHomeUnits(homeUnits);
		
		Set<TradeRoute> tradeRoutes = new HashSet<TradeRoute>();
//		if(cityDto.getTradeRoutes()!=null){
//			for(TradeRouteDTO route:cityDto.getTradeRoutes()){
//				tradeRoutes.add(DTOHelper.getTradeRoute(route));
//			}
//		}
		c.setTradeRoutes(tradeRoutes);
		
		Set<Tile> managedTiles = new HashSet<Tile>();
		if(cityDto.getManagedTiles()!=null){
			for(Long tileId:cityDto.getManagedTiles()){
				managedTiles.add(DTOHelper.getTile(tileId));
			}
		}
		c.setManagedTiles(managedTiles);
		
		if(cityDto.getCurrentImprovement()!=null)c.setCurrentImprovement(DTOHelper.getCityImprovement(cityDto.getCurrentImprovement()));
		if(cityDto.getCurrentUnit()!=null)c.setCurrentUnit(DTOHelper.getUnitType(cityDto.getCurrentUnit()));
		c.setCorruption(cityDto.getCorruption());
		c.setDisorder(cityDto.getDisorder());
		c.setFoodConsumption(cityDto.getFoodConsumption());
		c.setFoodProduction(cityDto.getFoodProduction());
		c.setFoodStock(cityDto.getFoodStock());
		c.setFoodSurplus(cityDto.getFoodSurplus());
		c.setLuxuriesAmount(cityDto.getLuxuriesAmount());
		c.setLuxuriesSpent(cityDto.getLuxuriesSpent());
		c.setPeopleContent(cityDto.getPeopleContent());
		c.setPeopleEntertainers(cityDto.getPeopleEntertainers());
		c.setPeopleHappy(cityDto.getPeopleHappy());
		c.setPeopleScientists(cityDto.getPeopleScientists());
		c.setPeopleTaxmen(cityDto.getPeopleTaxmen());
		c.setPeopleUnhappy(cityDto.getPeopleUnhappy());
		c.setResearchAmount(cityDto.getResearchAmount());
		c.setResourcesConsumption(cityDto.getResourcesConsumption());
		c.setResourcesProduction(cityDto.getResourcesProduction());
		c.setResourcesSurplus(cityDto.getResourcesSurplus());
		c.setSize(cityDto.getSize());
		c.setTaxesAmount(cityDto.getTaxesAmount());
		c.setTradeProduction(cityDto.getTradeProduction());
		c.setWeLoveDay(cityDto.getWeLoveDay());
		c.setImprovementsUpkeep(cityDto.getImprovementsUpkeep());
		c.setUnitsSupport(cityDto.getUnitsSupport());
		c.setUnitsFoodSupport(cityDto.getUnitsFoodSupport());
		c.setPollutionChance(cityDto.getPollutionChance());
		
		return c;
	}
	private static Unit getUnit(Long u) {
		Unit unit = new Unit();
		unit.setId(u);
		return unit;
	}
	private static Tile getTile(Long cityCentre) {
		Tile t = new Tile();
		t.setId(cityCentre);
		return t;
	}
	private static Player getPlayer(Long owner) {
		Player p = new Player();
		p.setId(owner);
		return p;
	}
	public static CityDTO getCityDTO(City city){
		CityDTO cityDto = new CityDTO();
		cityDto.setId(city.getId());
		cityDto.setName(city.getName());
		if(city.getOwner()!=null)cityDto.setOwner(city.getOwner().getId());
		if(city.getCityCentre()!=null)cityDto.setCityCentre(city.getCityCentre().getId());
		
		Set<Long> homeUnits = new HashSet<Long>();
		for(Unit u:city.getHomeUnits()){
			homeUnits.add(u.getId());
		}
		cityDto.setHomeUnits(homeUnits);
		
		Set<String>improvements = new HashSet<String>();
		for(CityImprovement imp:city.getImprovements()){
			improvements.add(imp.getIdent());
		}
		cityDto.setImprovements(improvements);
		
		Set<String>enabledImprovements = new HashSet<String>();
		for(CityImprovement imp:city.getEnabledImprovements()){
			enabledImprovements.add(imp.getIdent());
		}
		cityDto.setEnabledImprovements(enabledImprovements);
		
		Set<String> enabledUnitTypes = new HashSet<String>();
		for(UnitType u: city.getEnabledUnitTypes()){
			enabledUnitTypes.add(u.getIdent());
		}
		cityDto.setEnabledUnitTypes(enabledUnitTypes);
		
		Set<Long> managedTiles = new HashSet<Long>();
		for(Tile t: city.getManagedTiles()){
			managedTiles.add(t.getId());
		}
		cityDto.setManagedTiles(managedTiles);
		
		Set<TradeRouteDTO> tradeRoutes = new HashSet<TradeRouteDTO>();
		for(TradeRoute route:city.getTradeRoutes()){
			tradeRoutes.add(DTOHelper.getTradeRouteDTO(route));
		}
		cityDto.setTradeRoutes(tradeRoutes);
		
		cityDto.setCorruption(city.getCorruption());
		if(city.getCurrentImprovement()!=null)cityDto.setCurrentImprovement(city.getCurrentImprovement().getIdent());
		if(city.getCurrentUnit()!=null)cityDto.setCurrentUnit(city.getCurrentUnit().getIdent());
		cityDto.setDisorder(city.getDisorder());
		cityDto.setFoodConsumption(city.getFoodConsumption());
		cityDto.setFoodProduction(city.getFoodProduction());
		cityDto.setFoodStock(city.getFoodStock());
		cityDto.setFoodSurplus(city.getFoodSurplus());
		cityDto.setLuxuriesAmount(city.getLuxuriesAmount());
		cityDto.setLuxuriesSpent(city.getLuxuriesSpent());
		cityDto.setPeopleContent(city.getPeopleContent());
		cityDto.setPeopleEntertainers(city.getPeopleEntertainers());
		cityDto.setPeopleHappy(city.getPeopleHappy());
		cityDto.setPeopleScientists(city.getPeopleScientists());
		cityDto.setPeopleTaxmen(city.getPeopleTaxmen());
		cityDto.setPeopleUnhappy(city.getPeopleUnhappy());
		cityDto.setResearchAmount(city.getResearchAmount());
		cityDto.setResourcesConsumption(city.getResourcesConsumption());
		cityDto.setResourcesProduction(city.getResourcesProduction());
		cityDto.setResourcesSurplus(city.getResourcesSurplus());
		cityDto.setSize(city.getSize());
		cityDto.setTaxesAmount(city.getTaxesAmount());
		cityDto.setTradeProduction(city.getTradeProduction());
		cityDto.setWeLoveDay(city.getWeLoveDay());
		cityDto.setImprovementsUpkeep(city.getImprovementsUpkeep());
		cityDto.setUnitsSupport(city.getUnitsSupport());
		cityDto.setUnitsFoodSupport(city.getUnitsFoodSupport());
		cityDto.setPollutionChance(city.getPollutionChance());
		return cityDto;
	}
	
	public static Player getPlayer(PlayerDTO pDto) {
		Player p = new Player();
		p.setId(pDto.getId());
		p.setName(pDto.getName());
		
		if(pDto.getCurrentAdvance()!=null){
			p.setCurrentAdvance(DTOHelper.getAdvance(pDto.getCurrentAdvance()));
		}
		Set<Advance> advances = new HashSet<Advance>();
		if(pDto.getAdvances()!=null){
			for(String a: pDto.getAdvances()){
				advances.add(DTOHelper.getAdvance(a));
			}
		}
		p.setAdvances(advances);
		
		Set<Advance> enabledAdvances = new HashSet<Advance>();
		if(pDto.getEnabledAdvances()!=null){
			for(String a: pDto.getEnabledAdvances()){
				enabledAdvances.add(DTOHelper.getAdvance(a));
			}
		}
		p.setEnabledAdvances(enabledAdvances);
		
		Set<Government> enabledGovernments = new HashSet<Government>();
		if(pDto.getEnabledGovernments()!=null){
			for(String s: pDto.getEnabledGovernments()){
				enabledGovernments.add(DTOHelper.getGovernment(s));
			}
		}
		p.setEnabledGovernments(enabledGovernments);
		
		if(pDto.getGovernment()!=null)p.setGovernment(DTOHelper.getGovernment(pDto.getGovernment()));
		
		p.setLuxuriesRatio(pDto.getLuxuriesRatio());
		p.setResearch(pDto.getResearch());
		p.setResearchRatio(pDto.getResearchRatio());
		p.setResearchSpent(pDto.getResearchSpent());
		p.setTaxesRatio(pDto.getTaxesRatio());
		p.setTreasury(pDto.getTreasury());
		p.setTurnsAvailable(pDto.getTurnsAvailable());
		return p;
	}
	public static PlayerDTO getPlayerDTO(Player player){
		PlayerDTO pDto = new PlayerDTO();
		pDto.setId(player.getId());
		pDto.setName(player.getName());
		if(player.getCurrentAdvance()!=null){
			pDto.setCurrentAdvance(player.getCurrentAdvance().getIdent());
		}
		
		if(player.getGovernment()!=null){
			pDto.setGovernment(player.getGovernment().getIdent());
		}
		
		Set<String> advances = new HashSet<String>();
		for(Advance a: player.getAdvances()){
			advances.add(a.getIdent());
		}
		pDto.setAdvances(advances);
		
		Set<String> enabledAdvances = new HashSet<String>();
		for(Advance a: player.getEnabledAdvances()){
			enabledAdvances.add(a.getIdent());
		}
		pDto.setEnabledAdvances(enabledAdvances);
		
		Set<String> enabledGovernments = new HashSet<String>();
		for(Government g : player.getEnabledGovernments()){
			enabledGovernments.add(g.getIdent());
		}
		pDto.setEnabledGovernments(enabledGovernments);
		
		pDto.setLuxuriesRatio(player.getLuxuriesRatio());
		pDto.setResearch(player.getResearch());
		pDto.setResearchRatio(player.getResearchRatio());
		pDto.setResearchSpent(player.getResearchSpent());
		pDto.setTaxesRatio(player.getTaxesRatio());
		pDto.setTreasury(player.getTreasury());
		pDto.setTurnsAvailable(player.getTurnsAvailable());
		
		return pDto;
	}	

	public static CityImprovement getCityImprovement(CityImprovementDTO impDto) {
		CityImprovement imp = new CityImprovement();
		imp.setIdent(impDto.getIdent());
		imp.setName(impDto.getName());
		imp.setDescription(impDto.getDescription());
		imp.setWonder(impDto.getWonder());
		if(impDto.getObsoletedByAdvance()!=null)imp.setObsoletedByAdvance(DTOHelper.getAdvance(impDto.getObsoletedByAdvance()));
		if(impDto.getObsoletedByImprovement()!=null)imp.setObsoletedByImprovement(DTOHelper.getCityImprovement(impDto.getObsoletedByImprovement()));
		imp.setConstructionCost(impDto.getConstructionCost());
		imp.setUpkeepCost(impDto.getUpkeepCost());
		return imp;
	}


	private static CityImprovement getCityImprovement(String obsoletedByImprovement) {
		CityImprovement imp = new CityImprovement();
		imp.setIdent(obsoletedByImprovement);
		return imp;
	}
	
	public static CityImprovementDTO getCityImprovementDTO(CityImprovement imp) {
		CityImprovementDTO impDto = new CityImprovementDTO();
		impDto.setIdent(imp.getIdent());
		impDto.setName(imp.getName());
		impDto.setDescription(imp.getDescription());
		impDto.setWonder(imp.getWonder());
		if(imp.getObsoletedByAdvance()!=null){
			impDto.setObsoletedByAdvance(imp.getObsoletedByAdvance().getIdent());
		}
		if(imp.getObsoletedByImprovement()!=null){
			impDto.setObsoletedByImprovement(imp.getObsoletedByImprovement().getIdent());
		}
		impDto.setUpkeepCost(imp.getUpkeepCost());
		impDto.setConstructionCost(imp.getConstructionCost());
		return impDto;
	}
	
	public static Advance getAdvance(AdvanceDTO dto) {
		Advance advance = new Advance();
		advance.setCost(dto.getCost());
		advance.setDescription(dto.getDescription());
		advance.setIdent(dto.getIdent());
		advance.setName(dto.getName());
		Set<Advance> enabledAdvances = new HashSet<Advance>();
		if(dto.getEnabledAdvances()!=null){
			for(String s:dto.getEnabledAdvances()){
				enabledAdvances.add(DTOHelper.getAdvance(s));
			}
		}
		advance.setEnabledAdvances(enabledAdvances);
		Set<CityImprovement> enabledCityImprovements = new HashSet<CityImprovement>();
		if(dto.getEnabledCityImprovements()!=null){
			for(String s: dto.getEnabledCityImprovements()){
				enabledCityImprovements.add(DTOHelper.getCityImprovement(s));
			}
		}
		advance.setEnabledCityImprovements(enabledCityImprovements);
		Set<Government> enabledGovernments = new HashSet<Government>();
		if(dto.getEnabledGovernments()!=null){
			for(String s: dto.getEnabledGovernments()){
				enabledGovernments.add(DTOHelper.getGovernment(s));
			}
		}
		advance.setEnabledGovernments(enabledGovernments);
		Set<UnitType> enabledUnitTypes = new HashSet<UnitType>();
		if(dto.getEnabledUnitTypes()!=null){
			for(String s:dto.getEnabledUnitTypes()){
				enabledUnitTypes.add(DTOHelper.getUnitType(s));
			}
		}
		advance.setEnabledUnitTypes(enabledUnitTypes);
		return advance;
	}
	
	private static UnitType getUnitType(String s) {
		UnitType type = new UnitType();
		type.setIdent(s);
		return type;
	}
	private static Government getGovernment(String s) {
		Government gov = new Government();
		gov.setIdent(s);
		return gov;
	}
	public static AdvanceDTO getAdvanceDTO(Advance advance) {
		AdvanceDTO advanceDto = new AdvanceDTO();
		advanceDto.setIdent(advance.getIdent());
		advanceDto.setName(advance.getName());
		advanceDto.setDescription(advance.getDescription());
		Set<String> enabledGovernments = new HashSet<String>();
		for(Government g:advance.getEnabledGovernments()){
			enabledGovernments.add(g.getIdent());
		}
		advanceDto.setEnabledGovernments(enabledGovernments);
		Set<String>enabledImprovements = new HashSet<String>();
		for(CityImprovement i:advance.getEnabledCityImprovements()){
			enabledImprovements.add(i.getIdent());
		}
		advanceDto.setEnabledCityImprovements(enabledImprovements);
		Set<String> enabledUnitTypes = new HashSet<String>();
		for(UnitType u:advance.getEnabledUnitTypes()){
			enabledUnitTypes.add(u.getIdent());
		}
		advanceDto.setEnabledUnitTypes(enabledUnitTypes);
		Set<String> enabledAdvances = new HashSet<String>();
		for(Advance a: advance.getEnabledAdvances()){
			enabledAdvances.add(a.getIdent());
		}
		advanceDto.setEnabledAdvances(enabledAdvances);
		advanceDto.setCost(advance.getCost());
		return advanceDto;
	}
	public static Government getGovernment(GovernmentDTO govDto){
		Government gov = new Government();
		gov.setIdent(govDto.getIdent());
		gov.setName(govDto.getName());
		gov.setDescription(govDto.getDescription());
		return gov;
	}
	public static GovernmentDTO getGovernmentDTO(Government g) {
		GovernmentDTO govDto = new GovernmentDTO();
		govDto.setIdent(g.getIdent());
		govDto.setName(g.getName());
		govDto.setDescription(g.getDescription());
		return govDto;
	}

	public static Unit getUnit(UnitDTO uDto) {
		Unit u = new Unit();
		u.setId(uDto.getId());
		if(uDto.getOwner()!=null)u.setOwner(DTOHelper.getPlayer(uDto.getOwner()));
		if(uDto.getTile()!=null)u.setTile(DTOHelper.getTile(uDto.getTile()));
		if(uDto.getType()!=null)u.setType(DTOHelper.getUnitType(uDto.getType()));
		u.setAttackStrength(uDto.getAttackStrength());
		if(uDto.getCurrentAction()!=null)u.setCurrentAction(DTOHelper.getAction(uDto.getCurrentAction()));
		u.setDefenseStrength(uDto.getDefenseStrength());
		u.setDistanceHome(uDto.getDistanceHome());
		u.setHealthPoints(uDto.getHealthPoints());
		u.setMovementPoints(uDto.getMovementPoints());
		if(uDto.getTargetTile()!=null)u.setTargetTile(DTOHelper.getTile(uDto.getTargetTile()));
		u.setVeteran(uDto.getVeteran());
		Set<Action> actions = new HashSet<Action>();
		if(uDto.getActions()!=null){
			for(String a:uDto.getActions()){
				actions.add(DTOHelper.getAction(a));
			}
		}
		u.setActions(actions);
		
		return u;
	}
	
	public static UnitDTO getUnitDTO(Unit u) {
		UnitDTO uDto = new UnitDTO();
		uDto.setId(u.getId());
		uDto.setOwner(u.getOwner().getId());
		uDto.setTile(u.getTile().getId());
		uDto.setType(u.getType().getIdent());
		uDto.setAttackStrength(u.getAttackStrength());
		if(u.getCurrentAction()!=null){
			uDto.setCurrentAction(u.getCurrentAction().getIdent());
		}
		uDto.setDefenseStrength(u.getDefenseStrength());
		uDto.setDistanceHome(u.getDistanceHome());
		uDto.setHealthPoints(u.getHealthPoints());
		uDto.setMovementPoints(u.getMovementPoints());
		if(u.getTargetTile()!=null){
			uDto.setTargetTile(u.getTargetTile().getId());
		}
		uDto.setVeteran(u.getVeteran());
		Set<String> actions = new HashSet<String>();
		for(Action a:u.getActions()){
			actions.add(a.getIdent());
		}
		uDto.setActions(actions);
		
		
		return uDto;
	}


	public static Action getAction(ActionDTO aDto) {
		Action a = new Action();
		a.setIdent(aDto.getIdent());
		a.setDescription(aDto.getDescription());
		a.setName(aDto.getName());
		return a;
	}
	
	public static ActionDTO getActionDTO(Action a) {
		ActionDTO aDto = new ActionDTO();
		aDto.setIdent(a.getIdent());
		aDto.setName(a.getName());
		aDto.setDescription(a.getDescription());
		return aDto;
	}
	
	public static UnitType getUnitType(UnitTypeDTO uDto) {
		UnitType u = new UnitType();
		u.setIdent(uDto.getIdent());
		u.setName(uDto.getName());
		u.setDescription(uDto.getDescription());
		u.setAttackStrength(uDto.getAttackStrength());
		u.setCost(uDto.getCost());
		u.setDefenseStrength(uDto.getDefenseStrength());
		u.setMilitary(uDto.getMilitary());
		u.setMovementPoints(uDto.getMovementPoints());
		Set<Action> actions = new HashSet<Action>();
		if(uDto.getActions()!=null){
			for(String action: uDto.getActions()){
				actions.add(DTOHelper.getAction(action));
			}
		}
		u.setActions(actions);
		if(uDto.getObsoletedByAdvance()!=null)u.setObsoletedByAdvance(DTOHelper.getAdvance(uDto.getObsoletedByAdvance()));
		if(uDto.getMovementArea()!=null)u.setMovementArea(MovementArea.valueOf(uDto.getMovementArea()));
		return u;
	}
	
	private static Action getAction(String action) {
		Action act = new Action();
		act.setIdent(action);
		return act;
	}
	private static Advance getAdvance(String obsoletedByAdvance) {
		Advance advance = new Advance();
		advance.setIdent(obsoletedByAdvance);
		return advance;
	}
	public static UnitTypeDTO getUnitTypeDTO(UnitType u) {
		UnitTypeDTO uDto = new UnitTypeDTO();
		uDto.setIdent(u.getIdent());
		uDto.setName(u.getName());
		uDto.setDescription(u.getDescription());
		uDto.setAttackStrength(u.getAttackStrength());
		uDto.setCost(u.getCost());
		uDto.setDefenseStrength(u.getDefenseStrength());
		uDto.setMilitary(u.getMilitary());
		uDto.setMovementPoints(u.getMovementPoints());
		if(u.getMovementArea()!=null)uDto.setMovementArea(u.getMovementArea().name());
		Set<String> actions = new HashSet<String>();
		for(Action a: u.getActions()){
			actions.add(a.getIdent());
		}
		uDto.setActions(actions);
		return uDto;
	}
	public static TradeRouteDTO getTradeRouteDTO(TradeRoute route) {
		TradeRouteDTO tDto = new TradeRouteDTO();
		tDto.setId(route.getId());
		tDto.setDestination(DTOHelper.getCityDTO(route.getDestination()));
		return tDto;
	}
	
	public static TradeRoute getTradeRoute(TradeRouteDTO tDto) {
		TradeRoute route = new TradeRoute();
		route.setId(tDto.getId());
		if(tDto.getDestination()!=null)route.setDestination(DTOHelper.getCity(tDto.getDestination()));
		return route;
	}
	
	
	public static Tile getTile(TileDTO tDto){
		Tile tile = new Tile();
		
		tile.setId(tDto.getId());
		tile.setPosX(tDto.getPosX());
		tile.setPosY(tDto.getPosY());
//		if(tDto.getCity()!=null)tile.setCity(DTOHelper.getCity(tDto.getCity()));
//		if(tDto.getOwnedBy()!=null)tile.setOwnedBy(DTOHelper.getCity(tDto.getOwnedBy()));
		if(tDto.getTerrain()!=null)tile.setTerrain(DTOHelper.getTerrain(tDto.getTerrain()));
		if(tDto.getSpecial()!=null)tile.setSpecial(DTOHelper.getSpecial(tDto.getSpecial()));
		
		tile.setDefenseBonus(tDto.getDefenseBonus());
		tile.setMovementCost(tDto.getMovementCost());
		
		tile.setFoodProduction(tDto.getFoodProduction());
		tile.setResourcesProduction(tDto.getResourcesProduction());
		tile.setTradeProduction(tDto.getTradeProduction());
		
		Set<TileImprovement>improvements = new HashSet<TileImprovement>();
		if(tDto.getImprovements()!=null){
			for(String imp:tDto.getImprovements()){
				improvements.add(DTOHelper.getTileImprovement(imp));
			}
		}
		tile.setImprovements(improvements);
		
//		Set<Unit> units = new HashSet<Unit>();
//		if(tDto.getUnits()!=null){
//			for(Long u:tDto.getUnits()){
//				units.add(DTOHelper.getUnit(u));
//			}
//		}
////		tile.setUnits(units);
		
		
		return tile;
	}

	private static TileImprovement getTileImprovement(String imp) {
		TileImprovement t = new TileImprovement();
		t.setIdent(imp);
		return t;
	}
	private static Special getSpecial(String special) {
		Special s = new Special();
		s.setIdent(special);
		return s;
	}
	private static Terrain getTerrain(String terrain) {
		Terrain t = new Terrain();
		t.setIdent(terrain);
		return t;
	}
	public static TileDTO getTileDTO(Tile tile){
		TileDTO tDto = new TileDTO();
		tDto.setId(tile.getId());
		tDto.setPosX(tile.getPosX());
		tDto.setPosY(tile.getPosY());
		if(tile.getTerrain()!=null)tDto.setTerrain(tile.getTerrain().getIdent());
		if(tile.getSpecial()!=null)tDto.setSpecial(tile.getSpecial().getIdent());
//		if(tile.getCity()!=null){
//			tDto.setCity(tile.getCity().getId());
//		}
		Set<String>improvements = new HashSet<String>();
		for(TileImprovement imp:tile.getImprovements()){
			improvements.add(imp.getIdent());
		}
		tDto.setImprovements(improvements);
		
//		if(tile.getOwnedBy()!=null){
//			tDto.setOwnedBy(tile.getOwnedBy().getId());
//		}
		
//		Set<Long>units = new HashSet<Long>();
//		for(Unit u:tile.getUnits()){
//			units.add(u.getId());
//		}
//		tDto.setUnits(units);
		
		tDto.setDefenseBonus(tile.getDefenseBonus());
		tDto.setFoodProduction(tile.getFoodProduction());
		tDto.setMovementCost(tile.getMovementCost());
		tDto.setResourcesProduction(tile.getResourcesProduction());
		tDto.setTradeProduction(tile.getTradeProduction());
		
		return tDto;
	}
	
	public static TileImprovement getTileImprovement(TileImprovementDTO tDto) {
		TileImprovement imp = new TileImprovement();
		imp.setIdent(tDto.getIdent());
		imp.setName(tDto.getName());
		imp.setDescription(tDto.getDescription());
		imp.setCost(tDto.getCost());
		
		return imp;
	}
	
	public static TileImprovementDTO getTileImprovementDTO(TileImprovement imp) {
		TileImprovementDTO tDto = new TileImprovementDTO();
		tDto.setIdent(imp.getIdent());
		tDto.setName(imp.getName());
		tDto.setDescription(imp.getDescription());
		tDto.setCost(imp.getCost());
		
		return tDto;
	}

	
	public static Terrain getTerrain(TerrainDTO tDto) {
		Terrain terrain = new Terrain();
		terrain.setIdent(tDto.getIdent());
		terrain.setName(tDto.getName());
		terrain.setDescription(tDto.getDescription());
		if(tDto.getMovementArea()!=null)terrain.setMovementArea(MovementArea.valueOf(tDto.getMovementArea()));
		Set<Special> specials = new HashSet<Special>();
		if(tDto.getSpecials()!=null){
			for(String s:tDto.getSpecials()){
				specials.add(DTOHelper.getSpecial(s));
			}
		}
		terrain.setSpecials(specials);
		
		return terrain;
	}
	
	public static TerrainDTO getTerrainDTO(Terrain terrain) {
		TerrainDTO tDto = new TerrainDTO();
		tDto.setIdent(terrain.getIdent());
		tDto.setName(terrain.getName());
		tDto.setDescription(terrain.getDescription());
		if(terrain.getMovementArea()!=null)tDto.setMovementArea(terrain.getMovementArea().name());
		Set<String> specials = new HashSet<String>();
		for(Special s: terrain.getSpecials()){
			specials.add(s.getIdent());
		}
		tDto.setSpecials(specials);
		return tDto;
	}
	
	public static Special getSpecial(SpecialDTO sDto) {
		Special special = new Special();
		special.setIdent(sDto.getIdent());
		special.setName(sDto.getName());
		special.setDescription(sDto.getDescription());
		
		return special;
	}

	public static SpecialDTO getSpecialDTO(Special special) {
		SpecialDTO sDto = new SpecialDTO();
		sDto.setIdent(special.getIdent());
		sDto.setName(special.getName());
		sDto.setDescription(special.getDescription());
		
		return sDto;
	}
}
	
