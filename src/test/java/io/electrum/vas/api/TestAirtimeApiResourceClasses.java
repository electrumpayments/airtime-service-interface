package io.electrum.vas.api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.electrum.airtime.api.IPurchaseResource;

public class TestAirtimeApiResourceClasses {

   @Test(description = "Ensure that methods in the resource classes which define operations will ultimately call back to the original interface method.", dataProvider = "resourceInterfaceMethodsDataProvider")
   public void ensureResourceOperationMethodBackwardsCompatibility(
         Class<?> resourceClass,
         String operationMethodName,
         Class<?> interfaceClass,
         String interfaceMethodName)
         throws Exception {
      TestResourceClasses.ensureResourceOperationMethodBackwardsCompatibility(
            resourceClass,
            operationMethodName,
            interfaceClass,
            interfaceMethodName);
   }

   @DataProvider(name = "resourceInterfaceMethodsDataProvider")
   public Object[][] resourceInterfaceMethodsDataProvider() {
      return new Object[][] {
            //@formatter:off
                {MsisdnResourceTestClass.class, "lookupMsisdn", IMsisdnResourceTestImpl.class, "lookupMsisdn"},
                {PurchaseResourceTestClass.class, "confirmPurchase", IPurchaseResourceTestImpl.class, "confirmPurchase"},
                {PurchaseResourceTestClass.class, "purchasePurchase", IPurchaseResourceTestImpl.class, "purchasePurchase"},
                {PurchaseResourceTestClass.class, "reversePurchase", IPurchaseResourceTestImpl.class, "reversePurchase"},
                {PurchaseResourceTestClass.class, "getPurchaseStatus", IPurchaseResourceTestImpl.class, "getPurchaseStatus"},
                {VourcherResourceTestClass.class, "confirmVoucherImpl", IVouchersResourceTestImpl.class, "confirmVoucherImpl"},
                {VourcherResourceTestClass.class, "provisionVoucherImpl", IVouchersResourceTestImpl.class, "confirmVoucherImpl"},
                {VourcherResourceTestClass.class, "reverseVoucherImpl", IVouchersResourceTestImpl.class, "confirmVoucherImpl"},
                //@formatter:on
      };
   }

   /**
    * This test ensures that the {@link io.electrum.airtime.api.PurchaseResource#trialPurchase} operation is not removed
    * from the {@link io.electrum.airtime.api.PurchaseResource} class and that the method appropriately calls the
    * resource implementation.
    */
   @Test
   public void ensureTrialPurchaseExists() {
      // Setup
      PurchaseResourceTestClass purchaseResource = new PurchaseResourceTestClass();
      IPurchaseResource iPurchaseResource = purchaseResource.getResourceImplementation();
      doNothing().when(iPurchaseResource).trialPurchase(any(), any(), any(), any(), any(), any(), any());

      // Test
      purchaseResource.trialPurchase(null, null, null, null, null, null, null);

      // Assert
      verify(iPurchaseResource, times(1)).trialPurchase(any(), any(), any(), any(), any(), any(), any());
   }
}
