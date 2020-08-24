package io.electrum.vas.api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import javax.ws.rs.ServerErrorException;
import javax.ws.rs.container.AsyncResponse;

import org.mockito.ArgumentCaptor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAirtimeApiInterfaces {

   @Test(description = "Ensures that, when overloaded interface methods are called, each overloaded method calls back to the original method.", dataProvider = "existingBaseImplementationMethodsDatProvider")
   public void ensureInterfaceMethodBackwardsCompatibility(Class<?> interfaceImpl, String methodName) throws Exception {
      TestResourceInterfaces.ensureInterfaceMethodBackwardsCompatibility(interfaceImpl, methodName);
   }

   @DataProvider(name = "existingBaseImplementationMethodsDatProvider")
   public Object[][] existingBaseImplementationMethodsDatProvider() {
      return new Object[][] {
            // the following methods all have implementations which must be used by default when overloading these
            // methods
            //@formatter:off
           {IVouchersResourceTestImpl.class,"confirmVoucherImpl"},
           {IVouchersResourceTestImpl.class,"provisionVoucherImpl"},
           {IVouchersResourceTestImpl.class,"reverseVoucherImpl"},
           {IPurchaseResourceTestImpl.class,"confirmPurchase"},
           {IPurchaseResourceTestImpl.class,"purchasePurchase"},
           {IPurchaseResourceTestImpl.class,"reversePurchase"},
           {IPurchaseResourceTestImpl.class,"getPurchaseStatus"},
           {IMsisdnResourceTestImpl.class,"lookupMsisdn"},
           //@formatter:on
      };
   }

   @Test
   public void ensureTrialPurchaseExists() {
      // Setup
      AsyncResponse asyncResponse = mock(AsyncResponse.class);

      // Test
      new IPurchaseResourceTestImpl().trialPurchase(null, null, null, null, asyncResponse, null, null);

      // Assert
      ArgumentCaptor<Throwable> captor = ArgumentCaptor.forClass(Throwable.class);
      verify(asyncResponse, times(1)).resume(captor.capture());
      Throwable throwable = captor.getValue();
      assertTrue(throwable instanceof ServerErrorException);
      assertEquals(((ServerErrorException) throwable).getResponse().getStatus(), 501);
   }
}