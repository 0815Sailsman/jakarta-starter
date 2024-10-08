package de.say.adapter.outgoing;

import de.say.application.port.outgoing.CustomerPort;
import de.say.domain.Customer;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.*;

@ApplicationScoped
public class MemoryCustomerAdapter implements CustomerPort {

    private Map<UUID, Customer> customers = new HashMap<>(Map.of(
            UUID.fromString("d63ebd6a-e2e7-494e-b6b0-04bf96206e8a"), new Customer(UUID.fromString("d63ebd6a-e2e7-494e-b6b0-04bf96206e8a"), "john", "doe", LocalDateTime.now())
    ));

    @Override
    public Customer getCustomerOrNull(UUID customerId) {
        return customers.getOrDefault(customerId, null);
    }

    @Override
    public List<Customer> getCustomers() {
        return new ArrayList<Customer>(customers.values());
    }

    @Override
    public void createCustomer(Customer customer) {
        this.customers.put(customer.getUuid(), customer);
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        this.customers.remove(customerId);
    }

}
