package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.Valid;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Promotion related data.
 **/

@ApiModel(description = "Promotion related data.")
public class Promotion {

   private String promotion = null;
   private DateTime startDate = null;
   private DateTime endDate = null;

   /**
    * A description of the promotion available to the subscriber.
    **/
   public Promotion promotion(String promotion) {
      this.promotion = promotion;
      return this;
   }

   @ApiModelProperty(required = true, value = "A description of the promotion available to the subscriber.")
   @JsonProperty("promotion")
   @Valid
   public String getPromotion() {
      return promotion;
   }

   public void setPromotion(String promotion) {
      this.promotion = promotion;
   }

   public Promotion startDate(DateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   /**
    * The start date of the promotion.
    * 
    * @return startDate
    **/
   @ApiModelProperty(value = "The start date of the promotion.")
   @JsonProperty("startDate")
   @Valid
   public DateTime getStartDate() {
      return startDate;
   }

   public void setStartDate(DateTime startDate) {
      this.startDate = startDate;
   }

   /**
    * The end date of the promotion.
    **/
   public Promotion endDate(DateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   @ApiModelProperty(value = "The end date of the promotion.")
   @JsonProperty("endDate")
   @Valid
   public DateTime getEndDate() {
      return endDate;
   }

   public void setEndDate(DateTime endDate) {
      this.endDate = endDate;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Promotion promotion = (Promotion) o;
      return Objects.equals(this.promotion, promotion.promotion) && Objects.equals(this.startDate, promotion.startDate)
            && Objects.equals(this.endDate, promotion.endDate);
   }

   @Override
   public int hashCode() {
      return Objects.hash(promotion, startDate, endDate);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Promotion {\n");

      sb.append("    promotion: ").append(Utils.toIndentedString(promotion)).append("\n");
      sb.append("    startDate: ").append(Utils.toIndentedString(startDate)).append("\n");
      sb.append("    endDate: ").append(Utils.toIndentedString(endDate)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
