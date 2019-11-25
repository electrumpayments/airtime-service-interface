package io.electrum.airtime.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.airtime.api.model.ErrorDetail;
import io.electrum.airtime.api.model.MsisdnInfoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path(MsisdnResource.RESOURCE_PATH)
@Api(description = "the Airtime Service Interface API", authorizations = { @Authorization("httpBasic") })
public abstract class MsisdnResource {

   protected abstract IMsisdnResource getResourceImplementation();

   public static final String RESOURCE_PATH = "/msisdn";
   public static final String PATH = AirtimeApi.API_BASE_PATH + RESOURCE_PATH;

   public class LookupMsisdn {
      public static final String LOOKUP_MSISDN = "lookupMsisdn";
      public static final int SUCCESS = 200;
      public static final String PATH = "/";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = MsisdnResource.PATH + RELATIVE_PATH;

      public class QueryParameters {
         public static final String MSISDN = "msisdn";
         public static final String OPERATOR = "operator";
         public static final String PRODUCT_TYPE = "productType";
      }
   }

   /**
    * Deprecated to perform lookupMsisdn method with extra QueryParameter productType.
    * 
    * @deprecated instead use {@link #lookupMsisdn(String, String, String, SecurityContext, Request, AsyncResponse,
    * HttpHeaders, UriInfo, HttpServletRequest)
    * 
    */
   @Deprecated
   public final void lookupMsisdn(
         String msisdn,
         String operator,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().lookupMsisdn(
            msisdn,
            operator,
            null,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }

   @GET
   @Path(LookupMsisdn.RELATIVE_PATH)
   @Produces({ "application/json" })
   @ApiOperation(nickname = LookupMsisdn.LOOKUP_MSISDN, value = "Looks up information associated with the given Msisdn. "
         + "This includes such information as available products and promotions, operator information etc.")
   @ApiResponses(value = {
         @ApiResponse(code = LookupMsisdn.SUCCESS, message = "Accepted", response = MsisdnInfoResponse.class),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
         @ApiResponse(code = 404, message = "Not Found"),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void lookupMsisdn(
         @ApiParam(value = "The Msisdn. This must conform to the ITU E.164 numbering plan (https://www.itu.int/rec/T-REC-E.164/en).", required = true) @QueryParam(LookupMsisdn.QueryParameters.MSISDN) @Pattern(regexp = "^\\+?[1-9]\\d{1,14}") @NotNull String msisdn,
         @ApiParam(value = "The provider who processed the original purchase attempt.") @QueryParam(LookupMsisdn.QueryParameters.OPERATOR) String operator,
         @ApiParam(value = "Used to filter the products to lookup for a given msisdn.") @QueryParam(LookupMsisdn.QueryParameters.PRODUCT_TYPE) String productType,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().lookupMsisdn(
            msisdn,
            operator,
            productType,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }
}
