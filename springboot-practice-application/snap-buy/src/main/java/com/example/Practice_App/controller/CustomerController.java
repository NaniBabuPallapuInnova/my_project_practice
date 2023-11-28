package com.example.Practice_App.controller;

import com.example.Practice_App.domain.Customer;
import com.example.Practice_App.dto.CustomerDTO;
import com.example.Practice_App.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;



    @PostMapping("/add-customer")
    public @ResponseBody String saveCustomerType1(@RequestParam(name = "name", defaultValue = "Divya")String name, @RequestParam(name = "salary") double salary, @RequestParam String city,@RequestParam String state, @RequestParam String Phone){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCity(city);
        customer.setState(state);
        customer.setPhone(Phone);
        customerService.saveCustomer(customer);
        return "SAVED";
    }

    @PostMapping("/add-customer-type2")
    public HttpStatus saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return HttpStatus.ACCEPTED;
    }

    @PostMapping("/save-all-customers")
    public List<Customer> saveAllCustomers(@RequestBody List<Customer> customerList){
        List<Customer> Customers = customerService.saveAllCustomers(customerList);
        return Customers;
    }

    @GetMapping("/display_customers")
    public List<Customer> displayAllCustomers(){
        return customerService.findAllCustomers();
    }

    @GetMapping("/customer-by-id/{id}")
    public Customer displayCustomerById(@PathVariable("id")Long id){
        return customerService.findCustomerById(id);
    }

    @PostMapping("/update-Customer/{id}")
    public Customer updateCustomerById(@PathVariable Long id){
        Customer customer = customerService.findCustomerById(id);
        customer.setName("Nani");
        customer.setCity("Hyderabad");
        customer.setState("Telangana");
        customer.setPhone("9392590089");
        return customer;
    }

    @PostMapping("/update-customer-body/{id}")
    public Customer updateCustomerByCustomerId(@RequestBody Customer customer, @PathVariable("id") Long id){
        Customer customerObject = customerService.findCustomerById(id);

        /*

        customer.setName(Customer.getName());
        customer.setSalary(Customer.getSalary());
        customer.setCompanyName(Customer.getCompanyName());
        customerService.saveCustomer(Customer1);

        */

        customer.setId(customerObject.getId());
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/delete-customer/{id}")
    public void deleteCustomerById(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }

    @DeleteMapping("/delete-all-customers")
    public void deleteAllCustomers(){
        customerService.deleteAllCustomers();
    }

    /**
     *
     * @param id based on this id, customers are displayed along with product.
     */
    @GetMapping("/get-customer-product/{id}")
    public CustomerDTO displayCustomerWithProducts(@PathVariable Long id){
       CustomerDTO customerDTO =  customerService.displayCustomersWithProducts(id);
        return customerDTO;
    }

}
