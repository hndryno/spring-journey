package henresearch.spring.core;

import henresearch.spring.core.data.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleTest {


//    private ApplicationContext applicationContext;
    // karena method close tidak ada di applicationContext, jadi yang dipanggil adalah method turunannya yaitu
    // configurableApplicationContext

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(LifecycleConfiguration.class);
        applicationContext.registerShutdownHook(); //ini sama saja dengan applicationContext.close()
    }

    @AfterEach
    void tearDown() {
//        applicationContext.close();
    }

    @Test
    void testConnection() {
        Connection connec = applicationContext.getBean(Connection.class);
    }
}
