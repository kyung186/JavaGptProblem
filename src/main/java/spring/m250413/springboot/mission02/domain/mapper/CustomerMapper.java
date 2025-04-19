package spring.m250413.springboot.mission02.domain.mapper;

import org.mapstruct.Mapper;
import spring.m250413.springboot.mission02.domain.Customer;
import spring.m250413.springboot.mission02.domain.dto.CustomerRequest;
import spring.m250413.springboot.mission02.domain.dto.CustomerResponse;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponse toDto(Customer customer);
    Customer toEntity(CustomerRequest request);
}
