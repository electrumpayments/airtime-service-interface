package io.electrum.airtime.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.airtime.api.model.Product;
import io.electrum.airtime.api.model.Sender;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Information about the voucher provision request.
 **/

@ApiModel(description = "Information about the voucher provision request.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T12:50:43.313Z")
public class VoucherRequest   {
  
  private String voucherId = null;
  private Product product = null;
  private String time = null;
  private Sender sender = null;

  /**
   * The randomly generated UUID identifying this voucher request, as defined for a variant 4 UUID in [RFC 4122](https://tools.ietf.org/html/rfc4122). This must be the same as the voucherId path parameter.
   **/
  public VoucherRequest voucherId(String voucherId) {
    this.voucherId = voucherId;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this voucher request, as defined for a variant 4 UUID in [RFC 4122](https://tools.ietf.org/html/rfc4122). This must be the same as the voucherId path parameter.")
  @JsonProperty("voucherId")
  public String getVoucherId() {
    return voucherId;
  }
  public void setVoucherId(String voucherId) {
    this.voucherId = voucherId;
  }

  /**
   **/
  public VoucherRequest product(Product product) {
    this.product = product;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("product")
  public Product getProduct() {
    return product;
  }
  public void setProduct(Product product) {
    this.product = product;
  }

  /**
   * The date and time of the request as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision.
   **/
  public VoucherRequest time(String time) {
    this.time = time;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "The date and time of the request as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision.")
  @JsonProperty("time")
  public String getTime() {
    return time;
  }
  public void setTime(String time) {
    this.time = time;
  }

  /**
   **/
  public VoucherRequest sender(Sender sender) {
    this.sender = sender;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("sender")
  public Sender getSender() {
    return sender;
  }
  public void setSender(Sender sender) {
    this.sender = sender;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoucherRequest voucherRequest = (VoucherRequest) o;
    return Objects.equals(voucherId, voucherRequest.voucherId) &&
        Objects.equals(product, voucherRequest.product) &&
        Objects.equals(time, voucherRequest.time) &&
        Objects.equals(sender, voucherRequest.sender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(voucherId, product, time, sender);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoucherRequest {\n");
    
    sb.append("    voucherId: ").append(toIndentedString(voucherId)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
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

