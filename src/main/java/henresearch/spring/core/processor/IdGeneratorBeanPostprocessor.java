package henresearch.spring.core.processor;

import henresearch.spring.core.aware.IdAware;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class IdGeneratorBeanPostprocessor implements BeanPostProcessor {
    //bean post processor digunakan untuk memanipulasi bean bean yang kita mau
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //kalau bean itu turunan dari IdAware
        log.info("Id Generator Processor, for bean {}", beanName);
        if(bean instanceof IdAware){
            log.info("Set Id Generator for bean {}", beanName);
            IdAware idAware = (IdAware) bean;
            idAware.setId(UUID.randomUUID().toString());
        }

        return bean;
    }
}
