package io.electrum.airtime.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
import io.electrum.airtime.api.model.PurchaseConfirmation;
import io.electrum.airtime.api.model.PurchaseRequest;
import io.electrum.airtime.api.model.PurchaseResponse;
import io.electrum.airtime.api.model.PurchaseReversal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Path(PurchaseResource.RESOURCE_PATH)
@Api(description = "the Airtime Service Interface API", authorizations = { @Authorization("httpBasic") })
public abstract class PurchaseResource {

   protected abstract IPurchaseResource getResourceImplementation();

   public static final String RESOURCE_PATH = "/purchases";
   public static final String PATH = AirtimeApi.API_BASE_PATH + RESOURCE_PATH;

   public class ConfirmPurchase {
      public static final String PURCHASE_CONFIRMATION = "purchaseConfirmation";
      public static final int SUCCESS = 202;
      public static final String PATH = "/confirmations";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = PurchaseResource.PATH + RELATIVE_PATH;
   }

   public class Purchase {
      public static final String PURCHASE = "purchase";
      public static final int SUCCESS = 201;
      public static final String PATH = "/";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = PurchaseResource.PATH + RELATIVE_PATH;
   }

   public class ReversePurchase {
      public static final String REVERSE_PURCHASE = "purchaseReversal";
      public static final int SUCCESS = 202;
      public static final String PATH = "/reversals";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = PurchaseResource.PATH + RELATIVE_PATH;
   }

   /**
    * @since v5.16.0
    */
   public static class TrialPurchase {
      public static final String TRIAL_PURCHASE = "purchaseTrial";
      public static final int SUCCESS = 200;
      public static final String PATH = "/trials";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = PurchaseResource.PATH + RELATIVE_PATH;
   }

   public class GetPurchaseStatus {
      public static final String GET_PURCHASE_STATUS = "purchaseStatus";
      public static final int SUCCESS = 200;
      public static final String PATH = "/status";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = PurchaseResource.PATH + RELATIVE_PATH;

      public class QueryParameters {
         public static final String PROVIDER = "provider";
         public static final String PURCHASE_REF = "purchaseReference";
         public static final String ORIGINAL_MSG_ID = "originalMsgId";
      }
   }

