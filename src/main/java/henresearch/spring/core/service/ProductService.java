package henresearch.spring.core.service;

import henresearch.spring.core.repository.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Lazy
//@Scope("prototype")
//semua annotation yang telah kita pelajari bisa kita taruh juga di @component
//jika kita menambahkan @Component maka secara otomatis spring akan membuatkan bean untuk class tersebut
//component hanya mendukung pembuatan 1 bean, jadi jika ingin membuat beberapa bean dengan
//tipe yang sama, kita tetap harus menggunakan @bean method
@Component
public class ProductService {

    @Getter
    private ProductRepository productRepository;

    @Autowired //autowired gunanya untuk menandai constructor mana yang akan digunakan untuk spring
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ProductService(ProductRepository productRepository, String name){
        this.productRepository = productRepository;
    }
}
