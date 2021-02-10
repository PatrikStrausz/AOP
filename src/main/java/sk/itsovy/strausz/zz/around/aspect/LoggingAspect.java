package sk.itsovy.strausz.zz.around.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.itsovy.strausz.zz.around.Account;

import java.util.List;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Around("execution(* sk.itsovy.strausz.zz.around.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        String method = proceedingJoinPoint.getSignature().toShortString();

        System.out.println("\n=====>>>>> Executing @Around method:  "+method);

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("=====> Duration: " + duration / 1000 + " seconds");
        return result;
    }


    @After("execution(* sk.itsovy.strausz.zz.around.dao.AccountDAO.findAccounts(..))")
    public void afterFinally(JoinPoint joinPoint){

        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n=====>>>>> Executing @AfterFinally method:  "+method);

    }


    @AfterThrowing(pointcut="execution(* sk.itsovy.strausz.zz.around.dao.AccountDAO.findAccounts(..))",
            throwing = "e"
    )
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint,Throwable e){
        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n=====>>>>> Executing @AfterThrowing method:  "+method);


        System.out.println("\n=====>>>>> The exception is:  "+e);


    }

    @AfterReturning(
            pointcut = "execution(* sk.itsovy.strausz.zz.around.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n=====>>>>> Executing @AfterReturning method:  "+method);

        System.out.println();

        System.out.println("\n=====>>>>> Result is :  "+result);
        
        convertToUpperCase(result);

        System.out.println("\n=====>>>>> Result is :  "+result);


    }

    private void convertToUpperCase(List<Account> result) {

       for(Account account: result){
           String name = account.getName().toUpperCase();
           String level = account.getLevel().toUpperCase();

           account.setName(name);
           account.setLevel(level);
       }
    }


    @Before("sk.itsovy.strausz.zz.around.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        System.out.println("\n======>>> Executing @Before advice");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object temp : args) {
            System.out.println(temp);

            if (temp instanceof Account) {
                Account account = (Account) temp;

                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }
    }


}
