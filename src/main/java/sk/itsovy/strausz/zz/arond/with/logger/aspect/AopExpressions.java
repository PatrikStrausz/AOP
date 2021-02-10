package sk.itsovy.strausz.zz.arond.with.logger.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution( * sk.itsovy.strausz.zz.arond.with.logger.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(* sk.itsovy.strausz.zz.arond.with.logger.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* sk.itsovy.strausz.zz.arond.with.logger.dao.*.set*(..))")
    public void setter() {
    }


    @Pointcut("forDaoPackage() && !(getter()) || !(setter())")
    public void forDaoPackageNoGetterSetter() {
    }
}
