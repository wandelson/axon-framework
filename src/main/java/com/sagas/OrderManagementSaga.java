package com.sagas;

import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.StartSaga;

import com.events.CustomerAddedEvent;

public class OrderManagementSaga {



    @StartSaga
    public void handle(CustomerAddedEvent event) {
       
    }


}