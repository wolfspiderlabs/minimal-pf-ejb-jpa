package test.ejb;

import test.jpa.*;
import test.jsf.CustomException;

public interface TestEJB {
    public void save(TestEntity obj);
    public TestEntity read();
    public void error() throws CustomException;
    public void intercept() throws TestException;
}
