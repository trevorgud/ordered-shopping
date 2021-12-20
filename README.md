# Ordered Shopping
Create an ordered shopping lists for when you buy the same items a lot and know the order in the store

### Getting Started
```shell
# Install tools
sudo apt install mvn openjdk-11-jdk

# Confirm using java 11 and maven 3.6+
mvn -version
```

### Building
```bash
# Download dependencies. Will download to `target/dependency`
mvn dependency:copy-dependencies

# Build
mvn package
```

### Running
```shell
java -cp target/ordered-shopping-1.0-SNAPSHOT.jar:target/dependency/* trevorgud.list.grocery.App
```

### Clean Up
```shell
mvn clean
```
