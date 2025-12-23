package Wiring;

import config.WiringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        //We link the context window to the Wiring config class
        var context = new AnnotationConfigApplicationContext(WiringConfig.class);

        Person p = context.getBean(Person.class);

        Dog d = context.getBean(Dog.class);

        System.out.println("Person's name: " + p.getName());
        System.out.println("Dog's name: " + d.getName());
        System.out.println("Person's dog: " + p.getDog());
        System.out.println("Person's cat: " + p.getCat());

    }
}
