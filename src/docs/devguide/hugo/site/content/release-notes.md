This page describes changes to the Airtime Service Interface implemented across different releases of the interface.

## v5.1.0

Released xx March 2017

- Remove incorrect calls to AsyncResponse.resume in resources classes.
- Updated Giftcard Service Interface abstract resource classes. The classes were changed to pass all parameters to the User's custom resource implementation, as opposed to resuming the AsyncResponse from within the resource. The User should now call resume on the AsyncResponse. This allows for more flexibility, proper asynchronicity and allows the user to choose their own threading model.
- Added Jax RS Core Request to the expected parameters from @Context. This is passed through as above with the rest of the parameters.

## v5.0.3

Released 15 November 2016

- Prior releases of the Airtime Service Interface (v5.0.0 and upwards) contained the incorrect version ('v4') in the resources URLs. This has been corrected to 'v5'.

## v5.0.2 (Deprecated)

  Released 03 November 2016 - Use v5.0.3 instead, this version contains broken resources.

  - Added optional tender list to VoucherRequest.
  - Aligned with new base service interface version (v3.1.0).
    - `GIFT_CARD` and `LOYALTY_CARD` tender types added.

## v5.0.1 (Deprecated)

Released 28 October 2016 - Use v5.0.3 instead, this version contains broken resources.

- Corrected the ErrorDetail response to be the correct type in VouchersResource.
- Fixed confirmation and reversal resources so that they return BasicAdviceResponse.
- Fixed Voucher model's toString, equals and hashCode method.
- Renamed Voucher model's time() builder method to be expiryDate() as expected.

## v5.0.0 (Deprecated)

Released 21 October 2016 - Use v5.0.3 instead, this version contains broken resources.

- Aligned Airtime Service Interface with base service interface (v2.0.11).
- Fixed some more typos in Amounts accessor
- ErrorDetail model changes:
  - Added id field.
  - Added optional originalId field.
  - Added RequestType enum field.
- Altered all UUID object references to be Strings instead to align with base service interface spec.

## v4.0.1

Released 19 October 2016

- Aligned Airtime Service Interface with base service interface (v2.0.10).
- Fixed some typos in Amounts accessor

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
