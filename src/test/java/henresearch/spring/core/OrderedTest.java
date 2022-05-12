package henresearch.spring.core;

import henresearch.spring.core.data.Car;
import henresearch.spring.core.processor.IdGeneratorBeanPostprocessor;
import henresearch.spring.core.processor.PrefixIdGeneratorBeanPostprocessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class OrderedTest {

    @Configuration
    @Import({
            Car.class,
            IdGeneratorBeanPostprocessor.class,
            PrefixIdGeneratorBeanPostprocessor.class
    })
    public static class testConfiguration{

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(testConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testCar() {
        Car car = applicationContext.getBean(Car.class);

        Assertions.assertNotNull(car.getId());
        Assertions.assertTrue(car.getId().startsWith("PZN-"));
    }
}
