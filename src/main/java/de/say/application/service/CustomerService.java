package de.say.application.service;

import de.say.application.port.incoming.CustomerUseCase;
import de.say.application.port.outgoing.CustomerPort;
import de.say.domain.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CustomerService implements CustomerUseCase {

    @Inject
    private CustomerPort customerPort;

    @Override
    public Customer getCustomerOrNull(int id) {
        return this.customerPort.getCustomerOrNull(id);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerPort.getCustomers();
    }

    @Override
    public void createCustomer(Customer customer) {
        this.customerPort.createCustomer(customer);
    }

    @Override
    @Transactional
    public void updateCustomer(int id, Customer customer) {
        Customer existing = this.customerPort.getCustomerOrNull(id);
        if (existing != null) {
            existing.merge(customer);
        }
    }

    @Override
    public void deleteCustomer(int id) {
        this.customerPort.deleteCustomer(id);
    }

}
