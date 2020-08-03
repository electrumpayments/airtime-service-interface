package io.electrum.vas.api;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAirtimeResourceInterfaces {

   @Test(description = "Ensures that, when overloaded methods are called, each overload calls back to the original method.", dataProvider = "existingBaseImplementationMethodsDatProvider")
   public void testMsisdnLookup(Class<?> interfaceImpl, String methodName) throws Exception {
      TestResourceInterfaces.ensureInterfaceMethodBackwardsCompatibility(interfaceImpl, methodName);
   }

   @DataProvider(name = "existingBaseImplementationMethodsDatProvider")
   public Object[][] existingBaseImplementationMethodsDatProvider() {
      return new Object[][] {
            // the following methods all have implementations which must be used by default when overloading these
            // methods
            //@formatter:off
            {IMsisdnResourceTestImpl.class,"lookupMsisdn"},
            
            {IPurchaseResourceTestImpl.class,"confirmPurchase"},
            {IPurchaseResourceTestImpl.class,"purchasePurchase"},
            {IPurchaseResourceTestImpl.class,"reversePurchase"},
            {IPurchaseResourceTestImpl.class,"getPurchaseStatus"},
            
            {IVouchersResourceTestImpl.class,"confirmVoucherImpl"},
            {IVouchersResourceTestImpl.class,"provisionVoucherImpl"},
            {IVouchersResourceTestImpl.class,"reverseVoucherImpl"},
            //@formatter:on
      };

   }
}
