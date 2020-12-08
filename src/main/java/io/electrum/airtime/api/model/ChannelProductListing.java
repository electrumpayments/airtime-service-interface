package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Product data is it relates to a channel.
 **/

@ApiModel(description = "Product data is it relates to a channel.")
public class ChannelProductListing {

   private String channelName = null;
   private String productDisplayName = null;
   private String productDisplayCategory = null;
   private Double productDisplaySortOrder = null;
   private String channelProductIdentifier = null;

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
   @ApiModelProperty(value = "The name of the channel.", required = true)
   @JsonProperty(value = "channelName")
   @NotNull
   @Length(max = 50)
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
   @Length(max = 50)
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
   @Length(max = 50)
   public String getProductDisplayCategory() {
      return productDisplayCategory;
   }

   public void setProductDisplayCategory(String productDisplayCategory) {
      this.productDisplayCategory = productDisplayCategory;
   }

   /**
    * A menu sort order that is meaningful for display purposes.
    **/
   public ChannelProductListing productDisplaySortOrder(Double productDisplaySortOrder) {
      this.productDisplaySortOrder = productDisplaySortOrder;
      return this;
   }

   /**
    * A menu sort order that is meaningful for display purposes.
    *
    * @return channelName
    **/
   @ApiModelProperty(value = "A menu sort order that is meaningful for display purposes.")
   @JsonProperty(value = "productDisplaySortOrder")
   public Double getProductDisplaySortOrder() {
      return productDisplaySortOrder;
   }

   public void setProductDisplaySortOrder(Double productDisplaySortOrder) {
      this.productDisplaySortOrder = productDisplaySortOrder;
   }

   /**
    * A product identifier which is meaningful for the channel.
    **/
   public ChannelProductListing channelProductIdentifier(String channelProductIdentifier) {
      this.channelProductIdentifier = channelProductIdentifier;
      return this;
   }

   /**
    * A product identifier which is meaningful for the channel.
    *
    * @return channelProductIdentifier
    **/
   @ApiModelProperty(value = "A product identifier which is meaningful for the channel.")
   @JsonProperty(value = "channelProductId")
   @Length(max = 50)
   public String getChannelProductIdentifier() {
      return channelProductIdentifier;
   }

   public void setChannelProductIdentifier(String channelProductIdentifier) {
      this.channelProductIdentifier = channelProductIdentifier;
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
            && Objects.equals(this.productDisplaySortOrder, channelProductListing.productDisplaySortOrder)
            && Objects.equals(this.channelProductIdentifier, channelProductListing.channelProductIdentifier);
   }

   @Override
   public int hashCode() {
      return Objects.hash(
            channelName,
            productDisplayName,
            productDisplayCategory,
            productDisplaySortOrder,
            channelProductIdentifier);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ChannelProductListing {\n");

      sb.append("    channelName: ").append(Utils.toIndentedString(channelName)).append('\n');
      sb.append("    productDisplayName: ").append(Utils.toIndentedString(productDisplayName)).append('\n');
      sb.append("    productDisplayCategory: ").append(Utils.toIndentedString(productDisplayCategory)).append('\n');
      sb.append("    productDisplaySortOrder: ").append(Utils.toIndentedString(productDisplaySortOrder)).append('\n');
      sb.append("    channelProductIdentifier: ").append(Utils.toIndentedString(channelProductIdentifier)).append('\n');
      sb.append('}');
      return sb.toString();
   }
}
