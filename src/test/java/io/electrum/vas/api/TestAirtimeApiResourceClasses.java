package io.electrum.vas.api;
import io.electrum.airtime.api.IVouchersResource;
import io.electrum.airtime.api.model.Msisdn;
import io.electrum.vas.api.interfaceTestClass.MsisdnResourceTestClass;
import io.electrum.vas.api.interfaceTestClass.PurchaseResourceTestClass;
import io.electrum.vas.api.interfaceTestClass.VourcherResourceTestClass;
import io.electrum.vas.api.interfaceTestImpl.IMsisdnResourceTestImpl;
import io.electrum.vas.api.interfaceTestImpl.IPurchaseResourceTestImpl;
import io.electrum.vas.api.interfaceTestImpl.IVouchersResourceTestImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
}

