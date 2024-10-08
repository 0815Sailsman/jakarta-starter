package de.say.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Customer {

    private UUID uuid;
    private String vorname;
    private String nachname;
    private LocalDateTime geburtsdatum;

    public Customer(UUID uuid, String vorname, String nachname, LocalDateTime geburtsdatum) {
        this.uuid = uuid;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
    }

    public Customer(String vorname, String nachname, LocalDateTime geburtsdatum) {
        this(UUID.randomUUID(), vorname, nachname, geburtsdatum);
    }

    public Customer() {
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
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
