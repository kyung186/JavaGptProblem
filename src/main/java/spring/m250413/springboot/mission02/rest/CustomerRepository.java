package spring.m250413.springboot.mission02.rest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    private final Map<Long, Customer> store = new HashMap<>();
//    private Long sequence = 0L;
//
//    public Customer save(Customer customer) {
//        System.out.println(customer);
//        customer.setId(++sequence);
//        store.put(customer.getId(), customer);
//        System.out.println(store.toString());
//        return customer;
//    }
//
//    public Customer findById(Long id) {
//        return store.get(id);
//    }
//
//    public List<Customer> findAll() {
//        return new ArrayList<>(store.values());
//    }
}
