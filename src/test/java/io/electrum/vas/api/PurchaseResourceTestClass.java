package io.electrum.vas.api;

import org.mockito.Mockito;

import io.electrum.airtime.api.PurchaseResource;

public class PurchaseResourceTestClass extends PurchaseResource {
   // use a spied instance so that method calls can be interrogated by Mockito
   static IPurchaseResourceTestImpl interfaceImpl = Mockito.spy(new IPurchaseResourceTestImpl());

   protected IPurchaseResourceTestImpl getResourceImplementation() {
      return interfaceImpl;
   }
}
