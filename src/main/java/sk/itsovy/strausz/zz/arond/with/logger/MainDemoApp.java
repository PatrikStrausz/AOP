package sk.itsovy.strausz.zz.arond.with.logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.strausz.zz.arond.with.logger.dao.AccountDAO;
import sk.itsovy.strausz.zz.arond.with.logger.dao.MembershipDAO;

import java.util.logging.Logger;

public class MainDemoApp {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
               new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);


        Account account = new Account();
        account.setName("Madhu");
        account.setLevel("Platinum");
        accountDAO.addAccount(account, true);

        accountDAO.doWork();

        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        System.out.println();

        membershipDAO.addMember();

        System.out.println();

        membershipDAO.goToSleep();


        context.close();
    }
}
