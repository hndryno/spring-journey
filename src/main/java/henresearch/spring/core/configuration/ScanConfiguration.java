package henresearch.spring.core.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//component scan memungkinkan kita untuk men-scan componen
// jadi tanpa import bisa memanggil bean yang ada di package tanpa importj
@Configuration
@ComponentScan(basePackages = {
        "henresearch.spring.core.configuration"
})
public class ScanConfiguration {
}
