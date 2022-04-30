package henresearch.spring.core.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class Connection implements InitializingBean, DisposableBean {

    //ini akan dieksekusi setelah si beannya telah siap
    @Override
    public void destroy() throws Exception {
        log.info("Connection is close");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Connection is ready to use");
    }
}
