package homeworks.homework19_5.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("within(homeworks.homework19_5.service..*)")
    public void serviceLayer() {}

    @Pointcut("within(homeworks.homework19_5.controller..*)")
    public void controllerLayer() {}
}
