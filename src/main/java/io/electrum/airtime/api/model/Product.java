package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Product related data.
 **/

@ApiModel(description = "Product related data.")
public class Product {
   
   public enum ProductType
   {
      AIRTIME_FIXED("AIRTIME_FIXED"),
      AIRTIME_VARIABLE("AIRTIME_VARIABLE"),
      SMS_BUNDLE("SMS_BUNDLE"),
      DATA("DATA"),
      APP_RELATED("APP_RELATED"),
      COMBO("COMBO");
      private String value;

      ProductType(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   private String productId = null;
   private String barcode = null;
   private String name = null;
   private ProductType type = null;

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

   public Product barcode(String barcode) {
      this.barcode = barcode;
      return this;
   }

   /**
    * A barcode code identifying the product.
    * This is an alternative identifier for
    * the product but does not supersede the productId.
    * 
    * @return barcode
    **/
   @ApiModelProperty(value = "A barcode code identifying the product. This is an alternative identifier for the product but does not supersede the productId.")
   @JsonProperty("barcode")
   @Pattern(regexp = "[0-9A-Za-z]{1,13}")
   public String getBarcode() {
      return barcode;
   }

   public void setBarcode(String barcode) {
      this.barcode = barcode;
   }

   public Product name(String name) {
      this.name = name;
      return this;
   }

   /**
    * The name of the product.
    * 
    * @return name
    **/
   @ApiModelProperty(value = "The name of the product.")
   @JsonProperty("name")
   @Pattern(regexp = "[0-9A-Za-z]{1,20}")
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Product type(ProductType type) {
      this.type = type;
      return this;
   }

   /**
    * An indication of the type of product (.
    * 
    * @return type
    **/
   @ApiModelProperty(value = "An indication of the type of the product.")
   @JsonProperty("type")
   public ProductType getType() {
      return type;
   }

   public void setType(ProductType type) {
      this.type = type;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Product product = (Product) o;
      return Objects.equals(this.productId, product.productId) && Objects.equals(this.barcode, product.barcode)
            && Objects.equals(this.name, product.name) && Objects.equals(this.type, product.type);
   }

   @Override
   public int hashCode() {
      return Objects.hash(productId, barcode, name, type);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Product {\n");

      sb.append("    productId: ").append(Utils.toIndentedString(productId)).append("\n");
      sb.append("    barcode: ").append(Utils.toIndentedString(barcode)).append("\n");
      sb.append("    name: ").append(Utils.toIndentedString(name)).append("\n");
      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
