This page describes changes to the Airtime Service Interface implemented across different releases of the interface.

## v4.0.0

Released 21 September 2016

- Aligned Airtime Service Interface with base service interface (v2.0.9).
- Added amounts field (Amounts model) to VoucherRequest and VoucherResponse models.
- Product model changes:
  - Removed amount field.
  - Added type field.
  - Added name field.
- Removed request field from VoucherReversal model thereby making VoucherReversal just a conventional BasicReversal.
- Dropped void endpoint.
- Dropped VoucherVoid model.

## v3.0.0

Released 25 August 2016

- Added tenders to VoucherConfirmations.
- Added reversalReason to VoucherReversals.

## v2.0.3

Released 25 August 2016

- Aligned Airtime Service Interface with base service interface (v2.0.6).

## v2.0.1

Released 23 August 2016

- No spec changes.

## v2.0.0

Released 22 August 2016

- Aligned Airtime Service Interface with base service interface (v2.0.4).

## v1.2.0

Released 15 August 2016

- Updated models to better specify required fields.

## v1.1.0

Released 8 August 2016

- Updated resource paths.
- Added Merchant, Processor and Vendor fields to messages.
- Added DetailMessage model.

## v1.0.0

Released 29 July 2016

Initial release.
