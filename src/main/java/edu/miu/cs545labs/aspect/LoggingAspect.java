package edu.miu.cs545labs.aspect;

import edu.miu.cs545labs.domain.Logger;
import edu.miu.cs545labs.repository.LoggerRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    LoggerRepo loggerRepo;

    @Around("@annotation(edu.miu.cs545labs.annotations.ExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object res = joinPoint.proceed();

        long end = System.currentTimeMillis();

        System.out.println("Execution time: " + (end - start) + "ms");

        Logger logger = new Logger();
        logger.setDate(LocalDate.now());
        logger.setOperation(joinPoint.getSignature().getName());
        logger.setTime(LocalTime.now());
        logger.setTimeTaken(String.valueOf(end - start) + "ms");
        loggerRepo.save(logger);

        return res;
    }
}
