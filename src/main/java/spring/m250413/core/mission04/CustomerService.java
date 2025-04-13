package spring.m250413.core.mission04;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    public void init(){
        System.out.println("Initializing CustomerService");
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("Destroying CustomerService");
    }

    public void register(Customer customer) {
        System.out.println("고객 등록: " + customer.getName());
        customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id);
    }
}
