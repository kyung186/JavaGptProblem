package spring.m250413.springboot.mission02.service;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import spring.m250413.springboot.mission02.domain.dto.CustomerRequest;
import spring.m250413.springboot.mission02.domain.dto.CustomerResponse;
import spring.m250413.springboot.mission02.domain.mapper.CustomerMapper;
import spring.m250413.springboot.mission02.exception.CustomerNotFoundException;
import spring.m250413.springboot.mission02.exception.DuplicateEmailException;
import spring.m250413.springboot.mission02.domain.Customer;
import spring.m250413.springboot.mission02.repository.CustomerRepository;

import java.util.List;
import java.util.Map;

@Service
@SessionAttributes
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerResponse register(CustomerRequest request) {
        System.out.println("👉 서비스 진입: " + request.getName());
        Customer customer = customerMapper.toEntity(request);
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new DuplicateEmailException(customer.getEmail());
        }

        Customer saved = customerRepository.save(customer);
        return customerMapper.toDto(saved);
    }

    public CustomerResponse getCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));

        return customerMapper.toDto(customer);
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

//    public boolean existsEmail(String email) {
//        return customerRepository.existsByEmail(email);
//    }
}
