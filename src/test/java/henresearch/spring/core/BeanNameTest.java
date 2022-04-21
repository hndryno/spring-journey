package henresearch.spring.core;


import henresearch.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanNameTest {
    @BeforeEach
    void name() {
        ac = new AnnotationConfigApplicationContext(BeanNameConfiguration.class);
    }

    private ApplicationContext ac;

    @Test
    void TestGetPrimary(){
        Foo foo =  ac.getBean(Foo.class);

        Foo foo1 = ac.getBean("fooFirst", Foo.class);
        Foo foo2 = ac.getBean("fooSecond", Foo.class);

        Assertions.assertSame(foo, foo1);
        Assertions.assertNotSame(foo1, foo2);
    }


}
