package henresearch.spring.core;

import henresearch.spring.core.data.Connection;
import henresearch.spring.core.data.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifecycleConfiguration {

    @Bean
    public Connection connection(){
        return new Connection();
    }

//    @Bean(initMethod = "start", destroyMethod = "stop")//ada cara lain lain selain ini
    //yaitu menuliskan annotation @PostConstruct dan @Predestroy di class servernya
    @Bean
    public Server server(){
        return new Server();
    }


}
