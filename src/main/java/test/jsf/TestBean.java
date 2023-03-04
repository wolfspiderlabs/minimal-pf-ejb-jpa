package test.jsf;

import java.io.Serializable;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotBlank;

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

    @NotBlank
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
