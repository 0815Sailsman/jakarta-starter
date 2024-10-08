package de.say.application.port.outgoing;

import de.say.domain.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerPort {
    Customer getCustomerOrNull(UUID customerId);
    List<Customer> getCustomers();
    void createCustomer(Customer customer);
    void deleteCustomer(UUID customerId);
}
