This page describes changes to the Airtime Service Interface implemented across different releases of the interface.

## v5.15.0

Released 24 August 2020

- Added a new operation, `trialPurchase`, which mimics a conventional `purchase` operation with the following exceptions:
    - No voucher is returned and no product is applied to MSISDN.
    - Has no financial impact.

## v5.14.0

Released 07 August 2020

- Added new fields to the `Product` class:
    - `validityPeriod`: The length of time for which a product is valid. Any unused portion of a product (e.g. unused data) will be forfeit at the end of the validity period).
    - `productContents`: A list defining the contents of the airtime product.

- Added new models:
    - `ProductContent` which describes the content of the airtime product.
    - `ValidityPeriod` which describes the period before an airtime product expires.
    
## v5.13.3

Released 12 May 2020

- Fixed the `FULL_PATH` constants for `Vouchers` resource operations.
    - Note, this change is a breaking change for the Java implementation of the API provided by Electrum.
    - The following constants were corrected to no longer reference the `MSISDN` resource, and now reference the `Voucher` resource:
        - `VouchersResource.ConfirmVoucher.FULL_PATH`
        - `VouchersResource.ProvisionVoucher.FULL_PATH`
        - `VouchersResource.ReverseVoucher.FULL_PATH`

## v5.13.2

Released 28 November 2019

- Ensured Java 8 source compatibility

## v5.13.1 (Deprecated)

Deprecated, replaced with v5.13.2. This version was not Java 8 source compatible.

Released 27 November 2019

- Changed base service interface scope to provided.
- Re-added hibernate-validator dependency

## v5.13.0 (Deprecated)

Deprecated, replaced with v5.13.2. This version is contains incorrect dependencies.

Released 25 November 2019

- Update base service interface version to v3.23.0.
    - Added utility for serialising and deserialising JSON objects from a file.
- The Java implementation of the Airtime Service Interface is now built against OpenJDK 11 (with source compatibility for Java 8).
- Added new `ProductType` enumerations in the `Product` model.
    - `DATA_FIXED`
    - `DATA_VARIABLE`
- Added new boolean field `isDirectTopUp` to `Product`.
- A new optional field, `productType` was added to the `lookupMsisdn` operation.

## v5.12.0

Released 13 March 2019

- Update base service interface version to v3.19.0.
  - Added new models:
      - `Pin` a base PIN model
      - `PinClear` for PINs in the clear
      - `PinEncrypted` for encrypted PIN blocks with the PIN block format, accountNumber and the key index
    - `Pin` was added to `CardPayment`, taking precedence over the existing `encryptedPin` field

## v5.11.0
 - Use v5.0.3 instead, this version contains broken resources.
Released 25 February 2019

- The `Product.name` field now allows all characters with only a length limitation. The maximum length limitation has been increased to 40.

## v5.10.0

Released 14 February 2019

- Corrected repetition of API base path.
  - *Note* This is breaking change to the API but is not treated as such. Previously the API defined paths to operations as `/airtime/v5/airtime/v5/{operation}` when they should have been of the more simple form `/airtime/v5/{operation}`. Changing the API base path in this manner would typically be a breaking change and would be reflected as such by bumping the major version number in the URL from `v5` to `v6`. However, all known projects depending on the Airtime Service Interface are already implemented using the simpler base path of `/airtime/v5/{operation}`. Thus the decision was made to transparently fix the base path repetition bug as a minor version update as this was deemed to be a less disruptive change to all known projects.
- Added new ErrorTypes:
  - `INSUFFICIENT_FUNDS`
  - `INVALID_CARD_NUMBER`
  - `CARD_EXPIRED`
  - `INCORRECT_PIN`
  - `PIN_ATTEMPTS_EXCEEDED`
- Added `RELATIVE_PATH` and `FULL_PATH` variables to the Java implementation of the API.

## v5.9.0

Released 12 October 2018

- Update base service interface version to v3.15.0.
  - Added `PaymentMethod` subtype `CardPayment`
  - Added `PaymentMethod` subtype `An32TokenPayment`
  - Added `dateOfBirth` and `status` field to `Customer` model
  - Added utility for HTTP authentication
  - Added JAVA 8 Times
  - Added `VasMessage` interface such that `Transaction` and `BasicAdvice` implement.
  - Added utility for serialising and deserialing JSON objects
  - Added `EncryptedPin` class
  - Added `CARD_HOLDER_INQUIRY` and `POINTS_INQUIRY` to `TranType`

## v5.8.1

Released 3 August 2018

 - Added `@Valid` annotations to resources and model objects, which allows the object to be recursively validated.

## v5.8.0

Released 27 June 2018

- Added the following fields to the Product definition:
  - wholesalePrice
  - recipientAmount

## v5.7.2

Released 08 June 2018

- Removed @NotNull annotation from GetPurchaseStatus queryParameters
- Added Amounts to PurchaseRequest and PurchaseResponse.
- Added the following RequestTypes to ErrorDetail:
  - LOOKUP_MSISDN_REQUEST
  - PURCHASE_REQUEST
  - PURCHASE_CONFIRMATION
  - PURCHASE_STATUS_REQUEST
  - PURCAHSE_REVERSAL
- Added the following to ErrorDetail:
  - providerErrorMsg
  - providerErrorCode
  - providerRef

## v5.7.1

Released 24 May 2018

- Corrected response object in lookupMsisdn operation from PurchaseResponse to MsisdnInfoResponse.

## v5.7.0

Deprecated, replaced with v5.7.1

Released 21 May 2018

- Added Purchase and MSISDN resources to better describe airtime transactions:
  - MSISDN naturally describes attributes of an MSISDN
  - Purchases support PIN on receipt based airtime vouchers (as per the Vouchers resource)
    - Note: path parameters have been dropped from Purchase resources.
  - Purchases also support PIN-less airtime purchases based on recipient MSISDN.
  - Purchases also support status purchase status checks as an alternative to the typical reversal mechanism.
- Product values can be defined in multiple currencies to facilitate international sales.
  - Note that the purchase itself only takes place in a single currency.
- Voucher resources have been deprecated in favour of Purchase resources.

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
