package io.electrum.vas.api;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAirtimeResourceClasses {

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
         
         {VouchersResourceTestClass.class, "confirmVoucherImpl", IVouchersResourceTestImpl.class, "confirmVoucherImpl"},
         {VouchersResourceTestClass.class, "provisionVoucherImpl", IVouchersResourceTestImpl.class, "provisionVoucherImpl"},
         {VouchersResourceTestClass.class, "reverseVoucherImpl", IVouchersResourceTestImpl.class, "reverseVoucherImpl"},
         //@formatter:on
      };
   }
}
