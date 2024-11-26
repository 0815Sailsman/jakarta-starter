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


### Environment for bootable jar
export POSTGRESQL_DATABASE=dvdrentalcustomer  
export POSTGRESQL_PASSWORD=root  
export POSTGRESQL_USER=ftse  

### Run bootable jar with
`java -jar target/starter-bootable.jar`


# Quarkus

On archlinux, I installed [this](https://github.com/graalvm/graalvm-ce-builds/releases/tag/jdk-21.0.2) for GRAALVL_HOME in native exe step.
Also, I installed [graal bin](https://aur.archlinux.org/packages/jdk21-graalvm-bin) from AUR and used it with archlinux-java as my default sdk for the rest of the quarkus steps.
No idea what exactly of these steps is necessary, but I also dont care since it works like this :)

Important: Change package in pom from war to jar or remove entirely

## Entwicklung

```
mvn compile quarkus:dev
```


## Packaging und Start

```
mvn package -Dquarkus.package.jar.type=uber-jar
java -jar target/starter-1.0-runner.jar
```

## Natives Executable

```
export GRAALVM_HOME=/PATH/TO/YOUR/GRAALVM/INSTALLATION
mvn package -Dnative
```

