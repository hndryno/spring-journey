package henresearch.spring.core.service;

import henresearch.spring.core.repository.CustomerRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//menggunakan cara ini sudah tidak direkomendasikan lagi
//field based dependency injection
@Component
public class CustomerService {

    @Getter
    @Autowired
    private CustomerRepository customerRepository;

}
