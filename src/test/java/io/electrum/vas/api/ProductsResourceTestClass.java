package io.electrum.vas.api;

import io.electrum.airtime.api.IProductsResource;
import io.electrum.airtime.api.ProductsResource;

import org.mockito.Mockito;

public class ProductsResourceTestClass extends ProductsResource {
   // use a spied instance so that method calls can be interrogated by Mockito
   static IProductsResource interfaceImpl = Mockito.spy(new IProductsResourceTestImpl());

   protected IProductsResource getResourceImplementation() {
      return interfaceImpl;
   }
}