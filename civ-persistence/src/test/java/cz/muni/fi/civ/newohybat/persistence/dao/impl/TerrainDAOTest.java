package cz.muni.fi.civ.newohybat.persistence.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
import cz.muni.fi.civ.newohybat.persistence.dao.iface.TerrainDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Terrain;
import cz.muni.fi.civ.newohybat.persistence.enums.MovementArea;

@RunWith(Arquillian.class)
public class TerrainDAOTest {
	private static int no=0;
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
        		.addPackage(Terrain.class.getPackage())
        		.addClass(TerrainDAO.class)
        		.addClass(TerrainDAOImpl.class)
        		.addClasses(MovementArea.class)
        		.addClass(BaseDAO.class)
        		.addClass(BaseDAOImpl.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("META-INF/jbossas-ds.xml");
    }
	private Terrain terrain;
	@PersistenceContext
	EntityManager em;
	
	@Inject
    UserTransaction utx;
	
	@Inject
	TerrainDAO dao;
	
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
    	terrain = this.getTerrain();
    	dao.create(terrain);
        assertNotNull(terrain.getIdent());
        
    }
	
	@Test
	public void testGetByIdent(){
		terrain = this.getTerrain();
		dao.create(terrain);
		String ident = terrain.getIdent();
		
		Terrain imp2 = dao.getByIdent(ident);
		
		assertEquals(terrain,imp2);
	}
	
	@Test
	public void testDelete(){
		terrain = this.getTerrain();
		dao.create(terrain);
		
		String ident = terrain.getIdent();
		
		dao.delete(terrain);
		
		Terrain fromDB = dao.getByIdent(ident);
		
		assertNull(fromDB);
		
	}
	
	@Test
	public void testCreateDuplicate(){
		terrain = this.getTerrain();
		dao.create(terrain);
		String ident = terrain.getIdent();
		dao.create(terrain);
		String ident2 = terrain.getIdent();
		assertEquals(ident,ident2);
	}
	
	@Test
	public void testGetAll(){
		terrain = this.getTerrain();
		Terrain another = this.getTerrain();
		
		dao.create(terrain);
		dao.create(another);
		
		List<Terrain> terrains = new ArrayList<Terrain>();
		terrains.add(terrain);
		terrains.add(another);
		
		assertTrue(dao.getAll().contains(terrain)&&dao.getAll().contains(another));
	}
	
	private Terrain getTerrain(){
		Terrain terrain = new Terrain();
		terrain.setIdent("grass"+no++);
		return terrain;
	}
}
