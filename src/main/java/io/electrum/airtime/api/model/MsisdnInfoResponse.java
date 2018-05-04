package io.electrum.airtime.api.model;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.Institution;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information about the MSISDN.
 **/

@ApiModel(description = "Information about the MSISDN.")
public class MsisdnInfoResponse {

   private Institution msisdn;
   private Amounts amounts = null;
   private Product[] availableProducts = null;

   /**
    * The Mobile Network Operator (MNO) to whom the MSISDN belongs.
    **/
   public MsisdnInfoResponse operator(Institution operator) {
      this.msisdn = operator;
      return this;
   }

   @ApiModelProperty(value = "The Mobile Network Operator (MNO) to whom the MSISDN belongs.")
   @JsonProperty("msisdn")
   @Valid
   public Institution getOperator() {
      return msisdn;
   }

   public void setOperator(Institution operator) {
      this.msisdn = operator;
   }

   /**
    * Additional amounts which may pertain to transactions against the MSISDN.
    **/
   public MsisdnInfoResponse amounts(Amounts amounts) {
      this.amounts = amounts;
      return this;
   }

   @ApiModelProperty(required = false, value = "Additional amounts which may pertain to transactions against the MSISDN.")
   @JsonProperty("amounts")
   @Valid
   public Amounts getAmounts() {
      return amounts;
   }

   public void setAmounts(Amounts amounts) {
      this.amounts = amounts;
   }

   /**
    * Products which may be available to the customer identified by the MSISDN.
    **/
   public MsisdnInfoResponse responseProduct(Product[] availableProducts) {
      this.availableProducts = availableProducts;
      return this;
   }

   @ApiModelProperty(value = "Products which may be available to the customer identified by the MSISDN.")
   @JsonProperty("availableProducts")
   @Valid
   public Product[] getResponseProduct() {
      return availableProducts;
   }

   public void setResponseProduct(Product[] availableProducts) {
      this.availableProducts = availableProducts;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MsisdnInfoResponse {\n");

      sb.append("    msisdn: ").append(Utils.toIndentedString(msisdn)).append("\n");
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append("\n");
      sb.append("    availableProducts: ").append(Utils.toIndentedString(availableProducts)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
