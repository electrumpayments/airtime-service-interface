package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A description for a product which can either entirely or in part describe the product.
 * 
 * @since 5.22.0
 */
@ApiModel(description = "A description for a product which can either entirely or in part describe the product.")
public class DescriptionAttribute {

   private String type;
   private String description;

   public DescriptionAttribute type(String type) {
      this.type = type;
      return this;
   }

   /**
    * The type of the description attribute.
    *
    * @since 5.22.0
    * @return the type of the description attribute
    */
   @ApiModelProperty(required = true, value = "The type of the description attribute.")
   @JsonProperty("type")
   @NotNull
   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public DescriptionAttribute description(String description) {
      this.description = description;
      return this;
   }

   /**
    * The description, either full or partial, for the product.
    *
    * @since 5.22.0
    * @return the description for the product
    */
   @ApiModelProperty(required = true, value = "The description, either full or partial, for the product.")
   @JsonProperty("description")
   @NotNull
   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      DescriptionAttribute that = (DescriptionAttribute) o;
      return Objects.equals(type, that.type) && Objects.equals(description, that.description);
   }

   @Override
   public int hashCode() {
      return Objects.hash(type, description);
   }

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("DescriptionAttribute{");
      sb.append("type='").append(type).append('\'');
      sb.append(", description='").append(description).append('\'');
      sb.append('}');
      return sb.toString();
   }
}
