package test.jsf;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import test.ejb.TestEJB;
import test.jpa.TestEntity;

@Named
@SessionScoped
//@RequestScoped
public class TestBean implements Serializable {
    private static final long serialVersionUID = 4874297007974595139L;
    
    @EJB
    private TestEJB testEJB;
    private String message;

    public TestBean() {
        
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String write() {
        TestEntity test = new TestEntity(message);
        testEJB.save(test);
        message = null;
        return "/";
    }
    
    public String read() {
        TestEntity test = testEJB.read();
        
        if (test != null)
            message = test.getMessage();
        //else
        //    message = null;
        
        return "/";
    }
}
