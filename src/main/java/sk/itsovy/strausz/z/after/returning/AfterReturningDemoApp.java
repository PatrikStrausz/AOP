package sk.itsovy.strausz.z.after.returning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.strausz.z.after.returning.dao.AccountDAO;
import sk.itsovy.strausz.z.after.returning.dao.MembershipDAO;

import java.util.*;

public class AfterReturningDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
               new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accountList = accountDAO.findAccounts();


        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println("----------------------------------------");

        System.out.println(accountList);

        System.out.println();


        context.close();
    }
}
