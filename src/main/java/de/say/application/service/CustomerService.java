package de.say.application.service;

import de.say.application.port.incoming.CustomerUseCase;
import de.say.application.port.outgoing.CustomerPort;
import de.say.domain.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CustomerService implements CustomerUseCase {

    @Inject
    private CustomerPort customerPort;

    @Override
    public Customer getCustomerOrNull(UUID customerId) {
        return this.customerPort.getCustomerOrNull(customerId);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerPort.getCustomers();
    }

}
