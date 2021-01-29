package sk.itsovy.strausz.order.aspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {




    @Before("sk.itsovy.strausz.order.aspects.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n======>>> Executing @Before advice");
    }



}
