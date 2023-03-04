package test.ejb;

import jakarta.ejb.Stateless;
import jakarta.interceptor.Interceptors;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import test.jpa.TestEntity;
import test.jsf.CustomException;

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
    public void error() throws CustomException {
        System.out.println("THROWING");
        throw new CustomException();
    }

    @Override
    @Interceptors(CustomInterceptor.class)
//    public void intercept() throws TestException {
    public void intercept() throws CustomException {


    }
}
