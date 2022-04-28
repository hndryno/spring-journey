package henresearch.spring.core;

import henresearch.spring.core.data.Bar;
import henresearch.spring.core.data.Foo;
import henresearch.spring.core.data.FooBar;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class DependencyInjectionConfiguration {

    //dependensi injection yang diberikan bean akan otomatis mencarikan bean yang lain
    @Bean
    public Foo foo(){
        return new Foo();
    }

    @Bean
    public Bar bar(){
        return new Bar();
    }

    @Bean
    public FooBar fooBar(Foo foo, Bar bar){
        return new FooBar(foo, bar);
    }


}
