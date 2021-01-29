package sk.itsovy.strausz.poincut.declaration.dao;

import org.springframework.stereotype.Component;
import sk.itsovy.strausz.poincut.declaration.Account;

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
