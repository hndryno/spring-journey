package henresearch.spring.core;

import henresearch.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependOnTest {


    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(DepensOnConfiguration.class);
    }

    @Test
    void testDepensOn(){
        Foo foo = applicationContext.getBean(Foo.class);
    }


}
