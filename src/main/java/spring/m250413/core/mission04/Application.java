package spring.m250413.core.mission04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        CustomerService customerService = context.getBean(CustomerService.class);
        customerService.register(new Customer("홍길동", "hong@example.com"));

        context.close();

//        try {
//            Thread.sleep(000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
