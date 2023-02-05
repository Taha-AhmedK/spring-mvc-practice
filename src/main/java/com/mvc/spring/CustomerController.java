package com.mvc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.spring.entity.Customer;
import com.mvc.spring.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService service;
	
	
	@GetMapping("/")
	public String findAll(Model model) 
	{
		model.addAttribute("customers", service.findallCustomer());
		return "allCustomers";
	}
	@GetMapping("/add")
	public String addCustomerPage(Model model) {
		model.addAttribute("customer", new Customer() );
		return "addCustomer";
	}
	@PostMapping("/addcustomer")
	public String addCustomer(Customer customer) {
		service.addCustomer(customer);
		return "redirect:/";
		
	}
	@GetMapping("/edit/{id}")
		public String editCustomerPage(Model model,@PathVariable("id") int id) {
		model.addAttribute("customer", service.findCustomerById(id));
		return "editCustomer";
	}
	@PostMapping("/updatecustomer")
		public String editCustomer(Customer customer) {
		service.updateCustomer(customer);
		return "redirect:/";
		
		}
	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/";
	}
	
	
	
	
	
	
	@GetMapping("/test")
	public String test() {
		Customer cs= new Customer();
		cs.setFname("Ramesh");
		cs .setLname("khanna");
		cs.setCompany("GuluGulu");
		service.addCustomer(cs);
		return "";
	}
	
}
