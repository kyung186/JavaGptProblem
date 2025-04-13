package spring.m250413.springboot.mission;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepository {

    private final Map<Long, Customer> store = new HashMap<>();
    private Long sequence = 0L;

    public Customer save(Customer customer) {
        customer.setId(++sequence);
        store.put(customer.getId(), customer);
        return customer;
    }

    public Customer findById(Long id) {
        return store.get(id);
    }

    public List<Customer> findAll() {
        return new ArrayList<>(store.values());
    }
}
