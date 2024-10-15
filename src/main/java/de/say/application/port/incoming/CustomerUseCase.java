package de.say.application.port.incoming;

import de.say.domain.Customer;

import java.util.List;


public interface CustomerUseCase {
    Customer getCustomerOrNull(int customerId);
    List<Customer> getCustomers();
    void createCustomer(Customer customer);
    void deleteCustomer(int id);
    void updateCustomer(int id, Customer customer);
}
