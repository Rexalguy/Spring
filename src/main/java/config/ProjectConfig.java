package config;

import main.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot1 (){
        Parrot p = new Parrot();
        p.name = "Kuku";
        return p;
    }

    //By adding the @Bean annotation, we instruct Spring to call this method when at context initialization and add the returned value to the
    //context
    //The method name becomes the bean's name

    @Bean
    Parrot parrot2 (){
        Parrot p = new Parrot();
        p.name = "Miki";
        return p;
    }

    @Bean
    Parrot parrot3 (){
        Parrot p = new Parrot();
        p.name = "Riki";
        return p;
    }

    @Bean
    String hello(){
        return "Hello mate!";
    }



    @Bean
    Integer ten(){
        return 10;
    }

}
