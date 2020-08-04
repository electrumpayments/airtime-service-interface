package io.electrum.vas.api.interfaceTestClass;

import io.electrum.airtime.api.IMsisdnResource;
import io.electrum.airtime.api.MsisdnResource;
import io.electrum.vas.api.interfaceTestImpl.IMsisdnResourceTestImpl;
import org.mockito.Mockito;

public class MsisdnResourceTestClass extends MsisdnResource {
    // use a spied instance so that method calls can be interrogated by Mockito
    static IMsisdnResourceTestImpl interfaceImpl = Mockito.spy(new IMsisdnResourceTestImpl());

    protected IMsisdnResource getResourceImplementation() {
        return interfaceImpl;
    }
}