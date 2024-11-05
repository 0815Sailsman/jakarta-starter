package de.say.adapter.outgoing;

import de.say.application.port.outgoing.CustomerPort;
import de.say.domain.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;

import java.time.LocalDateTime;
import java.util.*;

@ApplicationScoped
@Alternative
public class MemoryCustomerAdapter implements CustomerPort {

    private Map<Integer, Customer> customers = new HashMap<>(Map.of(
            0, new Customer(0, "john", "doe")
    ));

    @Override
    public Customer getCustomerOrNull(int id) {
        return customers.getOrDefault(id, null);
    }

    @Override
    public List<Customer> getCustomers() {
        return new ArrayList<Customer>(customers.values());
    }

    @Override
    public void createCustomer(Customer customer) {
        this.customers.put(customer.getCustomer_id(), customer);
    }

    @Override
    public void deleteCustomer(int id) {
        this.customers.remove(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        this.customers.put(customer.getCustomer_id(), customer);
    }

}
