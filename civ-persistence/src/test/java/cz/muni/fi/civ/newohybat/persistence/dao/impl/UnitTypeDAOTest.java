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
import cz.muni.fi.civ.newohybat.persistence.dao.iface.UnitTypeDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Action;
import cz.muni.fi.civ.newohybat.persistence.entities.UnitType;
import cz.muni.fi.civ.newohybat.persistence.enums.MovementArea;


@RunWith(Arquillian.class)
public class UnitTypeDAOTest {
	private static int no=0;
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
        		.addPackage(UnitType.class.getPackage())
        		.addClasses(UnitType.class,UnitTypeDAO.class,UnitTypeDAOImpl.class)
        		.addClasses(MovementArea.class)
        		.addClasses(BaseDAO.class,BaseDAOImpl.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("META-INF/jbossas-ds.xml");
    }
	private UnitType type;

	@PersistenceContext
	EntityManager em;
	
	@Inject
    UserTransaction utx;
	
	@Inject
	UnitTypeDAO dao;
	
    
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
    	type = this.getUnitType();
    	dao.create(type);
        assertNotNull(type.getIdent());
        
    }
	
	@Test
	public void testGetById(){
		type = this.getUnitType();
		dao.create(type);
		String ident = type.getIdent();
		
		UnitType fromDB = dao.getByIdent(ident);
		
		assertEquals(type,fromDB);
	}
	
	@Test
	public void testDelete(){
		type = this.getUnitType();
		dao.create(type);
		String ident = type.getIdent();
		
		dao.delete(type);
		
		UnitType fromDB = dao.getByIdent(ident);
		
		assertNull(fromDB);
	}
    
	@Test
	public void testUpdate(){
		type = this.getUnitType();
		dao.create(type);
		
		type.setName("newIdent"+no++);
		String ident = type.getIdent();
		commitTransaction();
		startTransaction();
		UnitType check = dao.getByIdent(ident);
		
		assertEquals(type.getName(), check.getName());
	}
	
	@Test
	public void testGetAll(){
		type = this.getUnitType();
		dao.create(type);
		UnitType another = this.getUnitType();
		dao.create(another);
		assertTrue(dao.getAll().contains(type)&&dao.getAll().contains(another));
	}
	
    public UnitType getUnitType(){
    	UnitType t = new UnitType();
    	t.setIdent("knight"+no++);
    	t.setName("knight");
    	t.setDescription("Dude with sword.");
    	t.setActions(new HashSet<Action>());
    	return t;
    	
    }
	
}
