package homeworks.homework19_5.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("homeworks.homework19_5.aop.Pointcuts.serviceLayer()")
    public void enter(JoinPoint jp) {
        log.info("Enter {} args={}", jp.getSignature(), Arrays.toString(jp.getArgs()));
    }

    @AfterReturning(pointcut = "homeworks.homework19_5.aop.Pointcuts.serviceLayer()", returning = "ret")
    public void exit(JoinPoint jp, Object ret) {
        log.info("Exit  {} -> {}", jp.getSignature(), ret);
    }

    @AfterThrowing(pointcut = "homeworks.homework19_5.aop.Pointcuts.serviceLayer()", throwing = "ex")
    public void error(JoinPoint jp, Throwable ex) {
        log.error("Error in {}: {}", jp.getSignature(), ex.getMessage());
    }
}
