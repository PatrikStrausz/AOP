package sk.itsovy.strausz.zz.around;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.strausz.zz.around.dao.AccountDAO;
import sk.itsovy.strausz.zz.around.service.TrafficFortuneService;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
               new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);


        System.out.println("Calling getFortune");


        System.out.println("Fortune:" +fortuneService.getFortune());

        System.out.println("Finished");


        context.close();
    }
}
