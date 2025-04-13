package spring.m250413.core.mission03;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerRepository {

    private final Map<Long, Customer> store = new HashMap<>();
    private Long sequence = 0L;

    public void save(Customer customer) {
        customer.setId(++sequence);
        store.put(customer.getId(), customer);
    }

    public Customer findById(Long id) {
        return store.get(id);
    }
}
