---
title: "Protocol Basics"
menu:
  main:
    weight: 10
---

The Airtime Service Interface is an HTTP based protocol. A detailed description of the supported operations and definitions can be found in the [Specification](/specification/introduction) section.

## Terminology

Throughout the Airtime Service Interface documentation various terms are used to describe the different entities which send or receive various requests. These terms are described in more detail in this section.

### Upstream And Downstream Entities

Upstream and downstream impart a convention for the direction for a request and its response. A request message (such as a voucher request) typically originates at a merchant location and must be sent to the voucher vendor for provisioning. When a message is sent from a merchant to a voucher vendor it is said to be sent upstream. Conversely, when a message is sent from a voucher vendor to a merchant it is said to be sent downstream. Thus, 'upstream entity' is a relative term and is any entity located between the entity under discussion and the voucher vendor (including the voucher vendor itself). Likewise, 'downstream entity' is also a relative term and is any entity located between the entity under discussion and the merchant (including the merchant itself).

### Server vs Client

Server's typically host an application and, in the context of the RESTful Airtime Service Interface, a server would host the airtime service application responsible for servicing requests received from downstream entities and providing a response. A server is the entity which receives requests and returns responses. A client therefore is the entity responsible for sending requests to a server and expects responses from the server.

The various request and response messages defined in the Airtime Service Interface are always initiated from the downstream entities and sent to upstream entities for processing. This means that clients are therefore downstream of servers and that servers are upstream of clients. Consider an entity which receives a request from a downstream entity and forwards it to an upstream entity; this entity receives the request in the capacity as a server and passes it on in the capacity of a client.

### Sender vs Receiver

The Airtime Service Interface uses both client/server and sender/receiver terminology interchangeably. Whilst client/server terminology describes entity roles at a network level, sender/receiver terminology is a more general description hence this is used in the definition of Airtime Service Interface messages. A sender sends messages and receives responses. Receivers receive messages and send responses.

Clients are free to populate the Sender field of a request message with whatever data they deem appropriate within the requirements of this specification. Likewise, servers are free to populate the Receiver field of a response message as they choose within the requirements of this specification. These fields need not be forwarded unaltered but may be updated by each entity processing the message. However, it is important to note that the Merchant and Vendor sub-fields should describe the ultimate sender (merchant) and receiver (vendor) of the request respectively.

## Security

All communication shall be secured by establishing an SSL encrypted transport. SSL provides a manner for client and server systems to identify themselves to each other as well as to establish an encrypted channel over which they may securely communicate.

SSL provides security at a network level and identifies entities who communicate directly to each other. However processors and other intermediaries are often present between the acquirer of a voucher transaction and the voucher vendor (or any two entities). Therefore an upstream entity may not have clarity on exactly which downstream entity is responsible for the request.

To clearly identify the sender of a request to the receiver of a request HTTP Basic Authentication headers are used. Thus a message sender may be identified at the application level without the necessity of inspecting a lower level protocol.


## Failures

The failure outcome of a request shall be determined in the first instance by examining the HTTP status code of the response. The HTTP status types and their associated meanings convey information about the possible reasons for a failure response. Where possible, a failure response will also contain further information about the nature of the failure in an [ErrorDetail](specification/definitions/#errordetail) object.

### Status type

Three basic types of outcomes are possible for transactions, namely: _successful_, _unknown_, and _failed_. HTTP status types are mapped to one of the possible outcomes as indicated below.

HTTP Status Codes              | Status type
-------------------------------|---------------------------------------------------------------------------------------------
200, 201, 202, 404             | successful
500, 504, timeout              | unknown
400, 404, 501, 503, all others | failed

A timeout occurs when the client has not received a response to a request after an agreed upon interval. Unless otherwise agreed, this interval shall be 60 seconds. Any response received after the timeout should be logged but ignored.

Note that an HTTP status type of 404 could indicate either a success or a failure; this is dependent on the context of the response. This is covered in more detail in the section on [Transaction Flows](/transaction-flows/)

### ErrorDetail

In addition to the HTTP status code, failure response bodies shall contain an [ErrorDetail](/specification/definitions/#errordetail) object if possible to describe the failure in more detail. It should be noted though that responses in some scenarios which are not successful may contain an empty response body and therefore no ErrorDetail object will be present.
