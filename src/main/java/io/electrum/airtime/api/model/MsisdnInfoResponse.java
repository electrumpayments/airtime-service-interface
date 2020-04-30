package io.electrum.airtime.api.model;

import java.util.Arrays;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.interfaces.HasAmounts;
import io.electrum.vas.model.Amounts;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information about the Msisdn.
 **/

@ApiModel(description = "Information about the Msisdn.")
public class MsisdnInfoResponse implements HasAmounts {

   private Msisdn msisdn;
   private Amounts amounts = null;
   private Product[] availableProducts = null;
   private Promotion promotion = null;

   /**
    * The MSISDN which was looked up updated with relevant information returned.
    **/
   public MsisdnInfoResponse msisdn(Msisdn msisdn) {
      this.msisdn = msisdn;
      return this;
   }

   @ApiModelProperty(value = "The MSISDN which was looked up updated with relevant information returned.")
   @JsonProperty("msisdn")
   @Valid
   public Msisdn getMsisdn() {
      return msisdn;
   }

   public void setMsisdn(Msisdn msisdn) {
      this.msisdn = msisdn;
   }

   /**
    * Additional amounts which may pertain to transactions against the Msisdn.
    **/
   public MsisdnInfoResponse amounts(Amounts amounts) {
      this.amounts = amounts;
      return this;
   }

   @ApiModelProperty(required = false, value = "Additional amounts which may pertain to transactions against the Msisdn.")
   @JsonProperty("amounts")
   @Valid
   public Amounts getAmounts() {
      return amounts;
   }

   public void setAmounts(Amounts amounts) {
      this.amounts = amounts;
   }

   /**
    * Products which may be available to the customer identified by the Msisdn.
    **/
   public MsisdnInfoResponse availableProducts(Product[] availableProducts) {
      this.availableProducts = availableProducts;
      return this;
   }

   @ApiModelProperty(value = "Products which may be available to the customer identified by the Msisdn.")
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
            && Arrays.equals(availableProducts, msisdnInfoRsp.availableProducts)
            && Objects.equals(promotion, msisdnInfoRsp.promotion);
   }

   @Override
   public int hashCode() {
      return Objects.hash(msisdn, amounts, Arrays.hashCode(availableProducts), promotion);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MsisdnInfoResponse {\n");

      sb.append("    msisdn: ").append(Utils.toIndentedString(msisdn)).append('\n');
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append('\n');
      sb.append("    availableProducts: ").append(Arrays.toString(availableProducts)).append('\n');
      sb.append("    promotion: ").append(Utils.toIndentedString(promotion)).append('\n');
      sb.append('}');
      return sb.toString();
   }
}
