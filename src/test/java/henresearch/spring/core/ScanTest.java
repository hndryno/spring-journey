package henresearch.spring.core;


import henresearch.spring.core.configuration.ScanConfiguration;
import henresearch.spring.core.data.Bar;
import henresearch.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScanTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext  =new AnnotationConfigApplicationContext(ScanConfiguration.class);
    }

    @Test
    void testScan() {
        Foo foo = applicationContext.getBean(Foo.class);
        Bar bar = applicationContext.getBean(Bar.class);
    }
}
