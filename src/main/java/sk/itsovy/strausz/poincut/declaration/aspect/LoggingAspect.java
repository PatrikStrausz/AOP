package sk.itsovy.strausz.poincut.declaration.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {


//    @Before("execution(public void sk.itsovy.strausz.aop.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add*())")
//  @Before("execution( * add*(sk.itsovy.strausz.aop.Account,..))")
//  @Before("execution( * add*(..))")


    @Pointcut("execution( * sk.itsovy.strausz.poincut.declaration.dao.*.*(..))")
    private void forDaoPackage(){}

  @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){

        System.out.println("\n======>>> Executing @Before advice");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n====>>> Performing API analytics ");
    }
}
