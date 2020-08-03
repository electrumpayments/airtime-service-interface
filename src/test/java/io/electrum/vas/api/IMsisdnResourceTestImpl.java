package io.electrum.vas.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.airtime.api.IMsisdnResource;

/**
 * This class provides an implementation of the {@link IMsisdnResource} interface for testing purposes.
 * <p>
 * There are two aspects of the {@link IMsisdnResource} interface which are tested so as not to break existing interface
 * implementations:
 * <ul>
 * <li>That new interface methods are defined with a default implementation.</li>
 * <li>That new interface methods which overload existing methods lead to calling the existing method.</li>
 * </ul>
 * <p>
 * If this class does not compile after you have changed the {@link IMsisdnResource} interface, you have likely broken
 * the {@link IMsisdnResource} interface as per the first point above.
 *
 */
public class IMsisdnResourceTestImpl implements IMsisdnResource {

   @Override
   public void lookupMsisdn(
         String msisdn,
         String operator,
         SecurityContext securityContext,
         Request request,
         HttpHeaders httpHeaders,
         AsyncResponse asyncResponse,
         UriInfo uriInfo,
         HttpServletRequest httpServletRequest) {

   }
}
