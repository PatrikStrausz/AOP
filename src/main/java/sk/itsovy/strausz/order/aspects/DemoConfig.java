package sk.itsovy.strausz.order.aspects;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("sk.itsovy.strausz.order.aspects")
public class DemoConfig {

}
