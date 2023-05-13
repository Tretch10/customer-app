package com.idenu.customer.controller;

import com.idenu.customer.model.Customer;
import com.idenu.customer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping()
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping()
    public void saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable long id) {
        return customerService.findCustomerById(id);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable long id, Customer customer) {
        customer.setId(id);
        customerService.updateCustomer(customer);
    }

}
