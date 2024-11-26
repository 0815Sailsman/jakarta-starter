# Starter für Jakarta-Projekt | FTSE

Siehe taskfile für allgemeine commands

## Notizen zur Datenbankhandhabung
[Postgres Treiber](https://jdbc.postgresql.org/download/postgresql-42.7.3.jar) liegt in der installations-directory
von wildfly/standalone/deployments/

## Händische Verwendung (for sake of completion, just use intellij integration)

```
mvn package
```

und dann deployen

### Starten von wildfly
~/code/wildfly.../bin/standalone.sh

### Build
mvn clean package

### Deploy
cp ./target/starter.war ~/code/wildfly.../standalone/deployments


### Environemtn
export POSTGRESQL_DATABASE=dvdrentalcustomer
export POSTGRESQL_PASSWORD=root
export POSTGRESQL_USER=ftse
