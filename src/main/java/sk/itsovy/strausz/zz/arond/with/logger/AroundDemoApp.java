package sk.itsovy.strausz.zz.arond.with.logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.strausz.zz.arond.with.logger.service.TrafficFortuneService;

import java.util.logging.Logger;

public class AroundDemoApp {
    private static Logger logger =
            Logger.getLogger(AroundDemoApp.class.getName());
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
               new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);


       logger.info("Calling getFortune");


        logger.info("Fortune:" +fortuneService.getFortune());

        logger.info("Finished");


        context.close();
    }
}
