---
title: Airtime Service Interface
type: index
---

[Electrum Payments](http://electrum.io) connects businesses together to transact with each other easily and robustly. This Airtime Service Interface documents the messaging interface used by Electrum to connect acquirers, processors, and voucher vendors together for performing airtime transactions.

Mobile network operators (MNOs) offer, as a virtual product sold at merchants, airtime which indicates how much a consumer may make use of the mobile network. MNOs allow consumers to purchase airtime in the form of vouchers prior to the consumer making use of the MNOs' networks. These vouchers are purchased by consumers in a two step process. The first step requests that a voucher is provisioned by the MNO and passed to the merchant. Once the consumer has paid the merchant for the voucher the merchant passes the voucher to the consumer who may then redeem the voucher as per the MNO's instructions. Alternatively, the merchant may indicate to the MNO that the consumer won't pay for the voucher for some reason and that the MNO should void the voucher so that it cannot be redeemed.

Merchants and MNOs subsequently perform settlement and reconciliation operations to ensure that the MNO is paid by the merchant for the vouchers provisioned. This settlement and reconciliation process is outside the scope of the Airtime Service Interface.

While not a typical implementation, it is conceivable that an entity may purchase airtime from an MNO in bulk and then re-sell portions of that airtime through the provisioning of more vouchers. This entity would behave in a similar manner as an MNO within the scope of the Airtime Service Interface. Hence the term voucher vendor is adopted to refer to any party capable of provisioning a voucher.
