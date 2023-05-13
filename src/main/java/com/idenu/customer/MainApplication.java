package com.idenu.customer;

import com.idenu.customer.controller.CustomerController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        //Get customer controller from application context
        CustomerController customerController = context.getBean(CustomerController.class);
        ((ClassPathXmlApplicationContext) context).close();

    }
}
