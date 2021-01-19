package io.electrum.airtime.api;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.validation.Validation;
import javax.validation.Validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.electrum.airtime.api.model.DescriptionAttribute;
import io.electrum.airtime.api.model.ErrorDetail;
import io.electrum.airtime.api.model.Product;
import io.electrum.airtime.api.model.ProductContent;
import io.electrum.airtime.api.model.ValidityPeriod;
import io.electrum.vas.JsonUtil;

public class NewModelTest {

   @Test(description = "Test we can serialise a model to the expected value.", dataProvider = "serialisedObjectDataProvider")
   public void testSerialisedObject(Object objectToSerialise, String expectedValue) throws IOException {
      String serializedValue = JsonUtil.serialize(objectToSerialise);
      Assert.assertEquals(serializedValue, expectedValue);
   }

   @Test(description = "Test we can deserialise a model to the expected value.", dataProvider = "deserialisedObjectDataProvider")
   public void testDeserialisedObject(String stringToDeserialise, Object expectedObject) throws IOException {
      Object deserialisedObject = JsonUtil.deserialize(stringToDeserialise, expectedObject.getClass());
      Assert.assertEquals(deserialisedObject, expectedObject);
   }

   @Test(description = "Test we can deserialise what we serialised and get back to where we started.", dataProvider = "serialiseDeserialiseObjectDataProvider")
   public void testSerialiseDeserialiseObject(Object testObject) throws IOException {
      Assert.assertEquals(JsonUtil.deserialize(JsonUtil.serialize(testObject), testObject.getClass()), testObject);
   }

   @Test(description = "Test we can serialise what we deserialised and get back to where we started.", dataProvider = "deserialiseSerialiseObjectDataProvider")
   public void testDeserialiseSerialiseObject(String testString, Class<?> classOfObject) throws IOException {
      Assert.assertEquals(JsonUtil.serialize(JsonUtil.deserialize(testString, classOfObject)), testString);
   }

   @Test(description = "Test we keep the ordinal value of an enum constant.", dataProvider = "ordinalDataProvider")
   public void testOrdinal(Enum<?> enumeration, int expectedOrdinal) throws IOException {
      Assert.assertEquals(enumeration.ordinal(), expectedOrdinal);
   }

   @Test(description = "Test we are set up to recursively validate sub-fields.", dataProvider = "recursiveValidationOnSubFieldsDataProvider")
   public void testRecursiveValidationOnSubFields(Object objectWithInvalidSubField, Object objectWithValidSubField)
         throws IOException {
      Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
      // should fail because a sub-field should fail validation
      Assert.assertFalse(validator.validate(objectWithInvalidSubField).isEmpty());
      // should pass because sub-fields are valid
      Assert.assertTrue(validator.validate(objectWithValidSubField).isEmpty());
   }

   @DataProvider(name = "serialisedObjectDataProvider")
   public Object[][] serialisedObjectDataProvider() {
      return new Object[][] {
            { new ProductContent().amount(2950L).unit(ProductContent.AirtimeProductUnit.MINUTES),
                  "{\"amount\":2950,\"unit\":\"Minutes\"}" },
            { new ValidityPeriod().duration(30L).durationUnit(ChronoUnit.DAYS),
                  "{\"duration\":30,\"durationUnit\":\"DAYS\"}" },
            { new DescriptionAttribute().name("Description").description("This product is very good."),
                  "{\"name\":\"Description\",\"description\":\"This product is very good.\"}" } };
   }

   @DataProvider(name = "deserialisedObjectDataProvider")
   public Object[][] deserialisedObjectDataProvider() {
      return new Object[][] {
            { "{\"amount\":2950,\"unit\":\"Minutes\"}",
                  new ProductContent().amount(2950L).unit(ProductContent.AirtimeProductUnit.MINUTES) },
            { "{\"duration\":30,\"durationUnit\":\"DAYS\"}",
                  new ValidityPeriod().duration(30L).durationUnit(ChronoUnit.DAYS) },
            { "{\"name\":\"Description\",\"description\":\"This product is very good.\"}",
                  new DescriptionAttribute().name("Description").description("This product is very good.") } };
   }

   @DataProvider(name = "serialiseDeserialiseObjectDataProvider")
   public Iterator<Object[]> serialiseDeserialiseObjectDataProvider() {
      List<Object> objectsToCheck = new ArrayList<>();

      // Add ErrorDetails
      Arrays.stream(ErrorDetail.RequestType.values()).forEach(r -> {
         Arrays.stream(ErrorDetail.ErrorType.values()).forEach(e -> {
            objectsToCheck.add(new ErrorDetail().requestType(r).errorType(e).id(UUID.randomUUID().toString()));
         });
      });

      // Add miscellaneous objects
      objectsToCheck.add(new ProductContent().amount(2950L).unit(ProductContent.AirtimeProductUnit.MINUTES));
      objectsToCheck.add(new ValidityPeriod().duration(30L).durationUnit(ChronoUnit.DAYS));
      objectsToCheck.add(new DescriptionAttribute().name("Description").description("This product is very good."));

      return objectsToCheck.stream().map(o -> new Object[] { o }).iterator();
   }

   @DataProvider(name = "deserialiseSerialiseObjectDataProvider")
   public Object[][] deserialiseSerialiseObjectDataProvider() {
      return new Object[][] { { "{\"amount\":2950,\"unit\":\"Minutes\"}", ProductContent.class },
            { "{\"duration\":30,\"durationUnit\":\"DAYS\"}", ValidityPeriod.class },
            { "{\"name\":\"Description\",\"description\":\"This product is very good.\"}",
                  DescriptionAttribute.class } };
   }

