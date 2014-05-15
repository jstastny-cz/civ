package cz.muni.fi.civ.newohybat.persistence.facade.impl;



import static org.junit.Assert.assertNotNull;

import java.util.HashSet;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.BaseDAO;
import cz.muni.fi.civ.newohybat.persistence.dao.impl.BaseDAOImpl;
import cz.muni.fi.civ.newohybat.persistence.entities.City;
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
import cz.muni.fi.civ.newohybat.persistence.facade.dto.UnitDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.UnitTypeDTO;
import cz.muni.fi.civ.newohybat.persistence.facade.helpers.DTOHelper;
import cz.muni.fi.civ.newohybat.persistence.facade.iface.CivBackend;
import cz.muni.fi.civ.newohybat.persistence.services.iface.CityService;
import cz.muni.fi.civ.newohybat.persistence.services.impl.CityServiceImpl;


@RunWith(Arquillian.class)
public class CivBackendTest {
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
        		.addPackage(City.class.getPackage())
        		.addPackage(BaseDAO.class.getPackage())
        		.addPackage(BaseDAOImpl.class.getPackage())
        		.addPackage(MovementArea.class.getPackage())
        		.addPackage(CityDTO.class.getPackage())
        		.addPackage(DTOHelper.class.getPackage())
        		.addPackage(CivBackend.class.getPackage())
        		.addPackage(CivBackendImpl.class.getPackage())
        		.addPackage(CityService.class.getPackage())
        		.addPackage(CityServiceImpl.class.getPackage())
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("META-INF/jbossas-ds.xml");
    }

	@PersistenceContext
	EntityManager em;
	
	@Inject
	private CivBackend cb;
   
	@Test
    public void testAction()
    {
    	ActionDTO aDto = new ActionDTO();
    	aDto.setDescription("test data");
    	aDto.setIdent("test");
    	aDto.setName("test");
    	aDto = cb.create(aDto);
        Assert.assertNotNull(aDto);
    	Assert.assertNotNull(cb.getActionByIdent(aDto.getIdent()));
    	
    	aDto.setName("test2");
    	cb.update(aDto);
    	aDto = cb.getActionByIdent(aDto.getIdent());
    	
    	Assert.assertNotNull(aDto);
    	Assert.assertTrue(aDto.getName()=="test2");
        
    	Assert.assertTrue( cb.getActions().contains(aDto));
    	
    	cb.delete(aDto);
    	
    	Assert.assertFalse( cb.getActions().contains(aDto));
    }
	@Test
    public void testAdvance()
    {
    	AdvanceDTO aDto = new AdvanceDTO();
    	aDto.setDescription("test data");
    	aDto.setIdent("test");
    	aDto.setName("test");
    	aDto.setCost(10);
    	aDto = cb.create(aDto);
        Assert.assertNotNull(aDto);
    	Assert.assertNotNull(cb.getAdvanceByIdent(aDto.getIdent()));
    	
    	aDto.setName("test2");
    	cb.update(aDto);
    	aDto = cb.getAdvanceByIdent(aDto.getIdent());
    	
    	Assert.assertNotNull(aDto);
    	Assert.assertTrue(aDto.getName()=="test2");
        
    	Assert.assertTrue( cb.getAdvances().contains(aDto));
    	
    	cb.delete(aDto);
    	
    	Assert.assertFalse( cb.getAdvances().contains(aDto));
    }
	@Test
    public void testCityImprovement()
    {
    	CityImprovementDTO cDto = new CityImprovementDTO();
    	cDto.setDescription("test data");
    	cDto.setIdent("test");
    	cDto.setName("test");
    	cDto = cb.create(cDto);
        Assert.assertNotNull(cDto);
    	Assert.assertNotNull(cb.getCityImprovementByIdent(cDto.getIdent()));
    	
    	cDto.setName("test2");
    	cb.update(cDto);
    	cDto = cb.getCityImprovementByIdent(cDto.getIdent());
    	
    	Assert.assertNotNull(cDto);
    	Assert.assertTrue(cDto.getName()=="test2");
        
    	Assert.assertTrue( cb.getCityImprovements().contains(cDto));
    	
    	cb.delete(cDto);
    	
    	Assert.assertFalse( cb.getCityImprovements().contains(cDto));
    }
	@Test
    public void testGovernment()
    {
    	GovernmentDTO gDto = new GovernmentDTO();
    	gDto.setDescription("test data");
    	gDto.setIdent("test");
    	gDto.setName("test");
    	gDto = cb.create(gDto);
        Assert.assertNotNull(gDto);
    	Assert.assertNotNull(cb.getGovernmentByIdent(gDto.getIdent()));
    	
    	gDto.setName("test2");
    	cb.update(gDto);
    	gDto = cb.getGovernmentByIdent(gDto.getIdent());
    	
    	Assert.assertNotNull(gDto);
    	Assert.assertTrue(gDto.getName()=="test2");
        
    	Assert.assertTrue( cb.getGovernments().contains(gDto));
    	
    	cb.delete(gDto);
    	
    	Assert.assertFalse( cb.getGovernments().contains(gDto));
    }
	@Test
    public void testSpecial()
    {
    	SpecialDTO sDto = new SpecialDTO();
    	sDto.setDescription("test data");
    	sDto.setIdent("test");
    	sDto.setName("test");
    	sDto = cb.create(sDto);
        Assert.assertNotNull(sDto);
    	Assert.assertNotNull(cb.getSpecialByIdent(sDto.getIdent()));
    	
    	sDto.setName("test2");
    	cb.update(sDto);
    	sDto = cb.getSpecialByIdent(sDto.getIdent());
    	
    	Assert.assertNotNull(sDto);
    	Assert.assertTrue(sDto.getName()=="test2");
        
    	Assert.assertTrue( cb.getSpecials().contains(sDto));
    	
    	cb.delete(sDto);
    	
    	Assert.assertFalse( cb.getSpecials().contains(sDto));
    }
	@Test
    public void testTerrain()
    {
    	TerrainDTO tdto = new TerrainDTO();
    	tdto.setDescription("test data");
    	tdto.setIdent("test");
    	tdto.setMovementArea(MovementArea.LAND.name());
    	tdto.setName("test");
    	tdto.setSpecials(new HashSet<String>());
    	tdto = cb.create(tdto);
        Assert.assertNotNull(tdto);
    	Assert.assertNotNull(cb.getTerrainByIdent(tdto.getIdent()));
    	
    	tdto.setName("test2");
    	cb.update(tdto);
    	tdto = cb.getTerrainByIdent(tdto.getIdent());
    	
    	Assert.assertNotNull(tdto);
    	Assert.assertTrue(tdto.getName()=="test2");
        
    	Assert.assertTrue( cb.getTerrains().contains(tdto));
    	
    	cb.delete(tdto);
    	
    	Assert.assertFalse( cb.getTerrains().contains(tdto));
    }
	@Test
    public void testTileImprovement()
    {
    	TileImprovementDTO tDto = new TileImprovementDTO();
    	tDto.setDescription("test data");
    	tDto.setIdent("test");
    	tDto.setName("test");
    	tDto = cb.create(tDto);
        Assert.assertNotNull(tDto);
    	Assert.assertNotNull(cb.getTileImprovementByIdent(tDto.getIdent()));
    	
    	tDto.setName("test2");
    	cb.update(tDto);
    	tDto = cb.getTileImprovementByIdent(tDto.getIdent());
    	
    	Assert.assertNotNull(tDto);
    	Assert.assertTrue(tDto.getName()=="test2");
        
    	Assert.assertTrue( cb.getTileImprovements().contains(tDto));
    	
    	cb.delete(tDto);
    	
    	Assert.assertFalse( cb.getTileImprovements().contains(tDto));
    }
	@Test
    public void testUnitType()
    {
    	UnitTypeDTO uDto = new UnitTypeDTO();
    	uDto.setDescription("test data");
    	uDto.setIdent("test");
    	uDto.setName("test");
    	uDto = cb.create(uDto);
        Assert.assertNotNull(uDto);
    	Assert.assertNotNull(cb.getUnitTypeByIdent(uDto.getIdent()));
    	
    	uDto.setName("test2");
    	cb.update(uDto);
    	uDto = cb.getUnitTypeByIdent(uDto.getIdent());
    	
    	Assert.assertNotNull(uDto);
    	Assert.assertTrue(uDto.getName()=="test2");
        
    	Assert.assertTrue( cb.getUnitTypes().contains(uDto));
    	
    	cb.delete(uDto);
    	
    	Assert.assertFalse( cb.getUnitTypes().contains(uDto));
    }
	@Test
	public void testTile()
	{
		TerrainDTO terr = new TerrainDTO();
		terr.setIdent("ident");
		terr.setName("terr");
		terr = cb.create(terr);
		Assert.assertNotNull(terr);
		
        TileDTO tile = new TileDTO();
        tile.setDefenseBonus(0);
        tile.setFoodProduction(0);
        tile.setImprovements(new HashSet<String>());
        tile.setMovementCost(0);
        tile.setPosX(1L);
        tile.setPosY(1L);
        tile.setResourcesProduction(0);
        tile.setSpecial(null);
        tile.setTerrain(terr.getIdent());
        tile.setTradeProduction(0);
//        tile.setUnits(new HashSet<Long>());
        tile = cb.create(tile);
        Assert.assertNotNull(tile);
        Assert.assertNotNull(tile.getId());
        
        tile.setTradeProduction(10);
        cb.update(tile);
        
        tile = cb.getTileById(tile.getId());
        Assert.assertNotNull(tile);
        Assert.assertTrue(tile.getTradeProduction()==10);
        
        Assert.assertTrue(cb.getTiles().contains(tile));
        
        cb.delete(tile);
        
        Assert.assertFalse(cb.getTiles().contains(tile));
        cb.delete(terr);
    }


	@Test
	public void testPlayer(){
		PlayerDTO pDto = new PlayerDTO();
    	pDto.setName("newohybat");
    	pDto = cb.create(pDto);
    	Assert.assertNotNull(pDto);
    	Assert.assertNotNull(pDto.getId());
    	
    	pDto.setName("bla");
    	cb.update(pDto);
    	
    	pDto = cb.getPlayerById(pDto.getId());
    	Assert.assertNotNull(pDto);
    	Assert.assertTrue(pDto.getName()=="bla");
    	
    	Assert.assertTrue(cb.getPlayers().contains(pDto));
    	
    	cb.delete(pDto);
    	
    	Assert.assertFalse(cb.getPlayers().contains(pDto));
	}
	@Test
	public void testUnit()
	{
		TerrainDTO terr = new TerrainDTO();
		terr.setIdent("ident");
		terr.setName("terr");
		terr = cb.create(terr);
		Assert.assertNotNull(terr);
		
        TileDTO tile = new TileDTO();
        tile.setDefenseBonus(0);
        tile.setFoodProduction(0);
        tile.setImprovements(new HashSet<String>());
        tile.setMovementCost(0);
        tile.setPosX(1L);
        tile.setPosY(1L);
        tile.setResourcesProduction(0);
        tile.setSpecial(null);
        tile.setTerrain(terr.getIdent());
        tile.setTradeProduction(0);
//	        tile.setUnits(new HashSet<Long>());
        tile = cb.create(tile);
        Assert.assertNotNull(tile);
        Assert.assertNotNull(tile.getId());
        
        UnitTypeDTO uDto = new UnitTypeDTO();
    	uDto.setDescription("test data");
    	uDto.setIdent("test");
    	uDto.setName("test");
    	uDto = cb.create(uDto);
        Assert.assertNotNull(uDto);
    	Assert.assertNotNull(cb.getUnitTypeByIdent(uDto.getIdent()));
        
    	PlayerDTO pDto = new PlayerDTO();
    	pDto.setName("newohybat");
    	pDto = cb.create(pDto);
    	Assert.assertNotNull(pDto);
    	Assert.assertNotNull(pDto.getId());
    	
        UnitDTO u = new UnitDTO();
        u.setAttackStrength(15);
        u.setTile(tile.getId());
        u.setType(uDto.getIdent());
        u.setOwner(pDto.getId());
        
        u = cb.create(u);
        Assert.assertNotNull(u);
        Assert.assertNotNull(u.getId());
        
        u.setAttackStrength(2);
        cb.update(u);
        
        u = cb.getUnitById(u.getId());
        Assert.assertNotNull(u);
        Assert.assertTrue(u.getAttackStrength()==2);
        
        Assert.assertTrue(cb.getUnits().contains(u));
        
        cb.delete(u);
        
        Assert.assertFalse(cb.getUnits().contains(u));
        
        
        cb.delete(uDto);
        cb.delete(tile);
        cb.delete(terr);
	}
	public void testCity(){
		TerrainDTO terr = new TerrainDTO();
		terr.setIdent("ident");
		terr.setName("terr");
		terr = cb.create(terr);
		Assert.assertNotNull(terr);
		
		TileDTO tile = new TileDTO();
		tile.setDefenseBonus(0);
		tile.setFoodProduction(0);
		tile.setImprovements(new HashSet<String>());
		tile.setMovementCost(0);
		tile.setPosX(1L);
		tile.setPosY(1L);
		tile.setResourcesProduction(0);
		tile.setSpecial(null);
		tile.setTerrain(terr.getIdent());
		tile.setTradeProduction(0);
		//		        tile.setUnits(new HashSet<Long>());
		tile = cb.create(tile);
		Assert.assertNotNull(tile);
		Assert.assertNotNull(tile.getId());
		
		CityDTO city = new CityDTO();
		city.setCityCentre(tile.getId());
		city.setCorruption(0);
		city.setCurrentImprovement(null);
		city.setCurrentUnit(null);
		city.setDisorder(false);
		city.setEnabledImprovements(new HashSet<String>());
		city.setEnabledUnitTypes(new HashSet<String>());
		city.setHomeUnits(new HashSet<Long>());
		city.setImprovements(new HashSet<String>());
		city.setName("marefy");
		city.setSize(1000);
		city = cb.create(city);
		Assert.assertNotNull(city);
		Assert.assertNotNull(city.getId());
		
		city.setSize(999);
		cb.update(city);
		
		city = cb.getCityById(city.getId());
		Assert.assertNotNull(city);
		Assert.assertTrue(city.getSize()==999);
		
		Assert.assertTrue(cb.getCities().contains(city));
		
		cb.delete(city);
		
		Assert.assertFalse(cb.getCities().contains(city));
		
		cb.delete(tile);
		cb.delete(terr);
		  
	}
    
	
}
