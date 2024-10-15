package de.say.application.port.outgoing;

import de.say.domain.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerPort {
    Customer getCustomerOrNull(int id);
    List<Customer> getCustomers();
    void createCustomer(Customer customer);
    void deleteCustomer(int id);
    void updateCustomer(Customer customer);
}
