package config;

import Wiring.Cat;
import Wiring.Dog;
import Wiring.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WiringConfig {

    //We shall create the beans of Person and Dog
    @Bean
    Dog dog(){
        Dog d = new Dog();
        d.setName("Rex");
        return d;
    }

    @Bean
    Person person(Cat cat){
        Person p = new Person();
        p.setName("Manuel");
        p.setDog(dog());
        p.setCat(cat);
        return p;
    }

    @Bean
    Cat cat(){
        Cat c = new Cat();
        c.setName("Tom");
        return c;
    }
}
