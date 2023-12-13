package com.example.shopping.mappings;

import com.example.shopping.domain.Customer;
import com.example.shopping.dto.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDto(Customer customer);

    Customer toEntity(CustomerDTO customerDTO);
}
