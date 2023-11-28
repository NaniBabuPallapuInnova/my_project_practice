package com.example.Practice_App.mappings.mappingImpl;

import com.example.Practice_App.domain.Customer;
import com.example.Practice_App.dto.CustomerDTO;
import com.example.Practice_App.mappings.CustomerMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public CustomerDTO toDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setCity(customer.getCity());
        customerDTO.setState(customer.getState());
        return customerDTO;
    }

    @Override
    public Customer toEntity(CustomerDTO customerDTO) {
        if (customerDTO == null){
            return null;
        }
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setCity(customer.getCity());
        customer.setState(customer.getState());
        return customer;
    }
}