   @POST
   @Path(ConfirmPurchase.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = ConfirmPurchase.PURCHASE_CONFIRMATION, value = "Confirm that a previous purchase operation has completed successfully at the POS.", notes = ""
         + "Once a consumer has paid for an airtime product the merchant must notify the vendor that the transaction"
         + "completed successfully at the POS. confirmPurchase must be repeated until a final HTTP status code is"
         + "received (i.e. not 500 or 504). confirmPurchase may be called repeatedly without negative effect.")
   @ApiResponses(value = {
         @ApiResponse(code = ConfirmPurchase.SUCCESS, message = "Accepted", response = PurchaseConfirmation.class),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
         @ApiResponse(code = 404, message = "Not Found", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void confirmPurchase(
         @ApiParam(value = "A purchase confirmation.", required = true) @NotNull @Valid PurchaseConfirmation body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .confirmPurchase(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }

   @POST
   @Path(Purchase.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = Purchase.PURCHASE, value = "Purchase an airtime product.", notes = "Requests an airtime product from the provider.")
   @ApiResponses(value = {
         @ApiResponse(code = Purchase.SUCCESS, message = "Created", response = PurchaseResponse.class),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void purchase(
         @ApiParam(value = "An airtime request.", required = true) @NotNull @Valid PurchaseRequest body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .purchasePurchase(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }

   @POST
   @Path(ReversePurchase.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = ReversePurchase.REVERSE_PURCHASE, value = "Reverse an airtime purchase request that failed or timed out.", notes = ""
         + "If a purchase operation fails with a 500 or 504 HTTP status code, or no response "
         + "was received within the timeout period, and the provider supports the reversal operation, "
         + "it must be reversed to ensure the provider knows the airtime purchase did not complete successfully. "
         + "purchaseReversal must be repeated until a final HTTP status code is received (i.e. not 500 or 504). "
         + "purchaseReversal may be called repeatedly on the same airtime purchase resource without negative effect. "
         + "If the airtime provider does not support the reversal operation, please refer to the purchaseStatus operation.")
   @ApiResponses(value = {
         @ApiResponse(code = ReversePurchase.SUCCESS, message = "Accepted", response = PurchaseReversal.class),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
         @ApiResponse(code = 404, message = "Not Found"),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void reversePurchase(
         @ApiParam(value = "An airtime purchase reversal.", required = true) @NotNull @Valid PurchaseReversal body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .reversePurchase(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }

   /**
    *
    * This operation is identical to the `{@code purchase}` operation except that no voucher is returned (for voucher
    * based products) and no product will be applied to the MSISDN (for direct top-ups), and this operation carries no
    * financial impact. The purpose of this operation is to determine whether it is worth proceeding to a tender step,
    * i.e. is a subsequent purchase likely to to be successful (in which case the downstream should move to the tender
    * step) or fail (in which case the downstream should not take tender).
    *
    * @since v5.16.0
    *
    * @param body
    * @param securityContext
    * @param request
    * @param asyncResponse
    * @param httpHeaders
    * @param uriInfo
    * @param httpServletRequest
    */
   @POST
   @Path(TrialPurchase.RELATIVE_PATH)
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(nickname = TrialPurchase.TRIAL_PURCHASE, value = "Trial purchase for an airtime product.", notes = "This operation is identical to the "
         + Purchase.PURCHASE
         + " operation except that no voucher is returned (for voucher based products) and no product will be applied to the MSISDN (for direct top-ups), and this operation carries no financial impact. The purpose of this operation is to determine whether it is worth proceeding to a tender step, i.e. is a subsequent purchase likely to to be successful (in which case the downstream should move to the tender step) or fail (in which case the downstream should not take tender).")
   @ApiResponses(value = {
         @ApiResponse(code = TrialPurchase.SUCCESS, message = "OK", response = PurchaseResponse.class),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void trialPurchase(
         @ApiParam(value = "An airtime request.", required = true) @NotNull @Valid PurchaseRequest body,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation()
            .trialPurchase(body, securityContext, request, httpHeaders, asyncResponse, uriInfo, httpServletRequest);
   }

   @GET
   @Path(GetPurchaseStatus.RELATIVE_PATH)
   @Produces({ "application/json" })
   @ApiOperation(nickname = GetPurchaseStatus.GET_PURCHASE_STATUS, value = "Looks up the status of a prior airtime purchase at the specified provider. "
         + "If the airtime provider does not support the reversal operation then the purchaseStatus operation should be used to "
         + "determine the outcome of a prior purchase. This operation will, as far as possbile, return the same "
         + "PurchaseResponse or ErrorDetail as would have been returned had the original purchase completed normally.")
   @ApiResponses(value = {
         @ApiResponse(code = GetPurchaseStatus.SUCCESS, message = "Accepted", response = PurchaseResponse.class),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
         @ApiResponse(code = 404, message = "Not Found"),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void getPurchaseStatus(
         @ApiParam(value = "The provider who processed the original purchase attempt. Conditionally required if purchaseRef is supplied.") @QueryParam(GetPurchaseStatus.QueryParameters.PROVIDER) String provider,
         @ApiParam(value = "The reference returned in the original purchase attempt. Conditionally required if the originalMsgId is not supplied.") @QueryParam(GetPurchaseStatus.QueryParameters.PURCHASE_REF) String purchaseReference,
         @ApiParam(value = "The message ID of the original PurchaseRequest which failed. Conditionally required if the purchaseRef is not supplied.") @QueryParam(GetPurchaseStatus.QueryParameters.ORIGINAL_MSG_ID) String originalMsgId,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().getPurchaseStatus(
            provider,
            purchaseReference,
            originalMsgId,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }
}
