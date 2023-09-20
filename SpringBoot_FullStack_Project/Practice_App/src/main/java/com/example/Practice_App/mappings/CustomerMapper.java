package com.example.Practice_App.mappings;

import com.example.Practice_App.domain.Customer;
import com.example.Practice_App.dto.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDto(Customer customer);

    Customer toEntity(CustomerDTO customerDTO);
}
