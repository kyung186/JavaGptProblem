package spring.m250413.springboot.mission02.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.m250413.springboot.mission02.domain.Customer;
import spring.m250413.springboot.mission02.domain.dto.CustomerRequest;
import spring.m250413.springboot.mission02.domain.dto.CustomerResponse;
import spring.m250413.springboot.mission02.service.CustomerService;

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
    public ResponseEntity<CustomerResponse> register(@RequestBody @Valid CustomerRequest request) {
        System.out.println("💡 요청 도착: " + request);
        CustomerResponse response = customerService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("id") Long id) {
        System.out.println("✅ 컨트롤러 진입"); // 가장 첫 줄
        CustomerResponse response = customerService.getCustomer(id);
        return ResponseEntity.ok(response);
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

//    @GetMapping("/email-check")
//    public boolean emailCheck(@RequestParam("email") String email) {
//        if (customerService.existsEmail(email)) {
//            throw new IllegalArgumentException("이메일이 중복되었습니다.");
//        }
//        System.out.println("사용 가능한 이메일입니다.");
//        return true;
//    }

//    @GetMapping("/email-check")
//    public ResponseEntity<String> emailCheck(@RequestParam("email") String email) {
//        if (customerService.existsEmail(email)) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("이메일이 중복되었습니다.");
//        }
//        return ResponseEntity.ok("사용 가능한 이메일입니다.");
//    }
}
