package cz.muni.fi.civ.newohybat.persistence.dao.impl;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
public class TileDAOTest {
	private static int no=0;
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
        		.addPackage(Tile.class.getPackage())
        		.addClasses(Tile.class,TileDAO.class,TileDAOImpl.class)
        		.addClasses(City.class,CityDAO.class,CityDAOImpl.class)
        		.addClasses(Player.class,PlayerDAO.class,PlayerDAOImpl.class)
        		.addClasses(Terrain.class,TerrainDAO.class,TerrainDAOImpl.class)
        		.addClasses(MovementArea.class)
        		.addClass(BaseDAO.class)
        		.addClass(BaseDAOImpl.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("META-INF/jbossas-ds.xml");
    }
	private Tile tile;

	@PersistenceContext
	EntityManager em;
	
	@Inject
    UserTransaction utx;
	
	@Inject
	TileDAO dao;
	@Inject
	TerrainDAO terDao;
	@Inject
	CityDAO cDao;
	@Inject
	PlayerDAO pDao;
	
	@Before
	public void preparePersistenceTest(){
	    startTransaction();
	}

	@After
	public void commitTransaction()throws Exception{
	    try {
			utx.commit();
			em.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}

	    utx.begin();
	    for(Tile t:dao.getAll()){
	    	dao.delete(t);
	    }
	     for(Player p:pDao.getAll()){
	    	pDao.delete(p);
	    }
	   
	    utx.commit();
		
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
    public void testCreate() throws Exception
    {
    	tile = this.getTile();
    	dao.create(tile);
        assertNotNull(tile.getId());
        utx.commit();
        utx.begin();
        Tile next = dao.getById(tile.getId());
        assertNotNull(next);
    }
	
	@Test
	public void testGetById(){
		tile = this.getTile();
		dao.create(tile);
		Long id = tile.getId();
		
		Tile fromDB = dao.getById(id);
		
		assertEquals(tile,fromDB);
	}
	
	@Test
	public void testDelete() throws Exception{
		tile = this.getTile();
		dao.create(tile);
		Long id = tile.getId();
		
		dao.delete(tile);
		utx.commit();
		utx.begin();
		Tile fromDB = dao.getById(id);
		
		assertNull(fromDB);
	}
    
	@Test
	public void testUpdate(){
		tile = this.getTile();
		dao.create(tile);
		
		Terrain t = getTerrain();
		tile.setTerrain(t);
		Long id = tile.getId();
		
		Tile check = dao.getById(id);
		
		assertEquals(t, check.getTerrain());
	}
	
	@Test
	public void testGetAll(){
		tile = this.getTile();
		dao.create(tile);
		Tile another = this.getTile();
		dao.create(another);
		assertTrue(dao.getAll().contains(tile)&&dao.getAll().contains(another));
	}
	@Test
	public void testGetInRectangle(){

		Tile tile = this.getTile();
		tile.setPosX(1L);
		tile.setPosY(1L);
		Tile tile2 = this.getTile();
		tile2.setPosX(1L);
		tile2.setPosY(2L);
		Tile tile3 = this.getTile();
		tile3.setPosX(2L);
		tile3.setPosY(1L);
		Tile tile4 = this.getTile();
		tile4.setPosX(2L);
		tile4.setPosY(2L);
		dao.create(tile);
		dao.create(tile2);
		dao.create(tile3);
		dao.create(tile4);

		Map<Long,List<Tile>> tiles = dao.getTilesInRectangle(1L, 1L, 2L, 2L);
		assertTrue("There should be two stripes of tiles",tiles.size()==2);
		
		// check that in each row are two tiles and moreover these has to be sorted by posY ascendant
		for(Entry<Long,List<Tile>>stripe: tiles.entrySet()){
			assertTrue("Two tiles in each stripe",stripe.getValue().size()==2);
			assertTrue("Tiles Within stripe are sorted by posY",stripe.getValue().get(0).getPosY()<stripe.getValue().get(1).getPosY());
		}
		
		
	}
    
    public Tile getTile(){
    	Tile t = new Tile();
    	t.setImprovements(new HashSet<TileImprovement>());
    	t.setPosX(2L);
    	t.setPosY(2L);
//    	t.setUnits(new HashSet<Unit>());
    	t.setTerrain(getTerrain());
    	return t;
    }

    private City getCity(){
    	City c = new City();
    	Tile t = getTile();
    	dao.create(t);
    	c.setCityCentre(t);
    	c.setWeLoveDay(true);
    	c.setHomeUnits(new HashSet<Unit>());
    	c.setImprovements(new HashSet<CityImprovement>());
//    	c.setManagedTiles(new HashSet<Tile>());
    	c.setName("newark");
    	c.setOwner(getPlayer());
    	c.setSize(25);
    	c.setTradeRoutes(new HashSet<TradeRoute>());
    	cDao.create(c);
    	return c;
    }
    public Player getPlayer(){
    	Player p  = new Player();
    	p.setName("mighty Stew");
    	p.setAdvances(new HashSet<Advance>());
    	pDao.create(p);
    	return p;
    }
    private Terrain getTerrain(){
		Terrain terrain = new Terrain();
		terrain.setIdent("grass"+no++);
		terDao.create(terrain);
		return terrain;
	}
    
	
}
