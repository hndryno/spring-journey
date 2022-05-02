package henresearch.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "henresearch.spring.core.configuration",
        "henresearch.spring.core.repository",
        "henresearch.spring.core.service",
})
public class ComponentConfiguration {
}
