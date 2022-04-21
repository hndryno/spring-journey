package henresearch.spring.core;


import henresearch.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DuplicateTest {

    @Test
    void testGetDuplicateBean(){
        ApplicationContext c = new AnnotationConfigApplicationContext(
                DuplicateConfiguration.class
        );

//        Foo f = c.getBean(Foo.class);

        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            Foo f = c.getBean(Foo.class);
        });
    }

    @Test
    void testGetDuplicateBeanBerhasil(){
        //cara memanggil bean dengan tipe data yang sama, yaitu beri nama saja beannya saat dipanggil
        ApplicationContext c = new AnnotationConfigApplicationContext(
                DuplicateConfiguration.class
        );

        Foo foo1 = c.getBean("foo1", Foo.class);
        Foo foo2 = c.getBean("foo2", Foo.class);

        Assertions.assertNotSame(foo1, foo2);
    }

}


