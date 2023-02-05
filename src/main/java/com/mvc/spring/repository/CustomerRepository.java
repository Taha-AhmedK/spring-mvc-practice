package com.mvc.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.mvc.spring.entity.Customer;



public interface CustomerRepository extends CrudRepository<Customer,Integer> {

}
 