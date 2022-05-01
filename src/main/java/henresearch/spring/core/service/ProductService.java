package henresearch.spring.core.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Lazy
//@Scope("prototype")
//semua annotation yang telah kita pelajari bisa kita taruh juga di @component
@Component
//jika kita menambahkan @Component maka secara otomatis spring akan membuatkan bean untuk class tersebut
//component hanya mendukung pembuatan 1 bean, jadi jika ingin membuat beberapa bean dengan
//tipe yang sama, kita tetap harus menggunakan @bean method
public class ProductService {
}
