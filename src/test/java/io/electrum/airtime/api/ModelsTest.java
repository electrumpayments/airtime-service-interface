package io.electrum.airtime.api;

import io.electrum.airtime.api.model.ErrorDetail;
import io.electrum.airtime.api.model.Msisdn;
import io.electrum.airtime.api.model.MsisdnInfoResponse;
import io.electrum.airtime.api.model.Product;
import io.electrum.airtime.api.model.Promotion;
import io.electrum.airtime.api.model.PurchaseConfirmation;
import io.electrum.airtime.api.model.PurchaseRequest;
import io.electrum.airtime.api.model.PurchaseResponse;
import io.electrum.airtime.api.model.PurchaseReversal;
import io.electrum.airtime.api.model.Voucher;
import io.electrum.airtime.api.model.VoucherConfirmation;
import io.electrum.airtime.api.model.VoucherRequest;
import io.electrum.airtime.api.model.VoucherResponse;
import io.electrum.vas.JsonUtil;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.Set;

public class ModelsTest {

   @BeforeClass
   public void beforeClass() {
   }

   @BeforeMethod
   public void beforeMethod() {
   }

   @Test
   public void errorDetailTest() throws Exception {
      ErrorDetail errorDetail1 =
            JsonUtil.deserialiseJsonObjectFromFile(PayloadFileLocations.ERROR_DETAIL, ErrorDetail.class, true);
      ErrorDetail errorDetail2 = JsonUtil.deserialize(JsonUtil.serialize(errorDetail1), ErrorDetail.class);

      // check that the payload did not change
      Assert.assertEquals(errorDetail1, errorDetail1);
      Assert.assertEquals(errorDetail1, errorDetail2);
      Assert.assertEquals(errorDetail1.hashCode(), errorDetail2.hashCode());
      Assert.assertEquals(errorDetail1.toString(), errorDetail2.toString());
      Assert.assertNotEquals(errorDetail1, new Object());
      Assert.assertEquals(JsonUtil.serialize(errorDetail1), JsonUtil.serialize(errorDetail2));
   }

   @Test
   public void msisdnTest() throws Exception {
      Msisdn msisdn1 = JsonUtil.deserialiseJsonObjectFromFile(PayloadFileLocations.MSISDN, Msisdn.class, true);
      Msisdn msisdn2 = JsonUtil.deserialize(JsonUtil.serialize(msisdn1), Msisdn.class);

      Assert.assertEquals(msisdn1, msisdn2);
      Assert.assertNotEquals(msisdn1, new Object());
      Assert.assertEquals(JsonUtil.serialize(msisdn1), JsonUtil.serialize(msisdn2));
   }

   @Test
   public void msisdnInfoResponseTest() throws Exception {
      MsisdnInfoResponse msisdnInfoResponse1 =
            JsonUtil
                  .deserialiseJsonObjectFromFile(PayloadFileLocations.MSISDN_INFO_RSP, MsisdnInfoResponse.class, true);
      MsisdnInfoResponse msisdnInfoResponse2 =
            JsonUtil.deserialize(JsonUtil.serialize(msisdnInfoResponse1), MsisdnInfoResponse.class);

      Assert.assertEquals(msisdnInfoResponse1, msisdnInfoResponse1);
      Assert.assertEquals(msisdnInfoResponse1, msisdnInfoResponse2);
      Assert.assertEquals(msisdnInfoResponse1.hashCode(), msisdnInfoResponse2.hashCode());
      Assert.assertNotEquals(msisdnInfoResponse1, new Object());
      Assert.assertEquals(msisdnInfoResponse1.toString(), msisdnInfoResponse2.toString());
      Assert.assertEquals(JsonUtil.serialize(msisdnInfoResponse1), JsonUtil.serialize(msisdnInfoResponse2));

      // Check that changing inner array changes MsisdnInfoResponse
      msisdnInfoResponse2.availableProducts(null);

      Assert.assertNotEquals(msisdnInfoResponse1, msisdnInfoResponse2);

   }

   @Test
   public void msisdnInfoResponseTestDifferentAvailProducts() throws Exception {
      MsisdnInfoResponse msisdnInfoResponse1 =
            JsonUtil
                  .deserialiseJsonObjectFromFile(PayloadFileLocations.MSISDN_INFO_RSP, MsisdnInfoResponse.class, true);
      MsisdnInfoResponse msisdnInfoResponse2 =
            JsonUtil.deserialize(JsonUtil.serialize(msisdnInfoResponse1), MsisdnInfoResponse.class);
   }

