package test.jsf;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.annotation.PostConstruct;
/**
 *
 * @author empyreanx
 */
@Named
@ViewScoped
public class NavBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String view;
    
    @PostConstruct
    public void init()
    {
        view = "view1";
    }
    
    public void setView(String view) {
        this.view = view;
    }
    
    public String getView()
    {
        return view;
    }
}
