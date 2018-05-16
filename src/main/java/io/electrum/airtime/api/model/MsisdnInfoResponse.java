package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.Transaction;
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
   private Promotion promotion = null;

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
   public MsisdnInfoResponse availableProducts(Product[] availableProducts) {
      this.availableProducts = availableProducts;
      return this;
   }

   @ApiModelProperty(value = "Products which may be available to the customer identified by the MSISDN.")
   @JsonProperty("availableProducts")
   @Valid
   public Product[] getAvaialbleProducts() {
      return availableProducts;
   }

   public void setAvaialbleProducts(Product[] availableProducts) {
      this.availableProducts = availableProducts;
   }

   /**
    * Promotional information for the customer identified by the MISDN.
    **/
   public MsisdnInfoResponse promotion(Promotion promotion) {
      this.promotion = promotion;
      return this;
   }

   @ApiModelProperty(value = "Promotional information for the customer identified by the MISDN.")
   @JsonProperty("promotion")
   @Valid
   public Promotion getPromotion() {
      return promotion;
   }

   public void setPromotion(Promotion promotion) {
      this.promotion = promotion;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      MsisdnInfoResponse msisdnInfoRsp = (MsisdnInfoResponse) o;
      return Objects.equals(msisdn, msisdnInfoRsp.msisdn) && Objects.equals(amounts, msisdnInfoRsp.amounts)
            && Objects.equals(availableProducts, msisdnInfoRsp.availableProducts) && Objects.equals(promotion, msisdnInfoRsp.promotion);
   }

   @Override
   public int hashCode() {
      return Objects.hash(msisdn, amounts, availableProducts, promotion);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MsisdnInfoResponse {\n");

      sb.append("    msisdn: ").append(Utils.toIndentedString(msisdn)).append("\n");
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append("\n");
      sb.append("    availableProducts: ").append(Utils.toIndentedString(availableProducts)).append("\n");
      sb.append("    promotion: ").append(Utils.toIndentedString(promotion)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
