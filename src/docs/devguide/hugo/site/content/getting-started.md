---
title: "Getting Started"
menu:
  main:
    weight: 0
---

The Airtime Service Interface is a RESTful HTTP based messaging protocol, used to connect retailers to airtime voucher vendors, as well as to connect airtime voucher processors to Electrum. Electrum enables merchants to offer a wide range of airtime products to consumers via the Airtime Service Interface. At the same time, the Airtime Service Interface is made available to allow airtime voucher vendors a quick route towards integrating into the Electrum network and accessing participating acquirers.

When starting out a development project using this interface, it is thus important to view this documentation either from the perspective of an acquirer developing a client application to submit requests the Electrum Airtime Service, or of a airtime voucher vendor developing a server application with the view of receiving airtime requests from Electrum.

Throughout the Airtime Service Interface documentation and API the term 'airtime voucher' and 'airtime voucher vendor' may be abbreviated to simply 'voucher' and 'voucher vendor' respectively.

## Supported languages

### Java

The Electrum implementation of the Airtime Service Interface is written in Java. It is highly recommended that if you are planning a Java implementation of the Airtime Service Interface you include the [Airtime Service Interface](https://github.com/electrumpayments/airtime-service-interface) dependency in your project to save you from having to re-implement the interface. You can find instructions in the project [readme](https://github.com/electrumpayments/airtime-service-interface).

### Other languages

The Airtime Service Interface is described as a [swagger (OpenApi) document](/specification/swagger). It is highly recommended that widely available swagger tooling is used to generate a project in your preferred language as a starting point to a new integration project.


## Testing

**TODO:** A test pack will be available soon for testing new server integrations.
