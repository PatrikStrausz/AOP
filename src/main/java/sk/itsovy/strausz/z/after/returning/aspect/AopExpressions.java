package sk.itsovy.strausz.z.after.returning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution( * sk.itsovy.strausz.z.after.returning.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(* sk.itsovy.strausz.z.after.returning.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* sk.itsovy.strausz.z.after.returning.dao.*.set*(..))")
    public void setter() {
    }


    @Pointcut("forDaoPackage() && !(getter()) || !(setter())")
    public void forDaoPackageNoGetterSetter() {
    }
}
