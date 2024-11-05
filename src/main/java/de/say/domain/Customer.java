package de.say.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;
    private String first_name;
    private String last_name;

    public Customer(int customer_id, String first_name, String last_name) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Customer(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Customer() {}

    public void merge(Customer customer) {
        this.first_name = customer.getFirst_name();
        this.last_name = customer.getLast_name();
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }


    public void setFirst_name(String vorname) {
        this.first_name = vorname;
    }

    public void setLast_name(String nachname) {
        this.last_name = nachname;
    }
}
