package io.electrum.airtime.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

public interface IProductsResource {
   default void getProductsImpl(
         String channelName,
         SecurityContext securityContext,
         Request request,
         HttpHeaders httpHeaders,
         AsyncResponse asyncResponse,
         UriInfo uriInfo,
         HttpServletRequest httpServletRequest) {
      asyncResponse.resume(new ServerErrorException("This operation has not been implemented.", 501));
   }
}
