package test.jsf;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import test.ejb.TestEJB;
import test.jpa.TestEntity;

@Named
@ViewScoped
public class TestBean implements Serializable {
    private static final long serialVersionUID = 4874297007974595139L;
    
    @EJB
    private TestEJB testEJB;
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
}
