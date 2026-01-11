package Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order(1)
public class SecurityAspect {
    Logger logger = Logger.getLogger(SecurityAspect.class.getName());

    @Around("@annotation(Log)")
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("Security Aspect: Calling intercepted method");

        Object returnedValue = joinPoint.proceed();

        logger.info("Method executed and returned");

        return returnedValue;
    }
}
