package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An amount object containing only value and currency.
 **/

@ApiModel(description = "An amount object containing only value and currency.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-01T07:39:12.071Z")
public class Amount {

   private Long amount = null;
   private String currency = null;

   /**
    * Amount in minor denomination, e.g. R799.95 is encoded as 79995.
    **/
   public Amount amount(Long amount) {
      this.amount = amount;
      return this;
   }

   @ApiModelProperty(required = true, value = "Amount in minor denomination, e.g. R799.95 is encoded as 79995.")
   @JsonProperty("amount")
   @Pattern(regexp = "[0-9]{3}")
   public Long getAmount() {
      return amount;
   }

   public void setAmount(Long amount) {
      this.amount = amount;
   }

   /**
    * Three digit currency number from ISO 4217, e.g. South African Rand is encoded as 710.
    **/
   public Amount currency(String currency) {
      this.currency = currency;
      return this;
   }

   @ApiModelProperty(required = true, value = "Three digit currency number from ISO 4217, e.g. South African Rand is encoded as 710.")
   @JsonProperty("currency")
   public String getCurrency() {
      return currency;
   }

   public void setCurrency(String currency) {
      this.currency = currency;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Amount amount = (Amount) o;
      return Objects.equals(amount, amount.amount) && Objects.equals(currency, amount.currency);
   }

   @Override
   public int hashCode() {
      return Objects.hash(amount, currency);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Amount {\n");

      sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
      sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
      sb.append("}");
      return sb.toString();
   }

   /**
    * Convert the given object to string with each line indented by 4 spaces (except the first line).
    */
   private String toIndentedString(Object o) {
      if (o == null) {
         return "null";
      }
      return o.toString().replace("\n", "\n    ");
   }
}
