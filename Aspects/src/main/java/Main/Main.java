package Main;

import Config.ProjectConfiguration;
import Services.CommentService;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var service = context.getBean(CommentService.class);

        //We create a comment instance and give it to the publish
        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Aburek");

        String value = service.publishComment(comment);


        logger.info(value);
    }
}
