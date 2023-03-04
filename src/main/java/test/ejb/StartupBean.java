package test.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

@Startup
@Singleton
public class StartupBean {
    @PostConstruct
    public void init() {
        System.out.println("Help!");
    }
}
