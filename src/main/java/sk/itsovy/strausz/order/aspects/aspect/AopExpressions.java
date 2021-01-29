package sk.itsovy.strausz.order.aspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution( * sk.itsovy.strausz.order.aspects.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(* sk.itsovy.strausz.order.aspects.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* sk.itsovy.strausz.order.aspects.dao.*.set*(..))")
    public void setter() {
    }


    @Pointcut("forDaoPackage() && !(getter()) || !(setter())")
    public void forDaoPackageNoGetterSetter() {
    }
}
