package io.electrum.vas.api;

import io.electrum.vas.api.interfaceTestImpl.IMsisdnResourceTestImpl;
import io.electrum.vas.api.interfaceTestImpl.IPurchaseResourceTestImpl;
import io.electrum.vas.api.interfaceTestImpl.IVouchersResourceTestImpl;
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
}