package henresearch.spring.core;

import henresearch.spring.core.data.MultiFoo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
        "henresearch.spring.core.configuration",
        "henresearch.spring.core.repository",
        "henresearch.spring.core.service",
})
@Import(MultiFoo.class) //import class multiFoonya
public class ComponentConfiguration {
}
