package main;

import Config.ProjectConfig;
import Model.Comment;
import Services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class newMain {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Comment comment = new Comment();
        comment.setAuthor("Manuel");
        comment.setText("Make code cleaner");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
