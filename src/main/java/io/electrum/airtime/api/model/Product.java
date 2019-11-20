package io.electrum.airtime.api.model;

import java.util.Arrays;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.electrum.vas.Utils;
import io.electrum.vas.model.LedgerAmount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Product related data.
 **/

@ApiModel(description = "Product related data.")
public class Product {

   public enum ProductType {
      AIRTIME_FIXED("AIRTIME_FIXED"),
      AIRTIME_VARIABLE("AIRTIME_VARIABLE"),
      SMS_BUNDLE("SMS_BUNDLE"),
      DATA("DATA"),
      DATA_FIXED("DATA_FIXED"),
      DATA_VARIABLE("DATA_VARIABLE"),
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

   private Boolean isDirectTopup = null;
   private String productId = null;
   private String barcode = null;
   private String name = null;
   private ProductType type = null;
   private LedgerAmount wholesalePrice = null;
   private LedgerAmount recipientAmount = null;
   private LedgerAmount[] productValues = null;

   /**
    * Describes whether or not the product directly recharges the recipients account (true), or a voucher number is
    * required (false) to redeem the product.
    **/
   public Product isDirectTopup(Boolean isDirectTopup) {
      this.isDirectTopup = isDirectTopup;
      return this;
   }

   /**
    * Describes whether or not the product directly recharges the recipients account (true), or a voucher number is
    * required (false) to redeem the product.
    *
    * @return isDirectTopup
    **/
   @ApiModelProperty(value = "Describes whether or not the product directly recharges the recipients account (true), or a voucher number is required (false) to redeem the product.")
   @JsonProperty("isDirectTopup")
   public Boolean getIsDirectTopup() {
      return isDirectTopup;
   }

   public void setIsDirectTopup(Boolean isDirectTopup) {
      this.isDirectTopup = isDirectTopup;
   }

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
    * A barcode code identifying the product. This is an alternative identifier for the product but does not supersede
    * the productId.
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
   @Length(min = 1, max = 40)
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

   public Product wholesalePrice(LedgerAmount wholesalePrice) {
      this.wholesalePrice = wholesalePrice;
      return this;
   }

   /**
    * The wholesale price of the product. The currency is the currency of the merchant's account with the provider.
    * 
    * @return wholesalePrice
    **/
   @ApiModelProperty(value = "The wholesale price of the product. The currency is "
         + "in the currency of the merchant's account with the provider.")
   @JsonProperty("wholesalePrice")
   public LedgerAmount getWholesalePrice() {
      return wholesalePrice;
   }

   public void setWholesalePrice(LedgerAmount wholesalePrice) {
      this.wholesalePrice = wholesalePrice;
   }

   public Product recipientAmount(LedgerAmount recipientAmount) {
      this.recipientAmount = recipientAmount;
      return this;
   }

   /**
    * The amount received by the recipient. The currency is the currency of the destination country.
    * 
    * @return recipientAmount
    **/
   @ApiModelProperty(value = "The amount received by the recipient. The currency is in the currency"
         + " of the destination country.")
   @JsonProperty("recipientAmount")
   public LedgerAmount getRecipientAmount() {
      return recipientAmount;
   }

   public void setRecipientAmount(LedgerAmount recipientAmount) {
      this.recipientAmount = recipientAmount;
   }

   public Product productValues(LedgerAmount[] productValues) {
      this.productValues = productValues;
      return this;
   }

   /**
    * The value of the product. Multiple values may be returned in varying currencies in the case of products available
    * internationally.
    * 
    * @return productValues
    **/
   @ApiModelProperty(value = "The value of the product. Multiple values may be returned in varying currencies in the case of products available internationally.")
   @JsonProperty("productValues")
   public LedgerAmount[] getProductValues() {
      return productValues;
   }

   public void setProductValues(LedgerAmount[] productValues) {
      this.productValues = productValues;
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
      return Objects.equals(this.isDirectTopup, product.isDirectTopup)
            && Objects.equals(this.productId, product.productId) && Objects.equals(this.barcode, product.barcode)
            && Objects.equals(this.name, product.name) && Objects.equals(this.type, product.type)
            && Objects.equals(this.wholesalePrice, product.wholesalePrice)
            && Objects.equals(this.recipientAmount, product.recipientAmount);
   }

   @Override
   public int hashCode() {
      return Objects.hash(isDirectTopup, productId, barcode, name, type, wholesalePrice, recipientAmount);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Product {\n");

      sb.append("    isDirectTopup: ").append(Utils.toIndentedString(isDirectTopup)).append('\n');
      sb.append("    productId: ").append(Utils.toIndentedString(productId)).append('\n');
      sb.append("    barcode: ").append(Utils.toIndentedString(barcode)).append('\n');
      sb.append("    name: ").append(Utils.toIndentedString(name)).append('\n');
      sb.append("    type: ").append(Utils.toIndentedString(type)).append('\n');
      sb.append("    wholesalePrice: ").append(Utils.toIndentedString(wholesalePrice)).append('\n');
      sb.append("    recipientAmount: ").append(Utils.toIndentedString(recipientAmount)).append('\n');
      sb.append("    productValues: ").append(Utils.toIndentedString(Arrays.toString(productValues))).append('\n');
      sb.append('}');
      return sb.toString();
   }
}
