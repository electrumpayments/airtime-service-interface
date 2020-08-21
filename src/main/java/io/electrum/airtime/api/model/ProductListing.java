package io.electrum.airtime.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.electrum.vas.Utils;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.LedgerAmount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * A product that can be listed for sale via one or more channels.
 **/

@ApiModel(description = "A product that can be listed for sale via one or more channels.")
public class ProductListing {

   private Product product;
   private List<ChannelProductListing> channels = null;

   /**
    * An available product.
    **/
   public ProductListing product(Product product) {
      this.product = product;
      return this;
   }

   /**
    * An available product.
    *
    * @return product
    **/
   @ApiModelProperty(value = "An available product.")
   @JsonProperty(value = "product", required = true)
   @NotNull
   @Valid
   public Product getProduct() {
      return product;
   }

   public void setProduct(Product product) {
      this.product = product;
   }

   public ProductListing channels(List<ChannelProductListing> channels) {
      this.channels = channels;
      return this;
   }

   /**
    * A list of channels the product is available at.
    *
    * @return productContents
    **/
   @ApiModelProperty(value = "A list of channels the product is available at.")
   @JsonProperty("channels")
   @Valid
   public List<ChannelProductListing> getChannels() {
      return channels;
   }

   public void setChannels( List<ChannelProductListing> channels) {
      this.channels = channels;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ProductListing productListing = (ProductListing) o;
      return Objects.equals(this.product, productListing.product)
            && Objects.equals(this.channels, productListing.channels);
   }

   @Override
   public int hashCode() {
      return Objects.hash(product, channels);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ProductListing {\n");

      sb.append("    product: ").append(Utils.toIndentedString(product)).append('\n');
      sb.append("    channels: ").append(Utils.toIndentedString(channels)).append('\n');
      sb.append('}');
      return sb.toString();
   }
}
