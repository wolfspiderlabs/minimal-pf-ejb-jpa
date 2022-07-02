package test.jsf;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import test.ejb.TestEJB;
import test.jpa.TestEntity;

@Named
//@ViewScoped
@RequestScoped
public class TestBean implements Serializable {
    private static final long serialVersionUID = 4874297007974595139L;
    
    @EJB
    private TestEJB testEJB;
    
    @Inject
    SessionBean sessionBean;
    
    @NotNull
    private String text;

    public TestBean() {
        
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public String write() {
        TestEntity test = new TestEntity(this.text);
        testEJB.save(test);
        this.text = null;
        return "/";
    }
    
    public String read() {
        TestEntity test = testEJB.read();
        
        if (test != null)
            this.text = test.getMessage();
        //else
        //    message = null;
        
        return "/";
    }
    
    public void error() throws CustomException
    {
        testEJB.error();
    }
    
    public void user() {
        sessionBean.setUserId(new Long(15));
    }
    
    public void intercept() throws CustomException
    {
       // try {
            testEJB.intercept();
        //} catch (TestException e) {
        //    throw new CustomException();
        //}
    }    
}
