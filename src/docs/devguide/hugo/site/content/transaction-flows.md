---
title: "Transaction Flows"
menu:
  main:
    weight: 20
---

This section depicts some transaction flows. It is not an exhaustive list of all conceivable flows, but does attempt to illustrate typical scenarios.

When developing a client implementation of the Airtime Service Interface, Electrum hosts the airtime service and assumes the role of the server. The implementor is then responsible for initiating the airtime service requests and processing the responses received from Electrum. When developing a server implementation, Electrum assumes the role of the client. The implementor is then responsible for servicing the airtime service requests sent by Electrum and generating appropriate responses.

## Request vs Advice Messages

There are two basic message types defined in the Airtime Service Interface: request and advice type messages. Request messages require a response from an upstream entity before processing can continue. If no response is received then the client cannot determine whether the server successfully received the request and also cannot assume an approved response was sent by the upstream entity. Therefore the client is responsible for ensuring that the request is reversed to ensure that both parties agree on the status of the request.

Reversals are an example of an advice type message. Advice type messages inform the server of an action or instruction but do not require the client to wait for a response from the server. Advice type messages are sent at suitable intervals until a definite response is received from the upstream entity.

In order to maintain system consistency, it is important that all advice messages are queued in persistent storage on the airtime service client implementation and repeated until an acknowledgement of receipt is received from the Airtime Service server implementation. This process is commonly referred to as store-and-forward.

## Voucher Provisioning

When a voucher is purchased the downstream entity requests a voucher be provisioned by the voucher vendor. The downstream entity does this by sending a voucher provision request to the voucher vendor. The voucher vendor then processes the request and returns the voucher provisioned. Note that a voucher provision request is by necessity considered successful only when it contains the voucher provisioned.

The sequence diagram below shows a successful [voucherProvision](/specification/operations/#voucherProvision) operation. The response payload contains information regarding the voucher provisioned.

![A Successful Provision Request](/images/provision_request.png "A Successful Provision Request")

## Reversal Advices

If a downstream entity does not receive a definite response to a voucher provision request (either successful or unsuccessful) then the downstream entity must initiate a voucher reversal message to the upstream entity. This ensures that the voucher vendor is notified that a voucher confirmation or voucher void request will never be received for the provisioned voucher. The voucher vendor can then take appropriate steps to handle the reversed voucher.

By the nature of reversals a downstream entity will not possess the voucher to be reversed. Therefore the voucher will not form part of the reversal message. Instead, the original provision request ID and the original request are both passed in the reversal message. The upstream entity can then use these to determine whether the original request was received and which voucher should be reversed if it was indeed provisioned.

The sequence diagram below shows a [voucherReversal](/specification/operations/#voucherReversal) operation. The response simply acknowledges the receipt of a reversal message.

![An Uncertain Response And A Reversal](/images/provision_reversal.png "An Uncertain Response And A Reversal")

Note that specifically for reversal response messages an HTTP status type of 404 is considered a successful response. The reversal request references the voucher record which was intended to be created when the client submitted the provision request. However, it is possible that the upstream entity never received the original provision request (leading to the timeout which subsequently necessitated this reversal). Thus the server will not be able to locate the voucher (which was never provisioned). The server therefore need not take any action to invalidate the voucher but may return an HTTP status type of 404 implying that the original voucher record could not be located. The Airtime Service Interface considers this to represent a successful reversal operation.

## Voucher Confirmation

A voucher confirmation message is used to indicate to the voucher vendor that a voucher was both received by the downstream entity and passed to the consumer. The voucher vendor can therefore expect the voucher to be redeemed at some point in the future as per the instructions carried as part of the voucher. Note that once a voucher has been confirmed it cannot be cancelled or reversed.

Since a voucher can only be confirmed if it was indeed received in the provision response, the voucher confirmation message will contain the voucher being confirmed. This allows the voucher vendor to directly locate the voucher within its system.

The sequence diagram below shows a [voucherConfirmation](/specification/operations/#voucherConfirmation) operation. The confirmation message sent upstream contains the voucher being confirmed. The response simply acknowledges the receipt of the confirmation message.

![A Confirmation Flow](/images/provision_confirmation.png "A Confirmation Flow")

For voucher confirmations, an HTTP status type of 404 would be considered a failed response as it implies that the voucher could not be located to be confirmed.

## Voucher Voiding

A voucher void message performs the inverse operation of a confirmation. It is used to indicate to the voucher vendor that a voucher was received by the downstream entity but not passed to the consumer. The voucher vendor can therefore expect that the voucher will never be redeemed at some point in the future. Note that once a voucher has been voided it cannot be confirmed or redeemed.

Since a voucher can only be voided if it was indeed received in the provision response, the voucher void message will contain the voucher being voided. This allows the voucher vendor to directly locate the voucher within its system.

The sequence diagram below shows a [voucherVoid](/specification/operations/#voucherVoid) operation. The void message sent upstream contains the voucher being voided. The response simply acknowledges the receipt of the void message.

![A Void Flow](/images/provision_void.png "A Void Flow")

For voucher voids, an HTTP status type of 404 would be considered a failed response as it implies that the voucher could not be located to be voided.
