package io.electrum.vas.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.airtime.api.IPurchaseResource;
import io.electrum.airtime.api.model.PurchaseConfirmation;
import io.electrum.airtime.api.model.PurchaseRequest;
import io.electrum.airtime.api.model.PurchaseReversal;

/**
 * This class provides an implementation of the {@link IPurchaseResource} interface for testing purposes.
 * <p>
 * There are two aspects of the {@link IPurchaseResource} interface which are tested so as not to break existing
 * interface implementations:
 * <ul>
 * <li>That new interface methods are defined with a default implementation.</li>
 * <li>That new interface methods which overload existing methods lead to calling the existing method.</li>
 * </ul>
 * <p>
 * If this class does not compile after you have changed the {@link IPurchaseResource} interface, you have likely broken
 * the {@link IPurchaseResource} interface as per the first point above.
 *
 */
public class IPurchaseResourceTestImpl implements IPurchaseResource {

   @Override
   public void confirmPurchase(
         PurchaseConfirmation body,
         SecurityContext securityContext,
         Request request,
         HttpHeaders httpHeaders,
         AsyncResponse asyncResponse,
         UriInfo uriInfo,
         HttpServletRequest httpServletRequest) {

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

   }
}
