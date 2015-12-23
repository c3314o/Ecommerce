# Development

## Spring Loaded

Spring Loaded is used for reloading of class file changes while a JVM is running. More information can be found [here](https://github.com/spring-projects/spring-loaded).

### Configuring for IntelliJ

* Download springloaded-\<version\>.jar file.
* Edit your run configurations.

![edit-run-configurations.png](edit-run-configurations.png)

* Set VM options to "-javaagent:\<path\>/springloaded-\<version\>.jar -noverify".

![spring-loaded.png](spring-loaded.png)
