package sk.itsovy.strausz.order.aspects;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.strausz.order.aspects.dao.AccountDAO;
import sk.itsovy.strausz.order.aspects.dao.MembershipDAO;

public class MainDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
               new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);


        Account account = new Account();
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
