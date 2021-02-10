package sk.itsovy.strausz.zz.around.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution( * sk.itsovy.strausz.zz.around.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(* sk.itsovy.strausz.zz.around.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* sk.itsovy.strausz.zz.around.dao.*.set*(..))")
    public void setter() {
    }


    @Pointcut("forDaoPackage() && !(getter()) || !(setter())")
    public void forDaoPackageNoGetterSetter() {
    }
}
