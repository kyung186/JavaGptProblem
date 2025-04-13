package spring.m250413.core.mission03;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void register(Customer customer) {
        System.out.println("고객 등록: " + customer.getName());
        customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id);
    }
}
