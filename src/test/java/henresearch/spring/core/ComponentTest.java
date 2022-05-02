package henresearch.spring.core;

import henresearch.spring.core.repository.ProductRepository;
import henresearch.spring.core.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testService() {
        ProductService pro1 = applicationContext.getBean(ProductService.class);
        ProductService pro2 = applicationContext.getBean("productService", ProductService.class);

        Assertions.assertSame(pro1, pro2);
    }

    @Test
    void testConstructorDependencyInjection(){
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);
        ProductService productService = applicationContext.getBean(ProductService.class);
        Assertions.assertSame(productRepository, productService.getProductRepository());
    }

}