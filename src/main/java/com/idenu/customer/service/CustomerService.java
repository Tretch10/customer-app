package com.idenu.customer.service;

import com.idenu.customer.model.Customer;

import java.util.List;

public interface CustomerService {

    void saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer findCustomerById(long id);
    void updateCustomer(Customer customer);
}
