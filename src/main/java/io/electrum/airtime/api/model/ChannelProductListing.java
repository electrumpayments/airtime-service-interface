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
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Product related data.
 **/

@ApiModel(description = "Product related data.")
public class ChannelProductListing {

   private String channelName = null;
   private String productDisplayName = null;
   private String productDisplayCategory = null;
   private Integer productDisplaySortOrder = null;

   /**
    * The name of the channel.
    **/
   public ChannelProductListing channelName(String channelName) {
      this.channelName = channelName;
      return this;
   }

   /**
    * The name of the channel.
    *
    * @return channelName
    **/
   @ApiModelProperty(value = "The name of the channel.")
   @JsonProperty(value = "channelName", required = true)
   @NotNull
   public String getChannelName() {
      return channelName;
   }

   public void setChannelName(String channelName) {
      this.channelName = channelName;
   }

   /**
    * The name of the product for display purposes.
    **/
   public ChannelProductListing productDisplayName(String productDisplayName) {
      this.productDisplayName = productDisplayName;
      return this;
   }

   /**
    * The name of the product for display purposes.
    *
    * @return channelName
    **/
   @ApiModelProperty(value = "The name of the product for display purposes.")
   @JsonProperty(value = "productDisplayName")
   public String getProductDisplayName() {
      return productDisplayName;
   }

   public void setProductDisplayName(String productDisplayName) {
      this.productDisplayName = productDisplayName;
   }

   /**
    * A category that is meaningful for display purposes.
    **/
   public ChannelProductListing productDisplayCategory(String productDisplayCategory) {
      this.productDisplayCategory = productDisplayCategory;
      return this;
   }

   /**
    * A category that is meaningful for display purposes.
    *
    * @return channelName
    **/
   @ApiModelProperty(value = "A category that is meaningful for display purposes.")
   @JsonProperty(value = "productDisplayCategory")
   public String getProductDisplayCategory() {
      return productDisplayCategory;
   }

   public void setProductDisplayCategory(String productDisplayCategory) {
      this.productDisplayCategory = productDisplayCategory;
   }

   /**
    * A sort order that is meaningful for display purposes.
    **/
   public ChannelProductListing productDisplaySortOrder(Integer productDisplaySortOrder) {
      this.productDisplaySortOrder = productDisplaySortOrder;
      return this;
   }

   /**
    * A sort order that is meaningful for display purposes.
    *
    * @return channelName
    **/
   @ApiModelProperty(value = "A sort order that is meaningful for display purposes.")
   @JsonProperty(value = "productDisplaySortOrder")
   public Integer getProductDisplaySortOrder() {
      return productDisplaySortOrder;
   }

   public void setProductDisplaySortOrder(Integer productDisplaySortOrder) {
      this.productDisplaySortOrder = productDisplaySortOrder;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ChannelProductListing channelProductListing = (ChannelProductListing) o;
      return Objects.equals(this.channelName, channelProductListing.channelName)
            && Objects.equals(this.productDisplayName, channelProductListing.productDisplayName)
            && Objects.equals(this.productDisplayCategory, channelProductListing.productDisplayCategory)
            && Objects.equals(this.productDisplaySortOrder, channelProductListing.productDisplaySortOrder);
   }

   @Override
   public int hashCode() {
      return Objects.hash(channelName, productDisplayName, productDisplayCategory, productDisplaySortOrder);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ChannelProductListing {\n");

      sb.append("    channelName: ").append(Utils.toIndentedString(channelName)).append('\n');
      sb.append("    productDisplayName: ").append(Utils.toIndentedString(productDisplayName)).append('\n');
      sb.append("    productDisplayCategory: ").append(Utils.toIndentedString(productDisplayCategory)).append('\n');
      sb.append("    productDisplaySortOrder: ").append(Utils.toIndentedString(productDisplaySortOrder)).append('\n');
      sb.append('}');
      return sb.toString();
   }
}
