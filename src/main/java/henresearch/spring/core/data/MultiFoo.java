package henresearch.spring.core.data;

import lombok.Getter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MultiFoo {

    //sebenarnya object provider sudah jarang digunakan lagi,
    // yang sering digunakan sekarang adalah Optional<T>
    @Getter
    private List<Foo> foos;

    public MultiFoo(ObjectProvider<Foo> objectProvider){
        //objectProvider.getIfAvailable() //ambil 1 foonya
        //atau kalau mau ambil semua foo maka pakai stream

        foos = objectProvider.stream().collect(Collectors.toList());

    }
}
