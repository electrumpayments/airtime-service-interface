---
title: "Getting Started"
menu:
  main:
    weight: 0
---

The Airtime Service Interface is an apache licensed RESTful HTTP based messaging protocol, intended to enable interoperability between airtime voucher vendors and retailers.

Using the Airtime Service Interface enables retailers to access an established and growing group of airtime voucher vendors who support the interface. At the same time, the Airtime Service Interface is made available to allow airtime voucher vendors a quick, well defined route towards integrating into retailers.

Throughout the Airtime Service Interface documentation and API the term 'airtime voucher' and 'airtime voucher vendor' may be abbreviated to simply 'voucher' and 'voucher vendor' respectively.

## Supported languages

### Java

The Electrum implementation of the Airtime Service Interface is written in Java. It is highly recommended that if you are planning a Java implementation of the Airtime Service Interface you include the [Airtime Service Interface](https://github.com/electrumpayments/airtime-service-interface) dependency in your project to save you from having to re-implement the interface. You can find instructions in the project [readme](https://github.com/electrumpayments/airtime-service-interface).

### Other languages

The Airtime Service Interface is described as a [swagger (OpenApi) document](/specification/swagger). It is highly recommended that widely available swagger tooling is used to generate a project in your preferred language as a starting point to a new integration project.
