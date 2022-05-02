package henresearch.spring.core;

import henresearch.spring.core.repository.CategoryRepository;
import henresearch.spring.core.repository.CustomerRepository;
import henresearch.spring.core.repository.ProductRepository;
import henresearch.spring.core.service.CategoryService;
import henresearch.spring.core.service.CustomerService;
import henresearch.spring.core.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
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


    @Test
    void testSetterDependencyInjection() {
        CategoryService categoryService = applicationContext.getBean(CategoryService.class);
        CategoryRepository categoryRepository = applicationContext.getBean(CategoryRepository.class);

        Assertions.assertSame(categoryRepository, categoryService.getCategoryRepository());
    }

    @Test
    void testFieldDependencyInjection(){
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        CustomerRepository customerRepository = applicationContext.getBean(CustomerRepository.class);

        Assertions.assertSame(customerService.getCustomerRepository(), customerRepository);
    }
}