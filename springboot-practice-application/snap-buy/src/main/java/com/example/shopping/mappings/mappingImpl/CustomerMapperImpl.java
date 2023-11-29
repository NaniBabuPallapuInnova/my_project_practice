package com.example.shopping.mappings.mappingImpl;

import com.example.shopping.domain.Customer;
import com.example.shopping.dto.CustomerDTO;
import com.example.shopping.mappings.CustomerMapper;
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
