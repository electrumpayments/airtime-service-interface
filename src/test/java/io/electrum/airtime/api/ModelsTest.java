package io.electrum.airtime.api;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.electrum.airtime.api.model.ErrorDetail;
import io.electrum.airtime.api.model.Msisdn;
import io.electrum.airtime.api.model.MsisdnInfoResponse;
import io.electrum.airtime.api.model.Product;
import io.electrum.airtime.api.model.Promotion;
import io.electrum.airtime.api.utils.AirtimeTestUtils;
import io.electrum.gateway.GatewayTestListener;
import io.electrum.vas.JsonUtil;

@Listeners(GatewayTestListener.class)
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
            AirtimeTestUtils.deserialiseJsonObjectFromFile(PayloadFileLocations.ERROR_DETAIL, ErrorDetail.class);
      ErrorDetail errorDetail2 = JsonUtil.deserialize(JsonUtil.serialize(errorDetail1), ErrorDetail.class);

      // check that the payload did not change
      Assert.assertEquals(errorDetail1, errorDetail2);
      Assert.assertEquals(JsonUtil.serialize(errorDetail1), JsonUtil.serialize(errorDetail2));
   }

   @Test
   public void msisdnTest() throws Exception {
      Msisdn msisdn1 = AirtimeTestUtils.deserialiseJsonObjectFromFile(PayloadFileLocations.MSISDN, Msisdn.class);
      Msisdn msisdn2 = JsonUtil.deserialize(JsonUtil.serialize(msisdn1), Msisdn.class);

      Assert.assertEquals(msisdn1, msisdn2);
      Assert.assertEquals(JsonUtil.serialize(msisdn1), JsonUtil.serialize(msisdn2));
   }

   @Test
   public void msisdnInfoResponseTest() throws Exception {
      MsisdnInfoResponse msisdnInfoResponse1 =
            AirtimeTestUtils
                  .deserialiseJsonObjectFromFile(PayloadFileLocations.MSISDN_INFO_RSP, MsisdnInfoResponse.class);
      MsisdnInfoResponse msisdnInfoResponse2 =
            JsonUtil.deserialize(JsonUtil.serialize(msisdnInfoResponse1), MsisdnInfoResponse.class);

      Assert.assertEquals(msisdnInfoResponse1, msisdnInfoResponse2);
      Assert.assertEquals(JsonUtil.serialize(msisdnInfoResponse1), JsonUtil.serialize(msisdnInfoResponse2));
   }

   @Test
   public void productTest() throws Exception {
      Product productDirect1 =
            AirtimeTestUtils.deserialiseJsonObjectFromFile(PayloadFileLocations.PRODUCT_DIRECT, Product.class);
      Product productDirect2 = JsonUtil.deserialize(JsonUtil.serialize(productDirect1), Product.class);

      Assert.assertEquals(productDirect1, productDirect2);
      Assert.assertEquals(JsonUtil.serialize(productDirect1), JsonUtil.serialize(productDirect2));

      Product productNotDirect1 =
            AirtimeTestUtils.deserialiseJsonObjectFromFile(PayloadFileLocations.PRODUCT_NOT_DIRECT, Product.class);
      Product productNotDirect2 = JsonUtil.deserialize(JsonUtil.serialize(productNotDirect1), Product.class);

      Assert.assertEquals(productNotDirect1, productNotDirect2);
      Assert.assertEquals(JsonUtil.serialize(productNotDirect1), JsonUtil.serialize(productNotDirect2));
   }

   @Test
   public void promotionTest() throws Exception {
      Promotion promotion1 =
            AirtimeTestUtils.deserialiseJsonObjectFromFile(PayloadFileLocations.PROMOTION, Promotion.class);
      Promotion promotion2 = JsonUtil.deserialize(JsonUtil.serialize(promotion1), Promotion.class);

      Assert.assertEquals(promotion1, promotion2);
      Assert.assertEquals(JsonUtil.serialize(promotion1), JsonUtil.serialize(promotion2));
   }

}
