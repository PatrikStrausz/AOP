package sk.itsovy.strausz.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {


//    @Before("execution(public void sk.itsovy.strausz.aop.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add*())")
//  @Before("execution( * add*(sk.itsovy.strausz.aop.Account,..))")
//  @Before("execution( * add*(..))")
  @Before("execution( * sk.itsovy.strausz.aop.dao.*.*(..))")
    public void beforeAddAccountAdvice(){

        System.out.println("\n======>>> Executing @Before advice");
    }
}
