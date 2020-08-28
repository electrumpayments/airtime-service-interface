package io.electrum.airtime.api;

import io.electrum.airtime.api.model.ErrorDetail;
import io.electrum.airtime.api.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
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

@Path(ProductsResource.RESOURCE_PATH)
@Api(description = "the Airtime Service Interface API", authorizations = { @Authorization("httpBasic") })
public abstract class ProductsResource {

   protected abstract IProductsResource getResourceImplementation();

   public static final String RESOURCE_PATH = "/products";
   public static final String PATH = AirtimeApi.API_BASE_PATH + RESOURCE_PATH;

   public class GetProducts {
      public static final String LIST_PRODUCTS = "listProducts";
      public static final int SUCCESS = 200;
      public static final String PATH = "/";
      public static final String RELATIVE_PATH = PATH;
      public static final String FULL_PATH = ProductsResource.PATH + RELATIVE_PATH;

      public class QueryParameters {
         public static final String CHANNEL_NAME = "channelName";
      }
   }

   @GET
   @Path(GetProducts.RELATIVE_PATH)
   @Produces({ "application/json" })
   @ApiOperation(nickname = GetProducts.LIST_PRODUCTS, value = "Retrieves a list of available products. "
         + "If the products that are available for sale is maintained, this API call returns the list of products. " +
           "If such a list is not maintained, then a 501 Not Implemented status code will be returned.")
   @ApiResponses(value = {
         @ApiResponse(code = GetProducts.SUCCESS, message = "Success", response = Product.class, responseContainer = "List"),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
         @ApiResponse(code = 404, message = "Not Found"),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 501, message = "Not implemented"),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public final void lookupMsisdn(
         @ApiParam(value = "The name of the channel to retrieve products for. If set only products matching this " +
                 "channel name will be returned. If not set, all products will be returned.")
         @QueryParam(GetProducts.QueryParameters.CHANNEL_NAME) @NotNull String channelName,
         @Context SecurityContext securityContext,
         @Context Request request,
         @Suspended AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo,
         @Context HttpServletRequest httpServletRequest) {
      getResourceImplementation().getProductsImpl(
            channelName,
            securityContext,
            request,
            httpHeaders,
            asyncResponse,
            uriInfo,
            httpServletRequest);
   }
}
