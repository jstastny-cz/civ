package cz.muni.fi.civ.newohybat.persistence.dao.impl;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.AdvanceDAO;
import cz.muni.fi.civ.newohybat.persistence.dao.iface.BaseDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Advance;
import cz.muni.fi.civ.newohybat.persistence.entities.CityImprovement;
import cz.muni.fi.civ.newohybat.persistence.entities.Government;
import cz.muni.fi.civ.newohybat.persistence.entities.UnitType;
import cz.muni.fi.civ.newohybat.persistence.enums.MovementArea;
import cz.muni.fi.civ.newohybat.persistence.facade.dto.AdvanceDTO;


@RunWith(Arquillian.class)
public class AdvanceDAOTest {
	private static int no=0;
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
        		.addPackage(Advance.class.getPackage())
        		.addClasses(Advance.class,AdvanceDAO.class,AdvanceDAOImpl.class)
        		.addClasses(BaseDAO.class,BaseDAOImpl.class)
        		.addClasses(MovementArea.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsResource("META-INF/jbossas-ds.xml");
    }
	private Advance advance;

	@PersistenceContext
	EntityManager em;
	
	@Inject
    UserTransaction utx;
	
	@Inject
	AdvanceDAO dao;
    
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
    	advance = this.getAdvance();
    	dao.create(advance);
        assertNotNull(advance.getIdent());
        
        Advance next = this.getAdvance();
        next.setIdent("previous");
        Set<Advance> enabledAdvances = new HashSet<Advance>();
        enabledAdvances.add(advance);
        next.setEnabledAdvances(enabledAdvances);
        Advance returned = dao.create(next);
        Assert.assertNotNull(returned);
        Assert.assertTrue(returned.getEnabledAdvances().size()==1);
    }
	
	@Test
	public void testGetById(){
		advance = this.getAdvance();
		dao.create(advance);
		String ident = advance.getIdent();
		Advance fromDB = dao.getByIdent(ident);
		
		assertEquals(advance,fromDB);
	}
	
	@Test
	public void testDelete(){
		advance = this.getAdvance();
		dao.create(advance);
		String ident = advance.getIdent();
		
		dao.delete(advance);
		
		Advance fromDB = dao.getByIdent(ident);
		
		assertNull(fromDB);
	}
    
	@Test
	public void testUpdate(){
		advance = this.getAdvance();
		dao.create(advance);
		
		advance.setName("new name");
		String ident = advance.getIdent();
		
		Advance check = dao.getByIdent(ident);
		
		assertEquals("new name", check.getName());
	}
	
	@Test
	public void testGetAll(){
		advance = this.getAdvance();
		dao.create(advance);
		Advance another = this.getAdvance();
		dao.create(another);
		assertTrue(dao.getAll().contains(advance)&&dao.getAll().contains(another));
	}
    
    public Advance getAdvance(){
    	Advance a  = new Advance();
    	a.setIdent("the_wheel"+no++);
    	a.setName("The Wheel");
    	a.setEnabledGovernments(new HashSet<Government>());
    	a.setEnabledCityImprovements(new HashSet<CityImprovement>());
    	a.setEnabledUnitTypes(new HashSet<UnitType>());
    	a.setEnabledAdvances(new HashSet<Advance>());
    	return a;
    }
    
	
}
