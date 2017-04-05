package io.electrum.airtime.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
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

@Path("/airtime/v5/vouchers")
@Api(description = "the Airtime Service Interface API", authorizations = { @Authorization("httpBasic") })
public abstract class VouchersResource {

   protected abstract IVouchersResource getResourceImplementation();

   @POST
   @Path("/{requestId}/confirmations/{confirmationId}")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = "Confirm a voucher provision request that completed successfully.", notes = ""
         + "Once a consumer has paid for a voucher and received the voucher from the merchant the "
         + "merchant must notify the vendor that the voucher may be redeemed at some point in the "
         + "future as per the voucher vendor's instructions. confirmVoucher must be repeated until "
         + "a final HTTP status code is received (i.e. not 500 or 504). confirmVoucher may be called "
         + "repeatedly on the same voucher resource without negative effect.")
   @ApiResponses(value = { @ApiResponse(code = 202, message = "Accepted", response = BasicAdvice.class),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
         @ApiResponse(code = 404, message = "Not Found", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void confirmVoucher(
         @ApiParam(value = "The UUID generated for the original voucher provision request.", required = true) @PathParam("requestId") String requestId,
         @ApiParam(value = "The randomly generated UUID of this request.", required = true) @PathParam("confirmationId") String confirmationId,
         @ApiParam(value = "A voucher provision confirmation.", required = true) VoucherConfirmation body,
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
   @Path("/{requestId}")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = "Request a voucher be provisioned.", notes = "Requests a voucher from the voucher vendor.")
   @ApiResponses(value = {
         @ApiResponse(code = 201, message = "Created", response = VoucherResponse.class, responseHeaders = {
               @ResponseHeader(name = "Location", description = "The location of the created voucher resource", response = String.class) }),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void provisionVoucher(
         @ApiParam(value = "The randomly generated UUID of this request.", required = true) @PathParam("requestId") String requestId,
         @ApiParam(value = "A voucher request.", required = true) VoucherRequest body,
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
   @Path("/{requestId}/reversals/{reversalId}")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = "Reverse a voucher provision request that failed or timed out.", notes = ""
         + "If a voucherProvision request fails with a 500 or 504 HTTP status code, or no response "
         + "was received within the timeout period, it must be reversed to ensure the vendor knows "
         + "to never expect further messages pertaining to the voucher. reverseVoucher must be repeated "
         + "until a final HTTP status code is received (i.e. not 500 or 504). reverseVoucher may be "
         + "called repeatedly on the same voucher resource without negative effect.")
   @ApiResponses(value = { @ApiResponse(code = 202, message = "Accepted", response = BasicAdvice.class),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
         @ApiResponse(code = 404, message = "Not Found"),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void reverseVoucher(
         @ApiParam(value = "The UUID generated for the original voucher provision request.", required = true) @PathParam("requestId") String requestId,
         @ApiParam(value = "The randomly generated UUID of this request.", required = true) @PathParam("reversalId") String reversalId,
         @ApiParam(value = "A voucher provision reversal.", required = true) BasicReversal body,
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
