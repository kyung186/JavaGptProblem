package spring.m250413.springboot.mission02.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.m250413.springboot.mission01.rest.CustomerRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer register(@RequestBody Customer customer) {
        System.out.println("💡 요청 도착: " + customer);
        return customerService.register(customer);
    }

   @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {
        System.out.println("✅ 컨트롤러 진입"); // 가장 첫 줄
        try {
            Customer customer = customerService.getCustomer(id);
            if (customer == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(customer);
        } catch (Exception e) {
            System.out.println("❌ 예외 발생: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    @GetMapping("/{id}")
//    public Customer getCustomer(@PathVariable Long id) {
//        return customerService.getCustomer(id);
//    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        System.out.println("💡 요청 도착");
        return customerService.getAllCustomers();
    }

    @PatchMapping("/{id}")
    public Customer updateCustomer(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates) {
        System.out.println("💡 update 요청 도착");
        return customerService.updateCustomer(id, updates);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        if (!customerService.existsCustomer(id)) {
            throw new IllegalArgumentException("존재하지 않습니다.");
        }
        customerService.deleteCustomer(id);
        System.out.println("삭제가 완료되었습니다.");
    }
}
