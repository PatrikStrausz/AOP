package sk.itsovy.strausz.reading.joinpoint.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.itsovy.strausz.reading.joinpoint.Account;

@Aspect
@Component
@Order(2)
public class LoggingAspect {




    @Before("sk.itsovy.strausz.reading.joinpoint.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        System.out.println("\n======>>> Executing @Before advice");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: "+methodSignature);

        Object[] args = joinPoint.getArgs();

        for(Object temp : args){
            System.out.println(temp);

            if(temp instanceof Account){
                Account account = (Account) temp;

                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }
    }



}
