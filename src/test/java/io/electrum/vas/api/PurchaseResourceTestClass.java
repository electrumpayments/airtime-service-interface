package io.electrum.vas.api;

import io.electrum.airtime.api.IPurchaseResource;
import io.electrum.airtime.api.PurchaseResource;
import org.mockito.Mockito;

public class PurchaseResourceTestClass extends PurchaseResource {
    // use a spied instance so that method calls can be interrogated by Mockito
    static IPurchaseResourceTestImpl interfaceImpl = Mockito.spy(new IPurchaseResourceTestImpl());

    protected IPurchaseResource getResourceImplementation() {
        return interfaceImpl;
    }
}