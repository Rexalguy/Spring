package main;

import Model.Comment;
import Proxies.EmailCommentNotificationProxy;
import Repositories.CommentRepository;
import Repositories.DBCommentRepository;
import Proxies.CommentNotificationProxy;
import Services.CommentService;

public class Main {
    public static void main(String[] args) {
        //We will attempt to create and publish a comment
        //We first create instances of the services we shall use

        CommentRepository commentRepository = new DBCommentRepository();
        CommentNotificationProxy commentNotificationProxy = new EmailCommentNotificationProxy();

        //We create the comment service
        CommentService commentService = new CommentService(commentRepository, commentNotificationProxy);

        //We create the comment
        Comment comment = new Comment();
        comment.setAuthor("Aburek");
        comment.setText("Check error on line 265");

        //We publish the comment
        commentService.publishComment(comment);
    }
}
