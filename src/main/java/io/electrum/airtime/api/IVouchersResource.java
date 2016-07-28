package io.electrum.airtime.api;

import java.util.UUID;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.airtime.api.model.VoucherConfirmation;
import io.electrum.airtime.api.model.VoucherRequest;
import io.electrum.airtime.api.model.VoucherReversal;
import io.electrum.airtime.api.model.VoucherVoid;

public interface IVouchersResource {

   void confirmVoucher(
         UUID id,
         UUID voucherId,
         VoucherConfirmation body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void provisionVoucher(
         UUID id,
         VoucherRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void reverseVoucher(
         UUID id,
         UUID voucherId,
         VoucherReversal body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void voidVoucher(
         UUID id,
         UUID voucherId,
         VoucherVoid body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);
}
