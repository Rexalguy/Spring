package main;

import Config.Config;
import Repository.CommentRepository;
import Service.CommentService;
import Service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);

        CommentService cS = context.getBean(CommentService.class);
        UserService uS = context.getBean(UserService.class);

        Boolean b = cS.getCommentRepository() == uS.getCommentRepository();

        System.out.println(b);
    }



}
