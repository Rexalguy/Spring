package Coffes;

import Config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);

        Coffee c1 = context.getBean("coffee",Coffee.class);
        Coffee c2 = context.getBean("coffee",Coffee.class);

        Boolean b = c1 == c2;
        System.out.println(b);
        //This will be true because it is the same object, hence same reference
    }
}
