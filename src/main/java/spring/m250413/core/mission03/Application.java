package spring.m250413.core.mission03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        CustomerService customerService = context.getBean(CustomerService.class);
        CustomerService customerService2 = context.getBean(CustomerService.class);
        Customer customer = new Customer("홍길동", "hong@example.com");
        Customer customer2 = new Customer("홍길동", "hong@example.com");

        customerService.register(customer);
        customerService2.register(customer2);

        System.out.println(customerService == customerService2);
    }
}
