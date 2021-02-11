package io.electrum.airtime.api.model;

import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A description for a product which contains relevant different types of descriptions.
 * 
 * @since 5.22.0
 */
@ApiModel(description = "A description for a product which contains relevant different types of descriptions.")
public class Description {

   private String primaryDescription;
   private String shortDescription;
   private Map<String, String> additionalDescriptions;

   public Description primaryDescription(String primaryDescription) {
      this.primaryDescription = primaryDescription;
      return this;
   }

   /**
    * The primary description of a product.
    *
    * @since 5.22.0
    * @return the primary description of a product
    */
   @ApiModelProperty(value = "The primary description of a product.")
   @JsonProperty("primaryDescription")
   public String getPrimaryDescription() {
      return primaryDescription;
   }

   public void setPrimaryDescription(String primaryDescription) {
      this.primaryDescription = primaryDescription;
   }

   public Description shortDescription(String shortDescription) {
      this.shortDescription = shortDescription;
      return this;
   }

   /**
    * A short description for a product which can be displayed alongside the name of the product to provide additional
    * context.
    *
    * @since 5.22.0
    * @return the short description for the product
    */
   @ApiModelProperty(value = "A short description for a product which can be displayed alongside the name of the product to provide additional context.")
   @JsonProperty("shortDescription")
   public String getShortDescription() {
      return shortDescription;
   }

   public void setShortDescription(String shortDescription) {
      this.shortDescription = shortDescription;
   }

   public Description additionalDescriptions(Map<String, String> additionalDescriptions) {
      this.additionalDescriptions = additionalDescriptions;
      return this;
   }

   /**
    * Any additional descriptions which are relevant to the product but don't appropriately fit into the other
    * description fields.
    *
    * @since 5.22.0
    * @return a map of additional descriptions
    */
   public Map<String, String> getAdditionalDescriptions() {
      return additionalDescriptions;
   }

   public void setAdditionalDescriptions(Map<String, String> additionalDescriptions) {
      this.additionalDescriptions = additionalDescriptions;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Description that = (Description) o;
      return Objects.equals(primaryDescription, that.primaryDescription)
            && Objects.equals(shortDescription, that.shortDescription)
            && Objects.equals(additionalDescriptions, that.additionalDescriptions);
   }

   @Override
   public int hashCode() {
      return Objects.hash(primaryDescription, shortDescription, additionalDescriptions);
   }

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("Description{");
      sb.append("primaryDescription='").append(primaryDescription).append('\'');
      sb.append(", shortDescription='").append(shortDescription).append('\'');
      sb.append(", additionalDescriptions=").append(additionalDescriptions);
      sb.append('}');
      return sb.toString();
   }
}
