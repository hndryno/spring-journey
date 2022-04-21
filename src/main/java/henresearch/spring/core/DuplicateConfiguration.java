package henresearch.spring.core;

import henresearch.spring.core.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class DuplicateConfiguration {

    @Bean
    public Foo foo1(){
        Foo foo = new Foo();
        return foo;
    }

    @Bean
    public Foo foo2(){
        Foo foo = new Foo();
        return foo;
    }
}
