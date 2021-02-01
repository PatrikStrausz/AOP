package sk.itsovy.strausz.zz.after.finaly;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.strausz.zz.after.finaly.dao.AccountDAO;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
               new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accountList = null;

        try{
            boolean tripWire = true;
           accountList =  accountDAO.findAccounts(tripWire);


            System.out.println("\n\nMain Program: AfterThrowingDemoApp");
            System.out.println("----------------------------------------");

            System.out.println(accountList);

            System.out.println();

        }catch (Exception e){
            e.printStackTrace();
        }




        context.close();
    }
}
