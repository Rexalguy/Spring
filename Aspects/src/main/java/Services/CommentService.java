package Services;

import Aspect.Log;
import Aspect.ToLog;
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


    @ToLog
    public String deleteComment(Comment comment){
        logger.info("Deleting comment: " + comment.getText());
        return null;
    }

    @Log
    public String editComment(Comment comment){
        logger.info("Editing comment: " + comment.getText());
        return "EDITED";
    }
}
