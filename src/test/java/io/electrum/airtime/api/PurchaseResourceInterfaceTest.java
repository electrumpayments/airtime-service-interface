package io.electrum.airtime.api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.electrum.airtime.api.model.PurchaseConfirmation;
import io.electrum.airtime.api.model.PurchaseRequest;
import io.electrum.airtime.api.model.PurchaseReversal;

public class PurchaseResourceInterfaceTest {

   private PurchaseResource underTest;
   private IPurchaseResource interfaceTest;

   @BeforeMethod
   public void setup() {
      underTest = Mockito.mock(PurchaseResource.class);
      interfaceTest = new PurchaseResourceImplementation();
      when(underTest.getResourceImplementation()).thenReturn(interfaceTest);
   }

   @Test
   public void testExecute() {
      underTest.confirmPurchase(
            mock(PurchaseConfirmation.class),
            mock(SecurityContext.class),
            mock(Request.class),
            Mockito.<AsyncResponse> mock(AsyncResponse.class),
            Mockito.<HttpHeaders> mock(HttpHeaders.class),
            mock(UriInfo.class),
            mock(HttpServletRequest.class));

      underTest.purchase(
            mock(PurchaseRequest.class),
            mock(SecurityContext.class),
            mock(Request.class),
            mock(AsyncResponse.class),
            mock(HttpHeaders.class),
            mock(UriInfo.class),
            mock(HttpServletRequest.class));

      underTest.reversePurchase(
            mock(PurchaseReversal.class),
            mock(SecurityContext.class),
            mock(Request.class),
            mock(AsyncResponse.class),
            mock(HttpHeaders.class),
            mock(UriInfo.class),
            mock(HttpServletRequest.class));

      underTest.getPurchaseStatus(
            "provider",
            "purchaseReference",
            "originalMsgId",
            mock(SecurityContext.class),
            mock(Request.class),
            mock(AsyncResponse.class),
            mock(HttpHeaders.class),
            mock(UriInfo.class),
            mock(HttpServletRequest.class));

      underTest.retryPurchase(
            mock(PurchaseRequest.class),
            mock(SecurityContext.class),
            mock(Request.class),
            mock(AsyncResponse.class),
            mock(HttpHeaders.class),
            mock(UriInfo.class),
            mock(HttpServletRequest.class));

      // If you are tempted to remove one of these method calls then you may have overloaded a
      // method without deprecating the old one.
   }

   private class PurchaseResourceImplementation implements IPurchaseResource {
      @Override
      public void confirmPurchase(
            PurchaseConfirmation body,
            SecurityContext securityContext,
            Request request,
            HttpHeaders httpHeaders,
            AsyncResponse asyncResponse,
            UriInfo uriInfo,
            HttpServletRequest httpServletRequest) {
         // do nothing
      }

      @Override
      public void purchasePurchase(
            PurchaseRequest body,
            SecurityContext securityContext,
            Request request,
            HttpHeaders httpHeaders,
            AsyncResponse asyncResponse,
            UriInfo uriInfo,
            HttpServletRequest httpServletRequest) {
         // do nothing
      }

      @Override
      public void reversePurchase(
            PurchaseReversal body,
            SecurityContext securityContext,
            Request request,
            HttpHeaders httpHeaders,
            AsyncResponse asyncResponse,
            UriInfo uriInfo,
            HttpServletRequest httpServletRequest) {
         // do nothing
      }

      @Override
      public void getPurchaseStatus(
            String provider,
            String purchaseReference,
            String originalMsgId,
            SecurityContext securityContext,
            Request request,
            HttpHeaders httpHeaders,
            AsyncResponse asyncResponse,
            UriInfo uriInfo,
            HttpServletRequest httpServletRequest) {
         // do nothing
      }

      // If you are tempted to add an Override method here, you are introducing a breaking change.
      // Use the `default` access modifier when adding new methods to the IPurchaseResource class.
   }

}
