package sk.itsovy.strausz.z.after.returning.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.itsovy.strausz.z.after.returning.Account;

import java.util.*;

@Aspect
@Component
@Order(2)
public class LoggingAspect {


    @AfterReturning(
            pointcut = "execution(* sk.itsovy.strausz.z.after.returning.dao.AccountDAO.findAccounts(..))",
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


    @Before("sk.itsovy.strausz.z.after.returning.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
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
