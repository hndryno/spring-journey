package henresearch.spring.core.data.cyclyc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CyclicA {

    private CyclicB cyclicB;

}
