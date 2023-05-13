package com.idenu.customer.service;

import com.idenu.customer.model.Customer;
import com.idenu.customer.repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(long id) {
    return customerRepository.findById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.update(customer);
    }
}
