package io.electrum.airtime.api.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * A description for a product which can either entirely or in part describe the product.
 * 
 * @since 5.22.0
 */
@ApiModel(description = "A description for a product which can either entirely or in part describe the product.")
public class DescriptionAttribute {

   private String name;
   private String description;

   public DescriptionAttribute name(String name) {
      this.name = name;
      return this;
   }

   /**
    * The name of the description attribute.
    *
    * @since 5.22.0
    * @return the name of the description attribute
    */
   @ApiModelProperty(required = true, value = "The name of the description attribute.")
   @JsonProperty("name")
   @NotNull
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
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
      return Objects.equals(name, that.name) && Objects.equals(description, that.description);
   }

   @Override
   public int hashCode() {
      return Objects.hash(name, description);
   }

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("DescriptionAttribute{");
      sb.append("name='").append(name).append('\'');
      sb.append(", description='").append(description).append('\'');
      sb.append('}');
      return sb.toString();
   }
}
