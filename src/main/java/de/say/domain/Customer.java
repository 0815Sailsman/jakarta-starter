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
    private int id;
    private String vorname;
    private String nachname;
    private LocalDateTime geburtsdatum;

    public Customer(int id, String vorname, String nachname, LocalDateTime geburtsdatum) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
    }

    public Customer(String vorname, String nachname, LocalDateTime geburtsdatum) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
    }

    public Customer() {}

    public void merge(Customer customer) {
        this.vorname = customer.getVorname();
        this.nachname = customer.getNachname();
        this.geburtsdatum = customer.getGeburtsdatum();
    }

    public int getId() {
        return id;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public LocalDateTime getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setGeburtsdatum(LocalDateTime geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }
}
