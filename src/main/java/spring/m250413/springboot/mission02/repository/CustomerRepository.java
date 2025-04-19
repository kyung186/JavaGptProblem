package spring.m250413.springboot.mission02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.m250413.springboot.mission02.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);

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
