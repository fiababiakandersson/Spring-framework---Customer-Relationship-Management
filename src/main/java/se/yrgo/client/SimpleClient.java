package se.yrgo.client;

import java.util.*;

import org.springframework.context.support.*;

import se.yrgo.domain.*;
import se.yrgo.services.customers.*;

public class SimpleClient {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");

        CustomerManagementService customerService = container.getBean(CustomerManagementService.class);

        customerService.newCustomer(new Customer("BD37", "Name1", "Note1"));

        List<Customer> allCustomers = customerService.getAllCustomers();

        for (Customer customer : allCustomers) {
            System.out.println(customer);
        }

        container.close();
    }
}