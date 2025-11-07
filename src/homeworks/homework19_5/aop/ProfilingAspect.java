package homeworks.homework19_5.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ProfilingAspect {

    @Around("homeworks.homework19_5.aop.Pointcuts.serviceLayer()")
    public Object time(ProceedingJoinPoint pjp) throws Throwable {
        long t0 = System.nanoTime();
        try {
            return pjp.proceed();
        } finally {
            long ms = (System.nanoTime() - t0) / 1_000_000;
            log.info("Time {} = {} ms", pjp.getSignature(), ms);
        }
    }
}
