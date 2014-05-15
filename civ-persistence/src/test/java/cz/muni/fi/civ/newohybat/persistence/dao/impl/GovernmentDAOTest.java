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
import cz.muni.fi.civ.newohybat.persistence.dao.iface.GovernmentDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Government;
import cz.muni.fi.civ.newohybat.persistence.enums.MovementArea;


@RunWith(Arquillian.class)
public class GovernmentDAOTest {
	private static int no=0;
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
        		.addPackage(Government.class.getPackage())
        		.addClass(Government.class)
        		.addClass(GovernmentDAO.class)
        		.addClass(GovernmentDAOImpl.class)
        		.addClasses(MovementArea.class)
        		.addClass(BaseDAO.class)
        		.addClass(BaseDAOImpl.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("META-INF/jbossas-ds.xml");
    }
	private Government gov;

	@PersistenceContext
	EntityManager em;
	
	@Inject
    UserTransaction utx;
	
	@Inject
	GovernmentDAO dao;
    
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
    	gov = this.getGovernment();
    	dao.create(gov);
        assertNotNull(gov.getIdent());
        
    }
	
	@Test
	public void testGetById(){
		gov = this.getGovernment();
		dao.create(gov);
		String ident = gov.getIdent();
		
		Government fromDB = dao.getByIdent(ident);
		
		assertEquals(gov,fromDB);
	}
	
	@Test
	public void testDelete(){
		gov = this.getGovernment();
		dao.create(gov);
		String ident = gov.getIdent();
		
		dao.delete(gov);
		
		Government fromDB = dao.getByIdent(ident);
		
		assertNull(fromDB);
	}
    
	@Test
	public void testUpdate(){
		gov = this.getGovernment();
		dao.create(gov);
		
		gov.setName("newIdent"+no++);
		String ident = gov.getIdent();
		commitTransaction();
		startTransaction();
		Government check = dao.getByIdent(ident);
		
		assertEquals(gov.getName(), check.getName());
	}
	
	@Test
	public void testGetAll(){
		gov = this.getGovernment();
		dao.create(gov);
		Government another = this.getGovernment();
		dao.create(another);
		assertTrue(dao.getAll().contains(gov)&&dao.getAll().contains(another));
	}
	
    public Government getGovernment(){
    	Government g = new Government();
    	g.setIdent("democracy"+no++);
    	g.setName("Democracy");
    	return g;
    	
    }
	
}