   @Test
   public void productTest() throws Exception {
      Product productDirect1 =
            JsonUtil.deserialiseJsonObjectFromFile(PayloadFileLocations.PRODUCT_DIRECT, Product.class, true);
      Product productDirect2 = JsonUtil.deserialize(JsonUtil.serialize(productDirect1), Product.class);

      Assert.assertEquals(productDirect1, productDirect2);
      Assert.assertEquals(JsonUtil.serialize(productDirect1), JsonUtil.serialize(productDirect2));

      Product productNotDirect1 =
            JsonUtil.deserialiseJsonObjectFromFile(PayloadFileLocations.PRODUCT_NOT_DIRECT, Product.class, true);
      Product productNotDirect2 = JsonUtil.deserialize(JsonUtil.serialize(productNotDirect1), Product.class);

      Assert.assertEquals(productNotDirect1, productNotDirect2);
      Assert.assertNotEquals(productNotDirect1, new Object());
      Assert.assertEquals(JsonUtil.serialize(productNotDirect1), JsonUtil.serialize(productNotDirect2));
      Assert.assertEquals(productNotDirect1.hashCode(), productNotDirect2.hashCode());
      Assert.assertEquals(productNotDirect1.toString(), productNotDirect2.toString());
   }

   @Test
   public void promotionTest() throws Exception {
      Promotion promotion1 =
            JsonUtil.deserialiseJsonObjectFromFile(PayloadFileLocations.PROMOTION, Promotion.class, true);
      Promotion promotion2 = JsonUtil.deserialize(JsonUtil.serialize(promotion1), Promotion.class);

      Assert.assertEquals(promotion1, promotion2);
      Assert.assertNotEquals(promotion1, new Object());
      Assert.assertEquals(promotion1.toString(), promotion2.toString());
      Assert.assertEquals(JsonUtil.serialize(promotion1), JsonUtil.serialize(promotion2));
   }

   @Test
   public void purchaseRequestTest() throws Exception {
      PurchaseRequest purchaseRequest1 =
            JsonUtil.deserialiseJsonObjectFromFile(PayloadFileLocations.PURCHASE_REQ, PurchaseRequest.class, true);
      PurchaseRequest purchaseRequest2 =
            JsonUtil.deserialize(JsonUtil.serialize(purchaseRequest1), PurchaseRequest.class);

      Assert.assertEquals(purchaseRequest1, purchaseRequest2);
      Assert.assertEquals(purchaseRequest1.toString(), purchaseRequest2.toString());
      Assert.assertEquals(JsonUtil.serialize(purchaseRequest1), JsonUtil.serialize(purchaseRequest2));
   }

   @Test
   public void purchaseResponseTest() throws Exception {
      PurchaseResponse purchaseResponse1 =
            JsonUtil.deserialiseJsonObjectFromFile(PayloadFileLocations.PURCHASE_RSP, PurchaseResponse.class, true);
      PurchaseResponse purchaseResponse2 =
            JsonUtil.deserialize(JsonUtil.serialize(purchaseResponse1), PurchaseResponse.class);

      Assert.assertEquals(purchaseResponse1, purchaseResponse1);
      Assert.assertEquals(purchaseResponse1, purchaseResponse2);
      Assert.assertNotEquals(purchaseResponse1, null);
      Assert.assertEquals(purchaseResponse1.toString(), purchaseResponse2.toString());
      Assert.assertEquals(purchaseResponse1.hashCode(), purchaseResponse2.hashCode());
      Assert.assertEquals(JsonUtil.serialize(purchaseResponse1), JsonUtil.serialize(purchaseResponse2));
   }

   @Test
   public void purchaseConfirmationTest() throws Exception {
      PurchaseConfirmation purchaseConfirmation1 =
            JsonUtil
                  .deserialiseJsonObjectFromFile(PayloadFileLocations.PURCHASE_CONF, PurchaseConfirmation.class, true);
      PurchaseConfirmation purchaseConfirmation2 =
            JsonUtil.deserialize(JsonUtil.serialize(purchaseConfirmation1), PurchaseConfirmation.class);

      Assert.assertEquals(purchaseConfirmation1, purchaseConfirmation2);
      Assert.assertEquals(purchaseConfirmation1.toString(), purchaseConfirmation2.toString());
      Assert.assertEquals(JsonUtil.serialize(purchaseConfirmation1), JsonUtil.serialize(purchaseConfirmation2));
   }

