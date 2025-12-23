package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        //We create an instance of the spring context
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean("parrot3",Parrot.class);
        System.out.println(parrot.name);

        String s = context.getBean(String.class);
        System.out.println(s);

        Integer i = context.getBean(Integer.class);
        System.out.println(i);

        System.out.println("*************");

        //Using the stereotype class
        Eagle e = context.getBean(Eagle.class);
        System.out.println(e);
        System.out.println(e.getName());



    }
}
