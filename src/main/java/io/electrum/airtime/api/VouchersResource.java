package io.electrum.airtime.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.airtime.api.model.ErrorDetail;
import io.electrum.airtime.api.model.VoucherConfirmation;
import io.electrum.airtime.api.model.VoucherRequest;
import io.electrum.airtime.api.model.VoucherResponse;
import io.electrum.vas.model.BasicAdvice;
import io.electrum.vas.model.BasicReversal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.ResponseHeader;

@Path(VouchersResource.RESOURCE_PATH)
@Deprecated
@Api(description = "the Airtime Service Interface API", authorizations = { @Authorization("httpBasic") })
public abstract class VouchersResource {

   protected abstract IVouchersResource getResourceImplementation();

   public static final String RESOURCE_PATH = "/vouchers";
   public static final String PATH = AirtimeApi.API_BASE_PATH + RESOURCE_PATH;

   public class ConfirmVoucher {
      public static final String CONFIRM_VOUCHER = "confirmVoucher";
      public static final int SUCCESS = 202;
      public static final String PATH =
            "/{" + PathParameters.REQUEST_ID + "}/confirmations/{" + PathParameters.CONFIRMATION_ID + "}";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = VouchersResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String CONFIRMATION_ID = "confirmationId";
         public static final String REQUEST_ID = "requestId";
      }
   }

   public class ProvisionVoucher {
      public static final String PROVISION_VOUCHER = "provisionVoucher";
      public static final int SUCCESS = 201;
      public static final String PATH = "/{" + PathParameters.REQUEST_ID + "}";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = VouchersResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String REQUEST_ID = "requestId";
      }
   }

   public class ReverseVoucher {
      public static final String REVERSE_VOUCHER = "reverseVoucher";
      public static final int SUCCESS = 202;
      public static final String PATH =
            "/{" + PathParameters.REQUEST_ID + "}/reversals/{" + PathParameters.REVERSAL_ID + "}";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = VouchersResource.PATH + RELATIVE_PATH;

      public class PathParameters {
         public static final String REVERSAL_ID = "reversalId";
         public static final String REQUEST_ID = "requestId";
      }
   }

   @POST
   @Path(ConfirmVoucher.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = ConfirmVoucher.CONFIRM_VOUCHER, value = "Confirm a voucher provision request that completed successfully.", notes = ""
         + "Once a consumer has paid for a voucher and received the voucher from the merchant the "
         + "merchant must notify the vendor that the voucher may be redeemed at some point in the "
         + "future as per the voucher vendor's instructions. confirmVoucher must be repeated until "
         + "a final HTTP status code is received (i.e. not 500 or 504). confirmVoucher may be called "
         + "repeatedly on the same voucher resource without negative effect.")
   @ApiResponses(value = {
         @ApiResponse(code = ConfirmVoucher.SUCCESS, message = "Accepted", response = BasicAdvice.class, responseHeaders = {
                 @ResponseHeader(name = AirtimeApi.Headers.X_JWS_SIGNATURE, description = "When message integrity checking has been enabled, contains a JWS signature of the payload", response = String.class) }),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class, responseHeaders = {
                 @ResponseHeader(name = AirtimeApi.Headers.X_JWS_SIGNATURE, description = "When message integrity checking has been enabled, contains a JWS signature of the payload", response = String.class) }),
         @ApiResponse(code = 404, message = "Not Found", response = ErrorDetail.class, responseHeaders = {
                 @ResponseHeader(name = AirtimeApi.Headers.X_JWS_SIGNATURE, description = "When message integrity checking has been enabled, contains a JWS signature of the payload", response = String.class) }),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class, responseHeaders = {
                 @ResponseHeader(name = AirtimeApi.Headers.X_JWS_SIGNATURE, description = "When message integrity checking has been enabled, contains a JWS signature of the payload", response = String.class) }),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class, responseHeaders = {
                 @ResponseHeader(name = AirtimeApi.Headers.X_JWS_SIGNATURE, description = "When message integrity checking has been enabled, contains a JWS signature of the payload", response = String.class) }),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class, responseHeaders = {
                 @ResponseHeader(name = AirtimeApi.Headers.X_JWS_SIGNATURE, description = "When message integrity checking has been enabled, contains a JWS signature of the payload", response = String.class) }) })
   /**
    * This operation has been deprecated. Use
    * {@link PurchaseResource#confirmPurchase(PurchaseConfirmation, SecurityContext, Request, AsyncResponse, HttpHeaders, UriInfo, HttpServletRequest)}
    * instead.
    * 
    * @param requestId
    * @param confirmationId
    * @param body
    * @param securityContext
    * @param request
    * @param asyncResponse
    * @param httpHeaders
    * @param uriInfo
    * @param httpServletRequest
    */
   public final void confirmVoucher(
         @ApiParam(value = "When message integrity checking has been enabled, contains a JWS signature of the payload") @HeaderParam(value = "x-jws-signature") String jwsHeader,
         @ApiParam(value = "The UUID generated for the original voucher provision request.", required = true) @NotNull @PathParam(ConfirmVoucher.PathParameters.REQUEST_ID) String requestId,
         @ApiParam(value = "The randomly generated UUID of this request.", required = true) @PathParam(ConfirmVoucher.PathParameters.CONFIRMATION_ID) String confirmationId,
         @ApiParam(value = "A voucher provision confirmation.", required = true) @NotNull @Valid VoucherConfirmation body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().confirmVoucherImpl(
            requestId,
            confirmationId,
            body,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }

   @POST
   @Path(ProvisionVoucher.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = ProvisionVoucher.PROVISION_VOUCHER, value = "Request a voucher be provisioned.", notes = "Requests a voucher from the voucher vendor.")
   @ApiResponses(value = {
         @ApiResponse(code = ProvisionVoucher.SUCCESS, message = "Created", response = VoucherResponse.class, responseHeaders = {
               @ResponseHeader(name = "Location", description = "The location of the created voucher resource", response = String.class),
               @ResponseHeader(name = AirtimeApi.Headers.X_JWS_SIGNATURE, description = "When message integrity checking has been enabled, contains a JWS signature of the payload", response = String.class) }),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class, responseHeaders = {
               @ResponseHeader(name = AirtimeApi.Headers.X_JWS_SIGNATURE, description = "When message integrity checking has been enabled, contains a JWS signature of the payload", response = String.class) }),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class, responseHeaders = {
               @ResponseHeader(name = AirtimeApi.Headers.X_JWS_SIGNATURE, description = "When message integrity checking has been enabled, contains a JWS signature of the payload", response = String.class) }),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class, responseHeaders = {
               @ResponseHeader(name = AirtimeApi.Headers.X_JWS_SIGNATURE, description = "When message integrity checking has been enabled, contains a JWS signature of the payload", response = String.class) }),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class, responseHeaders = {
               @ResponseHeader(name = AirtimeApi.Headers.X_JWS_SIGNATURE, description = "When message integrity checking has been enabled, contains a JWS signature of the payload", response = String.class) }) })

   /**
    * This operation has been deprecated. Use {@link PurchaseResource#purchase(PurchaseRequest, SecurityContext,
    * Request, AsyncResponse, HttpHeaders, UriInfo, HttpServletRequest)(PurchaseConfirmation, SecurityContext, Request,
    * AsyncResponse, HttpHeaders, UriInfo, HttpServletRequest)} instead.
    * 
    * @param requestId
    * @param body
    * @param securityContext
    * @param request
    * @param asyncResponse
    * @param httpHeaders
    * @param uriInfo
    * @param httpServletRequest
    */
   public final void provisionVoucher(
         @ApiParam(value = "When message integrity checking has been enabled, contains a JWS signature of the payload") @HeaderParam(value = "x-jws-signature") String jwsHeader,
         @ApiParam(value = "The randomly generated UUID of this request.", required = true) @NotNull @PathParam(ProvisionVoucher.PathParameters.REQUEST_ID) String requestId,
         @ApiParam(value = "A voucher request.", required = true) @NotNull @Valid VoucherRequest body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().provisionVoucherImpl(
            requestId,
            body,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }

   @POST
   @Path(ReverseVoucher.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = ReverseVoucher.REVERSE_VOUCHER, value = "Reverse a voucher provision request that failed or timed out.", notes = ""
         + "If a voucherProvision request fails with a 500 or 504 HTTP status code, or no response "
         + "was received within the timeout period, it must be reversed to ensure the vendor knows "
         + "to never expect further messages pertaining to the voucher. reverseVoucher must be repeated "
         + "until a final HTTP status code is received (i.e. not 500 or 504). reverseVoucher may be "
         + "called repeatedly on the same voucher resource without negative effect.")
   @ApiResponses(value = {
         @ApiResponse(code = ReverseVoucher.SUCCESS, message = "Accepted", response = BasicAdvice.class, responseHeaders = {
                 @ResponseHeader(name = AirtimeApi.Headers.X_JWS_SIGNATURE, description = "When message integrity checking has been enabled, contains a JWS signature of the payload", response = String.class) }),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class, responseHeaders = {
                 @ResponseHeader(name = AirtimeApi.Headers.X_JWS_SIGNATURE, description = "When message integrity checking has been enabled, contains a JWS signature of the payload", response = String.class) }),
         @ApiResponse(code = 404, message = "Not Found"),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class, responseHeaders = {
                 @ResponseHeader(name = AirtimeApi.Headers.X_JWS_SIGNATURE, description = "When message integrity checking has been enabled, contains a JWS signature of the payload", response = String.class) }),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class, responseHeaders = {
                 @ResponseHeader(name = AirtimeApi.Headers.X_JWS_SIGNATURE, description = "When message integrity checking has been enabled, contains a JWS signature of the payload", response = String.class) }),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class, responseHeaders = {
                 @ResponseHeader(name = AirtimeApi.Headers.X_JWS_SIGNATURE, description = "When message integrity checking has been enabled, contains a JWS signature of the payload", response = String.class) }) })
   /**
    * This operation has been deprecated. Use {@link PurchaseResource#reversePurchase(PurchaseReversal, SecurityContext,
    * Request, AsyncResponse, HttpHeaders, UriInfo, HttpServletRequest)(PurchaseRequest, SecurityContext, Request,
    * AsyncResponse, HttpHeaders, UriInfo, HttpServletRequest)(PurchaseConfirmation, SecurityContext, Request,
    * AsyncResponse, HttpHeaders, UriInfo, HttpServletRequest)} instead.
    * 
    * @param requestId
    * @param body
    * @param securityContext
    * @param request
    * @param asyncResponse
    * @param httpHeaders
    * @param uriInfo
    * @param httpServletRequest
    */
   public final void reverseVoucher(
         @ApiParam(value = "When message integrity checking has been enabled, contains a JWS signature of the payload") @HeaderParam(value = "x-jws-signature") String jwsHeader,
         @ApiParam(value = "The UUID generated for the original voucher provision request.", required = true) @PathParam(ReverseVoucher.PathParameters.REQUEST_ID) String requestId,
         @ApiParam(value = "The randomly generated UUID of this request.", required = true) @PathParam(ReverseVoucher.PathParameters.REVERSAL_ID) String reversalId,
         @ApiParam(value = "A voucher provision reversal.", required = true) @NotNull @Valid BasicReversal body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().reverseVoucherImpl(
            requestId,
            reversalId,
            body,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }
}
