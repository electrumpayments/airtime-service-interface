# Airtime Service Interface

The Airtime Service Interface documents the messaging interface used by Electrum to connect acquirers, processors, and mobile network operators together for performing airtime sales.

You can find documentation for this project [here](https://electrumpayments.github.io/airtime-service-interface-docs/).

## Java projects

To include the service interface into your maven project, include the below dependency.

```xml
<dependency>
    <groupId>io.electrum</groupId>
    <artifactId>airtime-service-interface</artifactId>
    <version>5.14.0</version>
</dependency>
<dependency>
      <groupId>io.electrum</groupId>
      <artifactId>service-interface-base</artifactId>
      <version>3.24.0</version>
</dependency>
```

Alternatively, you can download the jars from Bintray:
- [airtime-service-interface](https://bintray.com/electrumpayments/java-open-source/airtime-service-interface)
- [service-interface-base](https://bintray.com/electrumpayments/java-open-source/service-interface-base)

## Other languages

The interface is also available as a swagger (OpenApi) definition, which can be used to generate starter projects in many languages. See more info [here](https://electrumpayments.github.io/airtime-service-interface-docs/specification/swagger).
