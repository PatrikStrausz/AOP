package sk.itsovy.strausz.declaration.combo.dao;

import org.springframework.stereotype.Component;
import sk.itsovy.strausz.declaration.combo.Account;

@Component
public class AccountDAO {


    private String name;

    private String serviceCode;

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
