package Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class LogAspect {

    Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Around("@annotation(Log)")
    public Object logs (ProceedingJoinPoint joinPoint) throws Throwable{
       logger.info("LogAspect : Calling intercepted method");

       Object returnedValue = joinPoint.proceed();

       logger.info("Method executed and returned" + returnedValue);

       return returnedValue;
    }
}
