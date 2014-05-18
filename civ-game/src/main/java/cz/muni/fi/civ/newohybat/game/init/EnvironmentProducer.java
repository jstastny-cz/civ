package cz.muni.fi.civ.newohybat.game.init;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.transaction.Status;
import javax.transaction.UserTransaction;

import org.jbpm.runtime.manager.impl.RuntimeEnvironmentBuilder;
import org.jbpm.runtime.manager.impl.cdi.InjectableRegisterableItemsFactory;
import org.jbpm.services.task.identity.JBossUserGroupCallbackImpl;
import org.kie.api.KieBase;
import org.kie.internal.runtime.manager.RuntimeEnvironment;
import org.kie.internal.runtime.manager.cdi.qualifier.PerProcessInstance;
import org.kie.internal.runtime.manager.cdi.qualifier.PerRequest;
import org.kie.internal.runtime.manager.cdi.qualifier.Singleton;
import org.kie.internal.task.api.UserGroupCallback;

@ApplicationScoped
public class EnvironmentProducer {
	@Inject
    private BeanManager beanManager;

    private EntityManagerFactory emf;
    @Produces
    @Singleton
    @PerRequest
    @PerProcessInstance
    public RuntimeEnvironment produceEnvironment(EntityManagerFactory emf,KieBase kbase) {
        RuntimeEnvironment environment = RuntimeEnvironmentBuilder.getDefault()
                .registerableItemsFactory(InjectableRegisterableItemsFactory.getFactory(beanManager, null))
                .entityManagerFactory(emf)
                .knowledgeBase(kbase)
                .persistence(true)
                .get();
        return environment;
    }
    
    @Produces    
    public UserGroupCallback produceSelectedUserGroupCalback() {
        return new JBossUserGroupCallbackImpl("classpath:/usergroup.properties");
    }
    
    @PersistenceUnit(unitName = "org.jbpm.domain")
    @ApplicationScoped
    @Produces
    public EntityManagerFactory getEntityManagerFactory() {
        if (this.emf == null) {
            this.emf = Persistence.createEntityManagerFactory("org.jbpm.domain");
        }
        return this.emf;
    }
    @Produces
    public EntityManager getEntityManager() {
        final EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityManager emProxy = (EntityManager) 
                Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{EntityManager.class}, new EmInvocationHandler(em));
        return emProxy;
    }
    
    private class EmInvocationHandler implements InvocationHandler {

        private EntityManager delegate;
        
        EmInvocationHandler(EntityManager em) {
            this.delegate = em;
        }
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            joinTransactionIfNeeded();
            return method.invoke(delegate, args);
        }
        
        private void joinTransactionIfNeeded() {
            try {
                UserTransaction ut = InitialContext.doLookup("java:comp/UserTransaction");
                if (ut.getStatus() == Status.STATUS_ACTIVE) {
                    delegate.joinTransaction();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
