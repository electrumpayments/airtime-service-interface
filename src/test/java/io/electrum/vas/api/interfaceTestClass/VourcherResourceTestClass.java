package io.electrum.vas.api.interfaceTestClass;

import io.electrum.airtime.api.IVouchersResource;
import io.electrum.airtime.api.VouchersResource;
import io.electrum.vas.api.interfaceTestImpl.IVouchersResourceTestImpl;
import org.mockito.Mockito;

public class VourcherResourceTestClass extends VouchersResource {
    // use a spied instance so that method calls can be interrogated by Mockito
    static IVouchersResourceTestImpl interfaceImpl = Mockito.spy(new IVouchersResourceTestImpl());

    protected IVouchersResource getResourceImplementation() {
        return interfaceImpl;
    }
}