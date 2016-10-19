package io.electrum.airtime.api.model;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Information about the voucher provision request.
 **/

@ApiModel(description = "Information about the voucher provision request.")
public class VoucherRequest extends Transaction {

   private Amounts amounts = null;
   private Product product = null;

   /**
    * If the product identified by the product field is not a fixed price product then the amounts field indicates the
    * value of the product referred to.
    **/
   public VoucherRequest amounts(Amounts amounts) {
      this.amounts = amounts;
      return this;
   }

   @ApiModelProperty(required = false, value = "If the product identified by the product field is not a fixed price "
         + "product then the amounts field indicates the value of the product referred to.")
   @JsonProperty("amounts")
   public Amounts getAmounts() {
      return amounts;
   }

   public void setAmounts(Amounts amounts) {
      this.amounts = amounts;
   }

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
