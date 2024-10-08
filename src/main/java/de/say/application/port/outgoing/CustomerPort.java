package de.say.application.port.outgoing;

import de.say.domain.Customer;

import java.util.UUID;

public interface CustomerPort {
    Customer getCustomerOrNull(UUID customerId);
}
