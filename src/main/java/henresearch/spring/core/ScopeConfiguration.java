package henresearch.spring.core;

import henresearch.spring.core.data.Bar;
import henresearch.spring.core.data.Foo;
import henresearch.spring.core.scope.DoubletonScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Slf4j
@Configuration
public class ScopeConfiguration {

    //pengertian scope
    //scope adalah strategy cara sebuah object dibuat
    //secara default strategy object ddi spring adalah singleton
    //akses pertama kedua dan ketiga adalah object yang sama, jika singleton

    //macam macam scope
    //1. singleton = default hanya dibuat sekali dalam spring ioc
    //2. prototipe = selalu dibuat object baru setiap mengakses bean
    //3. request = dibuat baru per http request (hanya untuk webApp)
    //4. session = dibuat per http session (hanya untuk web app)
    //5. application = dibuat baru per servletContext (hanya uintuk web App)
    //6 websocket = dibuat baru per webSocket (hanya untuk web socket app)

    @Bean
    @Scope("prototype")  //contoh scope
    public Foo foo(){
        log.info("create bean");
        return new Foo();
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer(){
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("doubleton", new DoubletonScope());
        return configurer;
    }

    @Bean
    @Scope("doubleton")
    public Bar bar(){
        log.info("create new bar");
        return new Bar();
    }



}
