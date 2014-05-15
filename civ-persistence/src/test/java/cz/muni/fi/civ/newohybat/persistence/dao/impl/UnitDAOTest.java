package cz.muni.fi.civ.newohybat.persistence.dao.impl;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.BaseDAO;
import cz.muni.fi.civ.newohybat.persistence.dao.iface.PlayerDAO;
import cz.muni.fi.civ.newohybat.persistence.dao.iface.TerrainDAO;
import cz.muni.fi.civ.newohybat.persistence.dao.iface.TileDAO;
import cz.muni.fi.civ.newohybat.persistence.dao.iface.UnitDAO;
import cz.muni.fi.civ.newohybat.persistence.dao.iface.UnitTypeDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Action;
import cz.muni.fi.civ.newohybat.persistence.entities.Advance;
import cz.muni.fi.civ.newohybat.persistence.entities.City;
import cz.muni.fi.civ.newohybat.persistence.entities.Player;
import cz.muni.fi.civ.newohybat.persistence.entities.Terrain;
import cz.muni.fi.civ.newohybat.persistence.entities.Tile;
import cz.muni.fi.civ.newohybat.persistence.entities.TileImprovement;
import cz.muni.fi.civ.newohybat.persistence.entities.Unit;
import cz.muni.fi.civ.newohybat.persistence.entities.UnitType;
import cz.muni.fi.civ.newohybat.persistence.enums.MovementArea;


@RunWith(Arquillian.class)
public class UnitDAOTest {
	private static int no=0;
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
        		.addPackage(Unit.class.getPackage())
        		.addClasses(Unit.class,UnitDAO.class,UnitDAOImpl.class)
        		.addClasses(UnitType.class,UnitTypeDAO.class,UnitTypeDAOImpl.class)
        		.addClasses(Player.class,PlayerDAO.class,PlayerDAOImpl.class)
        		.addClasses(Tile.class,TileDAO.class,TileDAOImpl.class)
        		.addClasses(Terrain.class,TerrainDAO.class,TerrainDAOImpl.class)
        		.addClasses(MovementArea.class)
        		.addClass(BaseDAO.class)
        		.addClass(BaseDAOImpl.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("META-INF/jbossas-ds.xml");
    }
	private Unit unit;

	@PersistenceContext
	EntityManager em;
	
	@Inject
    UserTransaction utx;
	
	@Inject
	UnitDAO dao;
	@Inject
	UnitTypeDAO uTypeDao;
	@Inject
	PlayerDAO pDao;
	@Inject
	TileDAO tDao;
	@Inject
	TerrainDAO terDao;
    
	@Before
	public void preparePersistenceTest(){
	    startTransaction();
	}

	@After
	public void commitTransaction(){
	    try {
			utx.commit();
			em.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void startTransaction() {
	    try {
			utx.begin();
			em.joinTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}
	
	@Test
    public void testCreate()
    {
    	unit = this.getUnit();
    	dao.create(unit);
        assertNotNull(unit.getId());
        
    }
	
	@Test
	public void testGetById(){
		unit = this.getUnit();
		dao.create(unit);
		Long id = unit.getId();
		
		Unit fromDB = dao.getById(id);
		
		assertEquals(unit,fromDB);
	}
	
	@Test
	public void testDelete(){
		unit = this.getUnit();
		dao.create(unit);
		Long id = unit.getId();
		
		dao.delete(unit);
		
		Unit fromDB = dao.getById(id);
		
		assertNull(fromDB);
	}
    
	@Test
	public void testUpdate(){
		unit = this.getUnit();
		dao.create(unit);
		
		Tile newT = getTile();
		unit.setTile(newT);
		Long id = unit.getId();
		
		Unit check = dao.getById(id);
		
		assertEquals(newT, check.getTile());
	}
	
	@Test
	public void testGetAll() throws Exception{
		unit = this.getUnit();
		dao.create(unit);
		System.out.println(unit.getId());
		Unit another = this.getUnit();
		dao.create(another);
		System.out.println(another.getId());
		assertTrue(dao.getAll().contains(unit)&&dao.getAll().contains(another));
	}
	
    public Unit getUnit(){
    	Unit u = new Unit();
    	u.setType(getUnitType());
    	u.setOwner(getPlayer());
    	u.setTile(getTile());
    	u.setActions(new HashSet<Action>());
    	return u;
    	
    }
    public UnitType getUnitType(){
    	UnitType t = new UnitType();
    	t.setIdent("knight"+no++);
    	t.setName("knight");
    	t.setDescription("Dude with sword.");
    	
    	uTypeDao.create(t);
    	return t;
    	
    }
   
    public Player getPlayer(){
    	Player p  = new Player();
    	p.setName("mighty Stew");
    	p.setAdvances(new HashSet<Advance>());
    	pDao.create(p);
    	return p;
    }
    
    public Tile getTile(){
    	Tile t = new Tile();
    	t.setImprovements(new HashSet<TileImprovement>());
    	t.setPosX(2L);
    	t.setPosY(2L);
//    	t.setUnits(new HashSet<Unit>());
    	t.setTerrain(getTerrain());
    	tDao.create(t);
    	return t;
    }

    private Terrain getTerrain(){
		Terrain terrain = new Terrain();
		terrain.setIdent("grass"+no++);
		terDao.create(terrain);
		return terrain;
	}
    
	
}
