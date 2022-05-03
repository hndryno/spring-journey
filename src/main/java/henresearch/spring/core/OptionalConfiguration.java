package henresearch.spring.core;

import henresearch.spring.core.data.Bar;
import henresearch.spring.core.data.Foo;
import henresearch.spring.core.data.FooBar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

//optional dependency

//secara default semua dependency itu wajib
//artinya jika spring tidak bisa menemukan bean yang dibutuhkan, maka secara otomatis akan terjadi error
//namun jika kita memang ingin membuat sebuah dependency menjadi optional artinya tidak wajib
//kita bisa warp dependency tersebut dengan menggunakan java.util.Optional<T>
//secara otomatis jika bean tersebut ternyata tidak ada, maka tidak akan terjadi error
//kita bisa menggunakan Optional<T> pada @bean(method parameter) atau pada component(constructor param, setter method, dll)

@Configuration
public class OptionalConfiguration {
    @Bean
    public Foo foo(){
        return new Foo();
    }

    @Bean
    public FooBar fooBar(Optional<Foo> foo, Optional<Bar> bar){
        return new FooBar(foo.orElse(null), bar.orElse(null));
    }
}
