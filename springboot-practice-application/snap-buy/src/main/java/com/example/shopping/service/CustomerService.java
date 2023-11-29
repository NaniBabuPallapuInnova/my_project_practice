package com.example.shopping.service;

import com.example.shopping.domain.Customer;
import com.example.shopping.domain.Product;
import com.example.shopping.dto.CustomerDTO;
import com.example.shopping.dto.ProductDTO;
import com.example.shopping.mappings.mappingImpl.CustomerMapperImpl;
import com.example.shopping.mappings.mappingImpl.ProductMapperImpl;
import com.example.shopping.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerMapperImpl customerMapper;

    @Autowired
    private ProductMapperImpl productMapper;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> saveAllCustomers(List<Customer> customers){
        return customerRepository.saveAll(customers);
    }

    public Customer findCustomerById(Long id){
        return customerRepository.findById(id).get();
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public List<Customer> findAllCustomersById(List<Long> id){
        return customerRepository.findAllById(id);
    }

    public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }
    public void deleteAllCustomers(){
        customerRepository.deleteAll();
    }

    public CustomerDTO displayCustomersWithProducts(Long id){
        Customer customer = findCustomerById(id);
        Product product = productService.findProductById(id);

        //converting Customer entity into CustomerDTO
        CustomerDTO customerDTO =  customerMapper.toDto(customer);

        //converting Customer entity into CustomerDTO
        ProductDTO productDTO = productMapper.toDto(product);

        // setting the product values(object) into customer values(object) through DTOs
        customerDTO.setProductDTO(productDTO);
        return customerDTO;
    }

}
