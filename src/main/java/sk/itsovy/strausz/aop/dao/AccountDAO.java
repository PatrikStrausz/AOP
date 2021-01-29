package sk.itsovy.strausz.aop.dao;

import org.springframework.stereotype.Component;
import sk.itsovy.strausz.aop.Account;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean vipFlag){

        System.out.println(getClass() + ": ADDING AN ACCOUNT");
    }

    public boolean doWork(){
        System.out.println(getClass() + ": doWork()");
        return false;
    }


}
