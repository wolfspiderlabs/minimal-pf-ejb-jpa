package test.ejb;

import test.jpa.*;

public interface TestEJB {
    public void save(TestEntity obj);
    public TestEntity read();
}
