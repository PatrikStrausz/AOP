package sk.itsovy.strausz.reading.joinpoint;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.strausz.reading.joinpoint.dao.AccountDAO;
import sk.itsovy.strausz.reading.joinpoint.dao.MembershipDAO;

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
