package Aspect;

import model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    //We shall use AspectJ. Quite unfamiliar syntax but strong
    @Around("@annotation(ToLog)")
    public  Object log (ProceedingJoinPoint joinPoint) throws Throwable{
        //We first get the method name
        String methodName = joinPoint.getSignature().getName();
        //We get the method arguments
        Object [] arguments = joinPoint.getArgs();

        //Then we log these details
        logger.info("Method name: " + methodName + " with arguments: " + Arrays.asList(arguments) + " will execute");

        //We create a new comment and pass that to the intercepted method
        Comment comment = new Comment();
        comment.setText("Some other text");
        Object [] newArguments = {comment};


        Object returnedByMethod = joinPoint.proceed(newArguments);

        logger.info("Method executed and returned: " + returnedByMethod);

        return "FAILED";

    }
}
