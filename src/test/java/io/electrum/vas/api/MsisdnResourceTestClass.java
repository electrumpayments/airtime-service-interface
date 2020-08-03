package io.electrum.vas.api;

import org.mockito.Mockito;

import io.electrum.airtime.api.IMsisdnResource;
import io.electrum.airtime.api.MsisdnResource;

public class MsisdnResourceTestClass extends MsisdnResource {
   // use a spied instance so that method calls can be interrogated by Mockito
   static IMsisdnResourceTestImpl interfaceImpl = Mockito.spy(new IMsisdnResourceTestImpl());

   protected IMsisdnResource getResourceImplementation() {
      return interfaceImpl;
   }
}
