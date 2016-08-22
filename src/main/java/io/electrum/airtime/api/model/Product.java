package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.LedgerAmount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Product related data.
 **/

@ApiModel(description = "Product related data.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-01T07:39:12.071Z")
public class Product {

   private String productId = null;
   private LedgerAmount amount = null;

   /**
    * A vendor determined code identifying the product the voucher should pertain to.
    **/
   public Product productId(String productId) {
      this.productId = productId;
      return this;
   }

   @ApiModelProperty(required = true, value = "A vendor determined code identifying the product the voucher should pertain to.")
   @JsonProperty("productId")
   @Pattern(regexp = "[0-9A-Za-z]{1,20}")
   @NotNull
   public String getProductId() {
      return productId;
   }

   public void setProductId(String productId) {
      this.productId = productId;
   }

   /**
    * If the product identified by the product code is not a fixed price product then the amount field indicates the
    * value of the product referred to.
    **/
   public Product amount(LedgerAmount amount) {
      this.amount = amount;
      return this;
   }

   @ApiModelProperty(value = "If the product identified by the product code is not a fixed price product then the amount field indicates the value of the product referred to.")
   @JsonProperty("amount")
   public LedgerAmount getAmount() {
      return amount;
   }

   public void setAmount(LedgerAmount amount) {
      this.amount = amount;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Product product = (Product) o;
      return Objects.equals(productId, product.productId) && Objects.equals(amount, product.amount);
   }

   @Override
   public int hashCode() {
      return Objects.hash(productId, amount);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Product {\n");

      sb.append("    productId: ").append(Utils.toIndentedString(productId)).append("\n");
      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
