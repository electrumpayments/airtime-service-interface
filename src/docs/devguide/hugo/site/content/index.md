---
title: Airtime Service Interface
type: index
---

[Electrum Payments](http://electrum.io) connects businesses together to transact with each other easily and robustly. This Airtime Service Interface documents the messaging interface used by Electrum to connect acquirers, processors, and providers together for performing airtime transactions.

Mobile network operators (MNOs) offer, as a virtual product sold at merchants, airtime which indicates how much a consumer may make use of the mobile network. Providers allow consumers to purchase such airtime products in the form of either vouchers (redeemable with a PIN) or directly (without a PIN). These products are purchased by consumers in a two step process.

The first step requests an airtime product from the provider. This is then passed to the merchant (in the case of a PIN-based product) or provided to the recipient directly (PIN-less products). The customer then pays the merchant for the airtime product. Alternatively, the transaction may not complete successfully at the merchant. The merchant then informs the provider that they should reverse the airtime sale.

Merchants and providers subsequently perform settlement and reconciliation operations to ensure that funds are transferred for the airtime sales. This settlement and reconciliation process is outside the scope of the Airtime Service Interface.
