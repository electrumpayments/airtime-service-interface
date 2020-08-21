package io.electrum.airtime.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.electrum.vas.model.Amounts;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Information about the available products.
 **/

@ApiModel(description = "Information about the available products.")
public class ProductListingResponse {

   private List<ProductListing> availableProducts = null;

   /**
    * The available products.
    **/
   public ProductListingResponse availableProducts(List<ProductListing> availableProducts) {
      this.availableProducts = availableProducts;
      return this;
   }

   @ApiModelProperty(value = "The available products.")
   @JsonProperty("availableProducts")
   @Valid
   public List<ProductListing> getAvailableProducts() {
      return availableProducts;
   }

   public void setAvailableProducts(List<ProductListing> availableProducts) {
      this.availableProducts = availableProducts;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ProductListingResponse productListingResponse = (ProductListingResponse) o;

      return Objects.equals(availableProducts, productListingResponse.availableProducts);
   }

   @Override
   public int hashCode() {
      return Objects.hash(availableProducts);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ProductListingResponse {\n");

      sb.append("    availableProducts: ").append(availableProducts).append('\n');
      sb.append('}');
      return sb.toString();
   }
}
