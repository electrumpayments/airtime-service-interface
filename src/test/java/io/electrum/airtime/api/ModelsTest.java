package io.electrum.airtime.api;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.electrum.airtime.api.model.Msisdn;
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
   public void msisdnTest() throws Exception {
      Msisdn msisdn1 = AirtimeTestUtils.deserialiseJsonObjectFromFile(PayloadFileLocations.MSISDN, Msisdn.class);

      Msisdn msisdn2 = JsonUtil.deserialize(JsonUtil.serialize(msisdn1), Msisdn.class);

      // check that the payload did not change
      Assert.assertEquals(msisdn1, msisdn2);
      Assert.assertEquals(JsonUtil.serialize(msisdn1), JsonUtil.serialize(msisdn2));
   }
}
