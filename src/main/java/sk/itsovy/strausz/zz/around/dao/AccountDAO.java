package sk.itsovy.strausz.zz.around.dao;

import org.springframework.stereotype.Component;
import sk.itsovy.strausz.zz.around.Account;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {


    private String name;

    private String serviceCode;


    public List<Account> findAccounts(boolean tripWire){

        if(tripWire){
            throw new RuntimeException("No soup for you");
        }

        List<Account> accountList = new ArrayList<>();

        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        accountList.add(temp1);
        accountList.add(temp2);
        accountList.add(temp3);

        return accountList;
    }

    public String getName() {
        System.out.println(getClass()+": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": in setName()");

        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+": in getCode()");

        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+": in setCode()");
        this.serviceCode = serviceCode;
    }

    public void addAccount(Account account, boolean vipFlag){

        System.out.println(getClass() + ": ADDING AN ACCOUNT");
    }

    public boolean doWork(){
        System.out.println(getClass() + ": doWork()");
        return false;
    }


}
