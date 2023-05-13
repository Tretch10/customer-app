package com.idenu.customer.repository;

import com.idenu.customer.model.Customer;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.List;

public interface CustomerRepository extends JdbcOperations {

    void save(Customer customer);
    List<Customer> findAll();
    Customer findById(long id);
    void update(Customer customer);
}
