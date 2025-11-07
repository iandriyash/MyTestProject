package homeworks.homework19_5.aop;

import homeworks.homework19_5.dto.CreateUpdateTelevisionRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PriceGuardAspect {

    @Before("@annotation(homeworks.homework19_5.aop.CheckPrice) && args(req,..)")
    public void validate(CreateUpdateTelevisionRequest req) {
        if (req.price() != null && req.price().doubleValue() > 1_000_000) {
            throw new IllegalArgumentException("Price too high");
        }
        if (req.price() != null && req.price().doubleValue() < 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
    }
}
