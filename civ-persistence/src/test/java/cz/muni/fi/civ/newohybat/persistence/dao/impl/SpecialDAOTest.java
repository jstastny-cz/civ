package cz.muni.fi.civ.newohybat.persistence.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
import cz.muni.fi.civ.newohybat.persistence.dao.iface.SpecialDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Special;
import cz.muni.fi.civ.newohybat.persistence.enums.MovementArea;

@RunWith(Arquillian.class)
public class SpecialDAOTest {
	private static int no=0;
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
        		.addPackage(Special.class.getPackage())
        		.addClass(Special.class)
        		.addClass(SpecialDAO.class)
        		.addClass(SpecialDAOImpl.class)
        		.addClasses(MovementArea.class)
        		.addClass(BaseDAO.class)
        		.addClass(BaseDAOImpl.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("META-INF/jbossas-ds.xml");
    }
	private Special special;
	@PersistenceContext
	EntityManager em;
	
	@Inject
    UserTransaction utx;
	
	@Inject
	SpecialDAO dao;
	
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
    	special = this.getSpecial();
    	dao.create(special);
        assertNotNull(special.getIdent());
        
    }
	
	@Test
	public void testGetById(){
		special = this.getSpecial();
		dao.create(special);
		String ident = special.getIdent();
		
		Special imp2 = dao.getByIdent(ident);
		
		assertEquals(special,imp2);
	}
	
	@Test
	public void testDelete(){
		special = this.getSpecial();
		dao.create(special);
		
		String ident = special.getIdent();
		
		dao.delete(special);
		
		Special fromDB = dao.getByIdent(ident);
		
		assertNull(fromDB);
		
	}
	
	@Test
	public void testCreateDuplicate(){
		special = this.getSpecial();
		dao.create(special);
		String ident = special.getIdent();
		dao.create(special);
		String ident2 = special.getIdent();
		assertEquals(ident,ident2);
	}
	
	@Test
	public void testGetAll(){
		special = this.getSpecial();
		Special another = this.getSpecial();
		
		dao.create(special);
		dao.create(another);
		
		assertTrue(dao.getAll().contains(special)&&dao.getAll().contains(another));
	}
	
	private Special getSpecial(){
		Special special = new Special();
		special.setIdent("ruby"+no++);
		special.setName("name");
		return special;
	}
}
