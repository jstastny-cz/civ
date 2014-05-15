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
import cz.muni.fi.civ.newohybat.persistence.dao.iface.CityDAO;
import cz.muni.fi.civ.newohybat.persistence.dao.iface.PlayerDAO;
import cz.muni.fi.civ.newohybat.persistence.dao.iface.TerrainDAO;
import cz.muni.fi.civ.newohybat.persistence.dao.iface.TileDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Advance;
import cz.muni.fi.civ.newohybat.persistence.entities.City;
import cz.muni.fi.civ.newohybat.persistence.entities.CityImprovement;
import cz.muni.fi.civ.newohybat.persistence.entities.Player;
import cz.muni.fi.civ.newohybat.persistence.entities.Terrain;
import cz.muni.fi.civ.newohybat.persistence.entities.Tile;
import cz.muni.fi.civ.newohybat.persistence.entities.TileImprovement;
import cz.muni.fi.civ.newohybat.persistence.entities.TradeRoute;
import cz.muni.fi.civ.newohybat.persistence.entities.Unit;
import cz.muni.fi.civ.newohybat.persistence.enums.MovementArea;


@RunWith(Arquillian.class)
public class CityDAOTest {
	private static int no=0;
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
        		.addPackage(City.class.getPackage())
        		.addClasses(Player.class,PlayerDAO.class,PlayerDAOImpl.class)
        		.addClasses(City.class,CityDAO.class,CityDAOImpl.class)
        		.addClasses(Tile.class,TileDAO.class,TileDAOImpl.class)
        		.addClasses(Terrain.class,TerrainDAO.class,TerrainDAOImpl.class)
        		.addClasses(MovementArea.class)
        		.addClass(BaseDAO.class)
        		.addClass(BaseDAOImpl.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("META-INF/jbossas-ds.xml");
    }
	private City city;

	@PersistenceContext
	EntityManager em;
	
	@Inject
    UserTransaction utx;
	
	@Inject
	CityDAO dao;
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
    	city = this.getCity();
    	dao.create(city);
        assertNotNull(city.getId());
        
    }
	
	@Test
	public void testGetById(){
		city = this.getCity();
		dao.create(city);
		Long id = city.getId();
		
		City fromDB = dao.getById(id);
		
		assertEquals(city,fromDB);
	}
	
	@Test
	public void testDelete(){
		city = this.getCity();
		dao.create(city);
		Long id = city.getId();
		
		dao.delete(city);
		
		City fromDB = dao.getById(id);
		
		assertNull(fromDB);
	}
    
	@Test
	public void testUpdate(){
		city = this.getCity();
		dao.create(city);
		
		Player newP = getPlayer();
		city.setOwner(newP);
		Long id = city.getId();
		
		City check = dao.getById(id);
		
		assertEquals(newP, check.getOwner());
	}
	
	@Test
	public void testGetAll(){
		city = this.getCity();
		dao.create(city);
		City another = this.getCity();
		dao.create(another);
		assertTrue(dao.getAll().contains(city)&&dao.getAll().contains(another));
	}
	
	private City getCity(){
    	City c = new City();
    	c.setCityCentre(getTile());
    	c.setWeLoveDay(true);;
    	c.setHomeUnits(new HashSet<Unit>());
    	c.setImprovements(new HashSet<CityImprovement>());
//    	c.setManagedTiles(new HashSet<Tile>());
    	c.setName("newark");
    	c.setOwner(getPlayer());
    	c.setSize(25);
    	c.setTradeRoutes(new HashSet<TradeRoute>());
    	return c;
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
