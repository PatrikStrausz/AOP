package sk.itsovy.strausz.zz.after.finaly.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addMember(){

        System.out.println(getClass() + ": DOING ADDING A MEMBERSHIP ACCOUNT");

        return false;
    }

    public void goToSleep(){

        System.out.println(getClass() + ": Im going to sleep");

    }
}
