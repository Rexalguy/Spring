package main;

import Config.Config;
import Repository.CommentRepository;
import Service.CommentService;
import Service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);

        //For a singleton scope
        CommentService cS = context.getBean(CommentService.class);
        UserService uS = context.getBean(UserService.class);

        Boolean b = cS.getCommentRepository() == uS.getCommentRepository();

        System.out.println(b);

        //For a prototype scope
        var us1 = context.getBean(UserService.class);
        var us2 = context.getBean(UserService.class);

        Boolean d = us1 == us2;

        System.out.println(d);
    }



}
