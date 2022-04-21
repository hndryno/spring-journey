package henresearch.spring.core;

import henresearch.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

    @Test
    void testCreateBean(){
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
    }

    void testGetBean(){
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        //jadi pertama akan ke create foo1, nah foo2 itu cuma langsung manggil beannya saja, proses create ada di foo1
        Foo foo1 = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class);

        //untuk memastikan bahwa mereka ini adalah object yang sama
        Assertions.assertSame(foo1, foo2);
    }


}
