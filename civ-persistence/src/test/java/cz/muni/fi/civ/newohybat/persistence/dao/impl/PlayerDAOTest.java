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
import cz.muni.fi.civ.newohybat.persistence.entities.Advance;
import cz.muni.fi.civ.newohybat.persistence.entities.City;
import cz.muni.fi.civ.newohybat.persistence.entities.Player;
import cz.muni.fi.civ.newohybat.persistence.entities.Unit;
import cz.muni.fi.civ.newohybat.persistence.enums.MovementArea;


@RunWith(Arquillian.class)
public class PlayerDAOTest {
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
        		.addPackage(Player.class.getPackage())
        		.addClass(PlayerDAO.class)
        		.addClass(PlayerDAOImpl.class)
        		.addClasses(MovementArea.class)
        		.addClass(BaseDAO.class)
        		.addClass(BaseDAOImpl.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("META-INF/jbossas-ds.xml");
    }
	private Player player;

	@PersistenceContext
	EntityManager em;
	
	@Inject
    UserTransaction utx;
	
	@Inject
	PlayerDAO dao;
    
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
    	player = this.getPlayer();
    	dao.create(player);
        assertNotNull(player.getId());
        
    }
	
	@Test
	public void testGetById(){
		player = this.getPlayer();
		dao.create(player);
		Long id = player.getId();
		
		Player fromDB = dao.getById(id);
		
		assertEquals(player,fromDB);
	}
	
	@Test
	public void testDelete(){
		player = this.getPlayer();
		dao.create(player);
		Long id = player.getId();
		
		dao.delete(player);
		
		Player fromDB = dao.getById(id);
		
		assertNull(fromDB);
	}
    
	@Test
	public void testUpdate(){
		player = this.getPlayer();
		dao.create(player);
		
		player.setName("pathetic John");
		Long id = player.getId();
		
		Player check = dao.getById(id);
		
		assertEquals("pathetic John", check.getName());
	}
	
	@Test
	public void testGetAll(){
		player = this.getPlayer();
		dao.create(player);
		Player another = this.getPlayer();
		dao.create(another);
		assertTrue(dao.getAll().contains(player)&&dao.getAll().contains(another));
	}
    
    public Player getPlayer(){
    	Player p  = new Player();
    	p.setName("mighty Stew");
    	p.setAdvances(new HashSet<Advance>());
    	return p;
    }
    
	
}
