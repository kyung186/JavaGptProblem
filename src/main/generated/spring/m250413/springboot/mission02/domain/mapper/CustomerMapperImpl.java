package spring.m250413.springboot.mission02.domain.mapper;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import spring.m250413.springboot.mission02.domain.Customer;
import spring.m250413.springboot.mission02.domain.dto.CustomerRequest;
import spring.m250413.springboot.mission02.domain.dto.CustomerResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-19T22:25:43+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.14 (Eclipse Adoptium)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerResponse toDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String email = null;
        LocalDate createdAt = null;

        id = customer.getId();
        name = customer.getName();
        email = customer.getEmail();
        createdAt = customer.getCreatedAt();

        CustomerResponse customerResponse = new CustomerResponse( id, name, email, createdAt );

        return customerResponse;
    }

    @Override
    public Customer toEntity(CustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( request.getName() );
        customer.setEmail( request.getEmail() );

        return customer;
    }
}
