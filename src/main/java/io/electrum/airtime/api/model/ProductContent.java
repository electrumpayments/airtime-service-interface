package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Specifically describes the content of the airtime product.
 * @since 5.14.0
 **/

@ApiModel(description = "Specifically describes the content of the airtime product.")
public class ProductContent {

   /**
    * Every airtime product unit must be classified into one of the following unit types:
    * KB, MB or GB for data; Unit for SMSs; Minutes for airtime
    */
   public enum AirtimeProductUnit {
      KB("KB"), MB("MB"), GB("GB"), UNIT("Unit"), MINUTES("Minutes");

      private String value;

      AirtimeProductUnit(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return value;
      }
   }

   private long amount = 0L;
   private AirtimeProductUnit unit;

   /**
    * The size of the product in KB, MB or GB for data; Unit for SMSs; Minutes for airtime.
    */
   public ProductContent amount(long amount) {
      this.amount = amount;
      return this;
   }

   /**
    * The size of the product in KB, MB or GB for data; Unit for SMSs; Minutes for airtime.
    *
    * @return amount
    */
   @ApiModelProperty(required = true, value = "The size of the product in KB, MB or GB for data; " +
           "Unit for SMSs; Minutes for airtime.")
   @JsonProperty("amount")
   @NotNull
   @Min(0L)
   public long getAmount() {
      return amount;
   }

   public void setAmount(long amount) {
      this.amount = amount;
   }

   /**
    * The unit of product. Can be KB, MB or GB for data; Unit for SMSs or Minutes for airtime.
    */
   public ProductContent unit(AirtimeProductUnit unit) {
      this.unit = unit;
      return this;
   }

   /**
    *  The unit of product. Can be KB, MB or GB for data; Unit for SMSs; Minutes for airtime.
    *
    * @return unit
    */
   @ApiModelProperty(required = true, value = "The unit of product. Can be KB, MB or GB for data; " +
           "Unit for SMSs; Minutes for airtime.")
   @JsonProperty("unit")
   @NotNull
   public AirtimeProductUnit getUnit() {
      return unit;
   }

   public void setUnit(AirtimeProductUnit unit) {
      this.unit = unit;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      ProductContent that = (ProductContent) o;
      return amount == that.amount && unit == that.unit;
   }

   @Override
   public int hashCode() {
      return Objects.hash(amount, unit);
   }

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder();
      sb.append("class ProductContent {").append(System.lineSeparator());
      sb.append("    amount:").append(Utils.toIndentedString(amount)).append(System.lineSeparator());
      sb.append("    unit:").append(Utils.toIndentedString(unit)).append(System.lineSeparator());
      sb.append('}');
      return sb.toString();
   }
}
