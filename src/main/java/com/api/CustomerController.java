package com.api;

import java.util.List;

import javax.xml.ws.Response;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.commands.CreateCustomerCommand;
import com.entities.Customer;
import com.repositories.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CommandGateway commandGateway;
	
	@Autowired
	private CustomerRepository repository;
	
	@RequestMapping("/")
	public String ping() {
		return "ping";
	}

	@RequestMapping(value = "/v1/customers", method = RequestMethod.POST)
	public void post(@RequestBody CreateCustomerCommand command) {
		commandGateway.send(command);		
	}
	
	
	@RequestMapping(value = "/v1/customers", method = RequestMethod.GET)
	public List<Customer> get( ) {
		List<Customer> customers = repository.findAll();
		return customers;
	}
	
}
