package test.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import test.jpa.TestEntity;

@Stateless
public class TestEJBBean implements TestEJB {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(TestEntity obj) {
        //em.getTransaction().begin();
        em.persist(obj);
        /*em.getTransaction().commit();
        em.close();*/
    }

    @Override
    public TestEntity read() {
        //em.getTransaction().begin();
        TestEntity test = em.find(TestEntity.class, 1L);
        /*em.getTransaction().commit();
        em.close();*/
        return test;
    }
    
    @Override
    public void error() throws Exception
    {
        throw new Exception("test");
    }
}
