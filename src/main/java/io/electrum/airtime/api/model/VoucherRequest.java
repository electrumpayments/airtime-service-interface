package io.electrum.airtime.api.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information about the voucher provision request.
 **/

@ApiModel(description = "Information about the voucher provision request.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-01T07:39:12.071Z")
public class VoucherRequest extends Transaction {

   private Product product = null;
   
   /**
    * The product for which the voucher should be provisioned.
    **/
   public VoucherRequest product(Product product) {
      this.product = product;
      return this;
   }

   @ApiModelProperty(required = true, value = "The product for which the voucher should be provisioned.")
   @JsonProperty("product")
   @NotNull
   public Product getProduct() {
      return product;
   }

   public void setProduct(Product product) {
      this.product = product;
   }
   
   @Override
   @ApiModelProperty(required = true, value = "Data relating to the sender of the VoucherRequest.")
   @JsonProperty("client")
   @NotNull
   public Institution getClient() {
      return client;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class VoucherRequest {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    product: ").append(Utils.toIndentedString(product)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
