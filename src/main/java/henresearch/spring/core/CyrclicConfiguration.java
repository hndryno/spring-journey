package henresearch.spring.core;

import henresearch.spring.core.data.cyclyc.CyclicA;
import henresearch.spring.core.data.cyclyc.CyclicB;
import henresearch.spring.core.data.cyclyc.CyclicC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// cyrcular dependencies adalah dependency yang dipanggil berulang
// misal cyclicA butuh cyclic, cyclic B butuh cyclic C, Cyclic C butuh cyclic A
// jangan pernah membuat seperti ini, karena akan error
@Configuration
public class CyrclicConfiguration {

    @Bean
    public CyclicA cyclicA(CyclicB cyclicB){
        return new CyclicA(cyclicB);
    }

    @Bean
    public CyclicB cyclicB(CyclicC cyclicC){
        return new CyclicB(cyclicC);
    }

    @Bean
    public CyclicC cyclicC(CyclicA cyclicA){
        return new CyclicC(cyclicA);
    }

}
