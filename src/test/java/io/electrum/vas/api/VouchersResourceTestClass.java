package io.electrum.vas.api;

import org.mockito.Mockito;

import io.electrum.airtime.api.IVouchersResource;
import io.electrum.airtime.api.VouchersResource;

public class VouchersResourceTestClass extends VouchersResource {
   // use a spied instance so that method calls can be interrogated by Mockito
   static IVouchersResourceTestImpl interfaceImpl = Mockito.spy(new IVouchersResourceTestImpl());

   protected IVouchersResource getResourceImplementation() {
      return interfaceImpl;
   }
}
