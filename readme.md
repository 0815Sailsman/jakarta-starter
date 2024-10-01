# Starter für Jakarta-Projekte


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
