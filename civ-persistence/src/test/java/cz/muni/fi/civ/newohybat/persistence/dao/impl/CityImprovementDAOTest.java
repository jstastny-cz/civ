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
import cz.muni.fi.civ.newohybat.persistence.dao.iface.CityImprovementDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.CityImprovement;
import cz.muni.fi.civ.newohybat.persistence.enums.MovementArea;


@RunWith(Arquillian.class)
public class CityImprovementDAOTest {
	private static int no=0;
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
        		.addPackage(CityImprovement.class.getPackage())
        		.addClasses(CityImprovement.class,CityImprovementDAO.class,CityImprovementDAOImpl.class)
        		.addClasses(MovementArea.class)
        		.addClass(BaseDAO.class)
        		.addClass(BaseDAOImpl.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("META-INF/jbossas-ds.xml");
    }
	private CityImprovement improvement;

	@PersistenceContext
	EntityManager em;
	
	@Inject
    UserTransaction utx;
	
	@Inject
	CityImprovementDAO dao;
    
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
    	improvement = this.getCityImprovement();
    	dao.create(improvement);
        assertNotNull(improvement.getIdent());
        
    }
	
	@Test
	public void testGetById(){
		improvement = this.getCityImprovement();
		dao.create(improvement);
		String ident = improvement.getIdent();
		
		CityImprovement imp2 = dao.getByIdent(ident);
		
		assertEquals(improvement,imp2);
	}
	
	@Test
	public void testDelete(){
		improvement = this.getCityImprovement();
		dao.create(improvement);
		String ident = improvement.getIdent();
		
		dao.delete(improvement);
		
		CityImprovement imp2 = dao.getByIdent(ident);
		
		assertNull(imp2);
	}
    
	@Test
	public void testUpdate(){
		improvement = this.getCityImprovement();
		dao.create(improvement);
		
		improvement.setName("newName");
		String ident = improvement.getIdent();
		
		CityImprovement check = dao.getByIdent(ident);
		
		assertEquals("newName", check.getName());
	}
	
	@Test
	public void testGetAll(){
		improvement = this.getCityImprovement();
		dao.create(improvement);
		CityImprovement another = this.getCityImprovement();
		dao.create(another);
		assertTrue(dao.getAll().contains(improvement)&&dao.getAll().contains(another));
	}
	
    public CityImprovement getCityImprovement(){
    	CityImprovement imp = new CityImprovement();
    	imp.setIdent("market"+no++);
    	imp.setName("Market");
    	imp.setWonder(false);
    	return imp;
    	
    }
	
}