   @DataProvider(name = "ordinalDataProvider")
   public Object[][] ordinalDataProvider() {
      //@formatter:off
      return new Object[][] {
              { ProductContent.AirtimeProductUnit.MINUTES, 4 },
              { ProductContent.AirtimeProductUnit.KB, 0 },
              { ProductContent.AirtimeProductUnit.MB, 1 },
              { ProductContent.AirtimeProductUnit.GB, 2 },
              { ProductContent.AirtimeProductUnit.UNIT, 3 },
              { ErrorDetail.RequestType.VOUCHER_REQUEST, 0 },
              { ErrorDetail.RequestType.VOUCHER_REVERSAL, 1 },
              { ErrorDetail.RequestType.VOUCHER_CONFIRMATION, 2 },
              { ErrorDetail.RequestType.VOUCHER_VOID, 3 },
              { ErrorDetail.RequestType.MSISDN_INFO_REQUEST, 4 },
              { ErrorDetail.RequestType.PURCHASE_REQUEST, 5 },
              { ErrorDetail.RequestType.PURCHASE_CONFIRMATION, 6 },
              { ErrorDetail.RequestType.PURCHASE_STATUS_REQUEST, 7 },
              { ErrorDetail.RequestType.PURCHASE_REVERSAL, 8 },
              { ErrorDetail.RequestType.TRIAL_PURCHASE_REQUEST, 9 },
              { ErrorDetail.RequestType.LIST_PRODUCTS_REQUEST, 10 },
              { Product.ProductType.VOICE_BUNDLE, 8 },
              { ErrorDetail.ErrorType.DUPLICATE_RECORD, 0 },
              { ErrorDetail.ErrorType.FORMAT_ERROR, 1 },
              { ErrorDetail.ErrorType.FUNCTION_NOT_SUPPORTED, 2 },
              { ErrorDetail.ErrorType.GENERAL_ERROR, 3 },
              { ErrorDetail.ErrorType.INVALID_AMOUNT, 4 },
              { ErrorDetail.ErrorType.ROUTING_ERROR, 5 },
              { ErrorDetail.ErrorType.TRANSACTION_NOT_SUPPORTED, 6 },
              { ErrorDetail.ErrorType.UNABLE_TO_LOCATE_RECORD, 7 },
              { ErrorDetail.ErrorType.UPSTREAM_UNAVAILABLE, 8 },
              { ErrorDetail.ErrorType.INVALID_PRODUCT, 9 },
              { ErrorDetail.ErrorType.ACCOUNT_ALREADY_SETTLED, 10 },
              { ErrorDetail.ErrorType.INVALID_MERCHANT, 11 },
              { ErrorDetail.ErrorType.OUT_OF_STOCK, 12 },
              { ErrorDetail.ErrorType.INVALID_AN32_TOKEN, 13 },
              { ErrorDetail.ErrorType.DO_NOT_HONOR, 14 },
              { ErrorDetail.ErrorType.DECLINED_BY_MNO, 15 },
              { ErrorDetail.ErrorType.INVALID_MSISDN, 16 },
              { ErrorDetail.ErrorType.INVALID_LOYALTY_CARD, 17 },
              { ErrorDetail.ErrorType.INSUFFICIENT_FUNDS, 18 },
              { ErrorDetail.ErrorType.INVALID_CARD_NUMBER, 19 },
              { ErrorDetail.ErrorType.CARD_EXPIRED, 20 },
              { ErrorDetail.ErrorType.INCORRECT_PIN, 21 },
              { ErrorDetail.ErrorType.PIN_ATTEMPTS_EXCEEDED, 22 },
              { ErrorDetail.ErrorType.OUTCOME_UNKNOWN, 23 },
              { ErrorDetail.ErrorType.SYSTEM_MALFUNCTION, 24 },
              { ErrorDetail.ErrorType.LIMIT_EXCEEDED, 25 }};
      //@formatter:on
   }

   @DataProvider(name = "recursiveValidationOnSubFieldsDataProvider")
   public Object[][] recursiveValidationOnSubFieldsDataProvider() {
      return new Object[][] {
         //@formatter:off
              // missing unit
            { new ProductContent().amount(2950L),
              new ProductContent().amount(2950L).unit(ProductContent.AirtimeProductUnit.MINUTES) },
              //missing duration and durationUnit
            { new ValidityPeriod(),
              new ValidityPeriod().duration(30L).durationUnit(ChronoUnit.DAYS) },
              //Product with invalid ProductContent (missing unit) - ensure recursive validation on Product.productContents
            { new Product().productId("someid")
                  .productContents(
                           Collections.singletonList(
                                    new ProductContent().amount(2950L))),
              new Product().productId("someid")
                  .productContents(
                        Collections.singletonList(
                              new ProductContent().amount(2950L)
                                 .unit(ProductContent.AirtimeProductUnit.MINUTES))) },
              //Product with invalid ValidityPeriod (missing durationUnit) - ensure recursive validation on Product.validityPeriod
            { new Product().productId("blah").validityPeriod(
                  new ValidityPeriod().duration(30L)),
              new Product().productId("blah").validityPeriod(
                  new ValidityPeriod().duration(30L).durationUnit(ChronoUnit.DAYS)) },
              //DescriptionAttribute with missing fields
              { new DescriptionAttribute(),
                new DescriptionAttribute().name("Description").description("This product is very good.")}
      };
         //@formatter:on
   }

}
