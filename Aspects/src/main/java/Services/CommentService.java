package Services;

import model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    //We shall use a logger instead of System.out
    private final Logger logger = Logger.getLogger(CommentService.class.getName());

    //We use the logger in a publish method
    public String publishComment(Comment comment){
        logger.info("Publishing comment: " + comment.getText());
        return "SUCCESS";
    }

}
