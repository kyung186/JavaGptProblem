package spring.m250413.springboot.mission02.rest;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@SessionAttributes
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer register(Customer customer) {
        System.out.println("👉 서비스 진입: " + customer.getName());
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer updateCustomer(Long id, Map<String, Object> updated) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new IllegalArgumentException("존재하지 않습니다.");
        }

        customer.setName(updated.get("name").toString());
        return customerRepository.save(customer);
    }

    public boolean existsCustomer(Long id) {
        return customerRepository.existsById(id);
    }

    public void deleteCustomer(Long id) {
        Customer findCustomer = customerRepository.findById(id).orElse(null);
        if (findCustomer == null) {
            throw new IllegalArgumentException("존재하지 않습니다.");
        }

        customerRepository.deleteById(id);
    }
}
