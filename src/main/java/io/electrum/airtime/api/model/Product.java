package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.airtime.api.model.Amount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Product related data
 **/

@ApiModel(description = "Product related data")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T12:50:43.313Z")
public class Product   {
  
  private String productId = null;
  private Amount amount = null;

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
  public String getProductId() {
    return productId;
  }
  public void setProductId(String productId) {
    this.productId = productId;
  }

  /**
   * If the product identified by the product code is not a fixed price product then the amount field indicates the value of the product referred to.
   **/
  public Product amount(Amount amount) {
    this.amount = amount;
    return this;
  }

  
  @ApiModelProperty(value = "If the product identified by the product code is not a fixed price product then the amount field indicates the value of the product referred to.")
  @JsonProperty("amount")
  public Amount getAmount() {
    return amount;
  }
  public void setAmount(Amount amount) {
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
    return Objects.equals(productId, product.productId) &&
        Objects.equals(amount, product.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

