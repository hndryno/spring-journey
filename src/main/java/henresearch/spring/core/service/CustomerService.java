package henresearch.spring.core.service;

import henresearch.spring.core.repository.CustomerRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//menggunakan cara ini sudah tidak direkomendasikan lagi
//field based dependency injection
@Component
public class CustomerService {

    //misal ada 2 bean yang sama, dan kita ingin pakai 2 2nya
    //pada kasus inilah kita bisa pakai @Qualifier

    @Getter
    @Autowired
    @Qualifier("normalCustomerRepository")
    private CustomerRepository normalCustomerRepository;

    @Getter
    @Autowired
    @Qualifier("premiumCustomerRepository")
    private CustomerRepository premiumCustomerRepository;

}
