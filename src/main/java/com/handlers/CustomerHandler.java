package com.handlers;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.commands.CreateCustomerCommand;
import com.entities.Customer;
import com.events.CustomerAddedEvent;
import com.repositories.CustomerRepository;

@Component
public class CustomerHandler {

	@Autowired
	private CustomerRepository repository;

	@CommandHandler
	public void handle(CreateCustomerCommand command) {

		Customer customer = new Customer();
		customer.setName(command.name);

		repository.save(customer);
	}
	

	@EventSourcingHandler
    public void on(CustomerAddedEvent event) {
       
    }
	
	


}
