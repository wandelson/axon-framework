package com.events;

public class CustomerAddedEvent  extends AbstractEvent {

	private String name;

	public CustomerAddedEvent() {
	}

	public CustomerAddedEvent(Long id, String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
