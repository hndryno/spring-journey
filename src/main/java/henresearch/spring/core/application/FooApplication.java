package henresearch.spring.core.application;

import henresearch.spring.core.data.Foo;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FooApplication {

    @Bean
    public Foo foo(){
        return new Foo();
    }

//    public static void main(String[] args) {
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(FooApplication.class, args);
//        Foo foo = applicationContext.getBean(Foo.class);
//        System.out.println(foo);
//    }

    //customize si spring boot application
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FooApplication.class);
        //custom si spring bootnya, misal kita pengen bikin bannernya off
        application.setBannerMode(Banner.Mode.OFF);
         ConfigurableApplicationContext applicationContext = application.run(args);
         Foo foo = applicationContext.getBean(Foo.class);
         System.out.println(foo);
    }

}
