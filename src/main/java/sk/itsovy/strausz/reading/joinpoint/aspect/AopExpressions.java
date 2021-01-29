package sk.itsovy.strausz.reading.joinpoint.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution( * sk.itsovy.strausz.reading.joinpoint.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(* sk.itsovy.strausz.reading.joinpoint.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* sk.itsovy.strausz.reading.joinpoint.dao.*.set*(..))")
    public void setter() {
    }


    @Pointcut("forDaoPackage() && !(getter()) || !(setter())")
    public void forDaoPackageNoGetterSetter() {
    }
}
