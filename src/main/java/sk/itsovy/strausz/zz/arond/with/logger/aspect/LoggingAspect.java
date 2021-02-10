package sk.itsovy.strausz.zz.arond.with.logger.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.itsovy.strausz.zz.arond.with.logger.Account;
import sk.itsovy.strausz.zz.arond.with.logger.AroundDemoApp;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    private static Logger logger =
            Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* sk.itsovy.strausz.zz.arond.with.logger.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        String method = proceedingJoinPoint.getSignature().toShortString();

        logger.info("\n=====>>>>> Executing @Around method:  "+method);

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;

        logger.info("=====> Duration: " + duration / 1000 + " seconds");
        return result;
    }


    @After("execution(* sk.itsovy.strausz.zz.arond.with.logger.dao.AccountDAO.findAccounts(..))")
    public void afterFinally(JoinPoint joinPoint){

        String method = joinPoint.getSignature().toShortString();

        logger.info("\n=====>>>>> Executing @AfterFinally method:  "+method);

    }


    @AfterThrowing(pointcut="execution(* sk.itsovy.strausz.zz.arond.with.logger.dao.AccountDAO.findAccounts(..))",
            throwing = "e"
    )
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint,Throwable e){
        String method = joinPoint.getSignature().toShortString();

        logger.info("\n=====>>>>> Executing @AfterThrowing method:  "+method);


        logger.info("\n=====>>>>> The exception is:  "+e);


    }

    @AfterReturning(
            pointcut = "execution(* sk.itsovy.strausz.zz.arond.with.logger.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();

        logger.info("\n=====>>>>> Executing @AfterReturning method:  "+method);



        logger.info("\n=====>>>>> Result is :  "+result);
        
        convertToUpperCase(result);

        logger.info("\n=====>>>>> Result is :  "+result);


    }

    private void convertToUpperCase(List<Account> result) {

       for(Account account: result){
           String name = account.getName().toUpperCase();
           String level = account.getLevel().toUpperCase();

           account.setName(name);
           account.setLevel(level);
       }
    }


    @Before("sk.itsovy.strausz.zz.arond.with.logger.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        logger.info("\n======>>> Executing @Before advice");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        logger.info("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object temp : args) {
            logger.info(temp.toString());

            if (temp instanceof Account) {
                Account account = (Account) temp;

                logger.info("account name: " + account.getName());
                logger.info("account level: " + account.getLevel());
            }
        }
    }


}
