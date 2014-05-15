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

import cz.muni.fi.civ.newohybat.persistence.dao.iface.ActionDAO;
import cz.muni.fi.civ.newohybat.persistence.dao.iface.BaseDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Action;
import cz.muni.fi.civ.newohybat.persistence.enums.MovementArea;


@RunWith(Arquillian.class)
public class ActionDAOTest {
	private static int no=0;
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
        		.addClasses(Action.class,ActionDAO.class,ActionDAOImpl.class)
        		.addClasses(BaseDAO.class,BaseDAOImpl.class)
        		.addClasses(MovementArea.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("META-INF/jbossas-ds.xml");
    }
	private Action action;

	@PersistenceContext
	EntityManager em;
	
	@Inject
    UserTransaction utx;
	
	@Inject
	ActionDAO dao;
	
    
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
    	action = this.getAction();
    	dao.create(action);
        assertNotNull(action.getIdent());
        
    }
	
	@Test
	public void testGetById(){
		action = this.getAction();
		dao.create(action);
		String ident = action.getIdent();
		
		Action fromDB = dao.getByIdent(ident);
		
		assertEquals(action,fromDB);
	}
	
	@Test
	public void testDelete(){
		action = this.getAction();
		dao.create(action);
		String ident = action.getIdent();
		
		dao.delete(action);
		
		Action fromDB = dao.getByIdent(ident);
		
		assertNull(fromDB);
	}
    
	@Test
	public void testUpdate(){
		action = this.getAction();
		dao.create(action);
		
		action.setName("new name");
		String ident = action.getIdent();
		
		Action check = dao.getByIdent(ident);
		
		assertEquals("new name", check.getName());
	}
	
	@Test
	public void testGetAll(){
		action = this.getAction();
		dao.create(action);
		Action another = this.getAction();
		dao.create(another);
		assertTrue(dao.getAll().contains(action)&&dao.getAll().contains(another));
	}
    
    public Action getAction(){
    	Action  a  = new Action();
    	a.setIdent("fortify"+no++);
    	a.setName("Fortify");
    	return a;
    }
    
	
}
