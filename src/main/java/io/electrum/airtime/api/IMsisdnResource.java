package io.electrum.airtime.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

public interface IMsisdnResource {
   @Deprecated
   void lookupMsisdn(
         String msisdn,
         String operator,
         SecurityContext securityContext,
         Request request,
         HttpHeaders httpHeaders,
         AsyncResponse asyncResponse,
         UriInfo uriInfo,
         HttpServletRequest httpServletRequest);

   /**
    * @since 5.14.0
    */
   @Deprecated
   default void lookupMsisdn(
         String msisdn,
         String operator,
         String productType,
         SecurityContext securityContext,
         Request request,
         HttpHeaders httpHeaders,
         AsyncResponse asyncResponse,
         UriInfo uriInfo,
         HttpServletRequest httpServletRequest) {
      lookupMsisdn(
              msisdn,
              operator,
              securityContext,
              request,
              httpHeaders,
              asyncResponse,
              uriInfo,
              httpServletRequest);
   }

   /**
    * @since 5.15.0
    */
   @Deprecated
   default void lookupMsisdn(
           String msisdn,
           String operator,
           String productType,
           String channelName,
           SecurityContext securityContext,
           Request request,
           HttpHeaders httpHeaders,
           AsyncResponse asyncResponse,
           UriInfo uriInfo,
           HttpServletRequest httpServletRequest) {
      lookupMsisdn(
              msisdn,
              operator,
              securityContext,
              request,
              httpHeaders,
              asyncResponse,
              uriInfo,
              httpServletRequest);
   }

   /**
    * @since 5.21.0
    */
   default void lookupMsisdn(
           String msisdn,
           String operator,
           String productType,
           String channelName,
           String productCategory,
           SecurityContext securityContext,
           Request request,
           HttpHeaders httpHeaders,
           AsyncResponse asyncResponse,
           UriInfo uriInfo,
           HttpServletRequest httpServletRequest) {
      lookupMsisdn(
              msisdn,
              operator,
              securityContext,
              request,
              httpHeaders,
              asyncResponse,
              uriInfo,
              httpServletRequest);
   }
}
