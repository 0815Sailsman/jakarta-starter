package de.say.adapter.outgoing;

import de.say.application.port.outgoing.CustomerPort;
import de.say.domain.Customer;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@RegisterForReflection
@RequestScoped
public class JPACustomerAdapter implements CustomerPort {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Customer getCustomerOrNull(int id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public List<Customer> getCustomers() {
        return entityManager.createQuery("select c from Customer c", Customer.class).getResultList();
    }

    @Override
    @Transactional
    public void createCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        entityManager.remove(entityManager.find(Customer.class, id));
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        entityManager.merge(customer);
    }
}
