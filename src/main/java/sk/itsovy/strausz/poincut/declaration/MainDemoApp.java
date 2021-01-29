package sk.itsovy.strausz.poincut.declaration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.strausz.poincut.declaration.dao.AccountDAO;
import sk.itsovy.strausz.poincut.declaration.dao.MembershipDAO;

public class MainDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
               new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);


        Account account = new Account();
        accountDAO.addAccount(account, true);

        accountDAO.doWork();

        System.out.println();

        membershipDAO.addMember();

        membershipDAO.goToSleep();


        context.close();
    }
}
