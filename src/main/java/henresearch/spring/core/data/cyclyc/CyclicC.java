package henresearch.spring.core.data.cyclyc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CyclicC {

    private CyclicA cyclicA;

}