   @Test
   public void purchaseReversalTest() throws Exception {
      PurchaseReversal purchaseReversal1 =
            JsonUtil.deserialiseJsonObjectFromFile(PayloadFileLocations.PURCHASE_REV, PurchaseReversal.class, true);
      PurchaseReversal purchaseReversal2 =
            JsonUtil.deserialize(JsonUtil.serialize(purchaseReversal1), PurchaseReversal.class);

      Assert.assertEquals(purchaseReversal1, purchaseReversal2);
      Assert.assertEquals(purchaseReversal1.toString(), purchaseReversal2.toString());
      Assert.assertEquals(JsonUtil.serialize(purchaseReversal1), JsonUtil.serialize(purchaseReversal2));
   }

   @Test
   public void voucherTest() throws Exception {
      Voucher voucher1 = JsonUtil.deserialiseJsonObjectFromFile(PayloadFileLocations.VOUCHER, Voucher.class, true);
      Voucher voucher2 = JsonUtil.deserialize(JsonUtil.serialize(voucher1), Voucher.class);

      Assert.assertEquals(voucher1, voucher2);
      Assert.assertEquals(JsonUtil.serialize(voucher1), JsonUtil.serialize(voucher2));
   }

   @Test
   public void voucherRequestTest() throws Exception {
      VoucherRequest voucherRequest1 =
            JsonUtil.deserialiseJsonObjectFromFile(PayloadFileLocations.VOUCHER_REQ, VoucherRequest.class, true);
      VoucherRequest voucherRequest2 = JsonUtil.deserialize(JsonUtil.serialize(voucherRequest1), VoucherRequest.class);

      Assert.assertEquals(voucherRequest1, voucherRequest2);
      Assert.assertEquals(voucherRequest1.toString(), voucherRequest2.toString());
      Assert.assertEquals(JsonUtil.serialize(voucherRequest1), JsonUtil.serialize(voucherRequest2));
   }

   @Test
   public void voucherResponseTest() throws Exception {
      VoucherResponse voucherResponse1 =
            JsonUtil.deserialiseJsonObjectFromFile(PayloadFileLocations.VOUCHER_RSP, VoucherResponse.class, true);
      VoucherResponse voucherResponse2 =
            JsonUtil.deserialize(JsonUtil.serialize(voucherResponse1), VoucherResponse.class);

      Assert.assertEquals(voucherResponse1, voucherResponse2);
      Assert.assertEquals(voucherResponse1.toString(), voucherResponse2.toString());
      Assert.assertEquals(JsonUtil.serialize(voucherResponse1), JsonUtil.serialize(voucherResponse2));
   }

   @Test
   public void voucherConfirmationTest() throws Exception {
      VoucherConfirmation voucherConfirmation1 =
            JsonUtil.deserialiseJsonObjectFromFile(PayloadFileLocations.VOUCHER_CONF, VoucherConfirmation.class, true);
      VoucherConfirmation voucherConfirmation2 =
            JsonUtil.deserialize(JsonUtil.serialize(voucherConfirmation1), VoucherConfirmation.class);

      Assert.assertEquals(voucherConfirmation1, voucherConfirmation2);
      Assert.assertEquals(voucherConfirmation1.toString(), voucherConfirmation2.toString());
      Assert.assertEquals(JsonUtil.serialize(voucherConfirmation1), JsonUtil.serialize(voucherConfirmation2));
   }

   @Test
   public void productListTest() throws Exception {
      Product[] products1 =
            JsonUtil.deserialiseJsonObjectFromFile(PayloadFileLocations.PRODUCTS, Product[].class, true);
      Product[] products2 = JsonUtil.deserialize(JsonUtil.serialize(products1), Product[].class);

      Assert.assertEquals(products1, products2);
      Assert.assertEquals(Arrays.toString(products1), Arrays.toString(products2));
      Assert.assertEquals(JsonUtil.serialize(products1), JsonUtil.serialize(products2));

      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      Validator validator = factory.getValidator();
      Set<ConstraintViolation<Object>> violations = validator.validate(products1);
      if (violations != null && !violations.isEmpty()) {
         Assert.fail(violations.toString());
      }
   }
}
