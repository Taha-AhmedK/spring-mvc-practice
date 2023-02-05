package com.mvc.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.spring.entity.Customer;
import com.mvc.spring.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository  repository;
	
	public List<Customer> findallCustomer(){
		return (List<Customer>)repository.findAll(); 
	}
	
	public Customer findCustomerById(int id) {
		Optional<Customer> result =repository.findById(id);
		if (result.isPresent()) 
		{
			return result.get();
			
		}
		else {
			return new Customer();
		}
		
	}
	public Customer addCustomer (Customer customer) {
		return repository.save(customer);
	}
	
	public Customer updateCustomer (Customer customer) {
		
		Optional <Customer> result = repository.findById(customer.getId());
		Customer existing = result.get();
		existing.setFname(customer.getFname());
		existing.setLname(customer.getLname());
		existing.setCompany(customer.getCompany());
		return repository.save(existing);
	
		 
		 
	}
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	
	
	

}
