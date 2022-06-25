package test.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class StartupBean {
    @PostConstruct
    public void init() {
        System.out.println("Help!");
    }
}
