package io.electrum.vas.api.interfaceTestImpl;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.airtime.api.IVouchersResource;
import io.electrum.airtime.api.model.VoucherConfirmation;
import io.electrum.airtime.api.model.VoucherRequest;
import io.electrum.vas.model.BasicReversal;

/**
 * This class provides an implementation of the {@link IVouchersResource} interface for testing purposes.
 * <p>
 * There are two aspects of the {@link IVouchersResource} interface which are tested so as not to break existing
 * interface implementations:
 * <ul>
 * <li>That new interface methods are defined with a default implementation.</li>
 * <li>That new interface methods which overload existing methods lead to calling the existing method.</li>
 * </ul>
 * <p>
 * If this class does not compile after you have changed the {@link IVouchersResource} interface, you have likely broken
 * the {@link IVouchersResource} interface as per the first point above.
 *
 */
public class IVouchersResourceTestImpl implements IVouchersResource {
   @Override
   public void confirmVoucherImpl(
         String voucherId,
         String confirmationId,
         VoucherConfirmation body,
         SecurityContext securityContext,
         Request request,
         HttpHeaders httpHeaders,
         AsyncResponse asyncResponse,
         UriInfo uriInfo,
         HttpServletRequest httpServletRequest) {

   }

   @Override
   public void provisionVoucherImpl(
         String voucherId,
         VoucherRequest body,
         SecurityContext securityContext,
         Request request,
         HttpHeaders httpHeaders,
         AsyncResponse asyncResponse,
         UriInfo uriInfo,
         HttpServletRequest httpServletRequest) {

   }

   @Override
   public void reverseVoucherImpl(
         String voucherId,
         String reversalId,
         BasicReversal body,
         SecurityContext securityContext,
         Request request,
         HttpHeaders httpHeaders,
         AsyncResponse asyncResponse,
         UriInfo uriInfo,
         HttpServletRequest httpServletRequest) {

   }
}
