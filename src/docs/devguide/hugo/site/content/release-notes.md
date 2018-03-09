This page describes changes to the Airtime Service Interface implemented across different releases of the interface.

## v5.6.0

Released 9 March 2018

- Added the following new ErrorTypes:
  - INVALID_AN32_TOKEN
  - DO_NOT_HONOR
  - DECLINED_BY_MNO
  - INVALID_MSISDN
  - INVALID_LOYALTY_CARD

## v5.5.1

Released 1 March 2018

- Update base service interface version to v3.8.1.
  - Changed `PaymentMethodType.TOKEN` to `PaymentMethodType.AN_32_TOKEN` 
  - Added `amount` field to `PaymentMethod`

## v5.5.0

Released 21 February 2018

- Update base service interface version to v3.7.0.
  - Added `PaymentMethod` model with subtypes `An32TokenPayment` and `LoyaltyCardPayment`
- Add field `paymentMethods` to `VoucherRequest`

## v5.4.0

Released 8 November 2017

- Update base service interface version to v3.4.0.
  - Added optional `barcode` field to `SlipLine` which represents a barcode on a till slip.

## v5.3.1

Released 9 October 2017

- Update Swagger Jersey 2 JAX-RS version to v1.5.16.
- Remove included SLF4J library.

## v5.3.0

Released 9 August 2017

- Additional annotations for cascading validation.

## v5.2.0

Released 24 July 2017

- Added INVALID_MERCHANT and OUT_OF_STOCK ErrorTypes.

## v5.1.0

Released 5 April 2017

- Aligned with new base service interface version (v3.2.0).
  - Removed restriction on allowed characters from the terminalId property which means it now only has a max and min length restriction of 8.
  - Added an issuerReference property which adds a unique identifier to the customers slip.
  - Added a basketRef property which is used to group multiple transactions which would otherwise be considered independent.

- Breaking changes for provided implementation.
  - Remove incorrect calls to AsyncResponse.resume in resources classes.
  - Updated Airtime Service Interface abstract resource classes. The classes were changed to pass all parameters to the Implementor's custom resource implementation, as opposed to resuming the AsyncResponse from within the resource. The Implementor should now call resume on the AsyncResponse. This allows for more flexibility, proper asynchronicity and allows the user to choose their own threading model.
  - Added Jax RS Core Request to the expected parameters from @Context. This is passed through as above with the rest of the parameters.
  - Changed all advice responses to BasicAdvice from BasicAdviceResponse.

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
