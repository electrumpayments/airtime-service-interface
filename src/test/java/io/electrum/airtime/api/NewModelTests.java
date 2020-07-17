package io.electrum.airtime.api;

import java.io.IOException;
import java.time.temporal.ChronoUnit;

import javax.validation.Validation;
import javax.validation.Validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.electrum.airtime.api.model.ProductContent;
import io.electrum.airtime.api.model.ValidityPeriod;
import io.electrum.vas.JsonUtil;

public class NewModelTests {

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
                  "{\"duration\":30,\"durationUnit\":\"DAYS\"}" } };
   }

   @DataProvider(name = "deserialisedObjectDataProvider")
   public Object[][] deserialisedObjectDataProvider() {
      return new Object[][] {
            { "{\"amount\":2950,\"unit\":\"Minutes\"}",
                  new ProductContent().amount(2950L).unit(ProductContent.AirtimeProductUnit.MINUTES) },
            { "{\"duration\":30,\"durationUnit\":\"DAYS\"}",
                  new ValidityPeriod().duration(30L).durationUnit(ChronoUnit.DAYS) } };
   }

   @DataProvider(name = "serialiseDeserialiseObjectDataProvider")
   public Object[][] serialiseDeserialiseObjectDataProvider() {
      return new Object[][] { { new ProductContent().amount(2950L).unit(ProductContent.AirtimeProductUnit.MINUTES) },
            { new ValidityPeriod().duration(30L).durationUnit(ChronoUnit.DAYS) } };
   }

   @DataProvider(name = "deserialiseSerialiseObjectDataProvider")
   public Object[][] deserialiseSerialiseObjectDataProvider() {
      return new Object[][] { { "{\"amount\":2950,\"unit\":\"Minutes\"}", ProductContent.class },
            { "{\"duration\":30,\"durationUnit\":\"DAYS\"}", ValidityPeriod.class } };
   }

   @DataProvider(name = "ordinalDataProvider")
   public Object[][] ordinalDataProvider() {
      return new Object[][] {

      };
   }

   @DataProvider(name = "recursiveValidationOnSubFieldsDataProvider")
   public Object[][] recursiveValidationOnSubFieldsDataProvider() {
      return new Object[][] {

      };
   }

}
