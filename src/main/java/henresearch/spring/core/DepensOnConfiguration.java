package henresearch.spring.core;

import henresearch.spring.core.data.Bar;
import henresearch.spring.core.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

@Slf4j
@Configuration
public class DepensOnConfiguration {

    //default bean adalah dari atas kebawah

    @Lazy //lazy artinya si bean tidak akan dibuat sampai dia diakses atau dipanggil
    //nah begitu kita tambahkan depens on, si maka si depens on ini akan dibuat duluan
    //istilah lainnya memperioritaskan bean mana dulu yang akan dibuat
    @Bean
    @DependsOn({
            "bar"
    }) //artinya si bean foo ini akan dibuat setelah si bar dibuat
    public Foo foo(){
        log.info("Create new Foo");
        return new Foo();
    }

    @Bean
    public Bar bar(){
        log.info("Create new bar");
        return new Bar();
    }

}
