/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customer;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.CustomerRepository;

/**
 *
 * @author flori
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    private CustomerRepository customerRepository;
    
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
     @GetMapping("")
    public List<Customer> index() {
        return customerRepository.findAll();
    }

    
}
