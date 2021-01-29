package sk.itsovy.strausz.declaration.combo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {






    @Pointcut("execution( * sk.itsovy.strausz.declaration.combo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* sk.itsovy.strausz.declaration.combo.dao.*.get*(..))")
    private void getter(){}

    @Pointcut("execution(* sk.itsovy.strausz.declaration.combo.dao.*.set*(..))")
    private void setter(){}


    @Pointcut("forDaoPackage() && !(getter()) || !(setter())")
    private void forDaoPackageNoGetterSetter(){}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){

        System.out.println("\n======>>> Executing @Before advice");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n====>>> Performing API analytics ");
    }
}
