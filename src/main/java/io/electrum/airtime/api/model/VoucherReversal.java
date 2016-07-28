package io.electrum.airtime.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.airtime.api.model.Receiver;
import io.electrum.airtime.api.model.VoucherRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Information about the voucher provision being reversed.
 **/

@ApiModel(description = "Information about the voucher provision being reversed.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T12:50:43.313Z")
public class VoucherReversal   {
  
  private Receiver receiver = null;
  private String reversalDate = null;
  private VoucherRequest voucherRequest = null;

  /**
   * Information about the receiver of the VoucherRequest who must process the reversal. This information originates from the VoucherResponse and should be included if available.
   **/
  public VoucherReversal receiver(Receiver receiver) {
    this.receiver = receiver;
    return this;
  }

  
  @ApiModelProperty(value = "Information about the receiver of the VoucherRequest who must process the reversal. This information originates from the VoucherResponse and should be included if available.")
  @JsonProperty("receiver")
  public Receiver getReceiver() {
    return receiver;
  }
  public void setReceiver(Receiver receiver) {
    this.receiver = receiver;
  }

  /**
   * The date and time of the reversal as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision.
   **/
  public VoucherReversal reversalDate(String reversalDate) {
    this.reversalDate = reversalDate;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "The date and time of the reversal as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision.")
  @JsonProperty("reversalDate")
  public String getReversalDate() {
    return reversalDate;
  }
  public void setReversalDate(String reversalDate) {
    this.reversalDate = reversalDate;
  }

  /**
   **/
  public VoucherReversal voucherRequest(VoucherRequest voucherRequest) {
    this.voucherRequest = voucherRequest;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("voucherRequest")
  public VoucherRequest getVoucherRequest() {
    return voucherRequest;
  }
  public void setVoucherRequest(VoucherRequest voucherRequest) {
    this.voucherRequest = voucherRequest;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoucherReversal voucherReversal = (VoucherReversal) o;
    return Objects.equals(receiver, voucherReversal.receiver) &&
        Objects.equals(reversalDate, voucherReversal.reversalDate) &&
        Objects.equals(voucherRequest, voucherReversal.voucherRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(receiver, reversalDate, voucherRequest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoucherReversal {\n");
    
    sb.append("    receiver: ").append(toIndentedString(receiver)).append("\n");
    sb.append("    reversalDate: ").append(toIndentedString(reversalDate)).append("\n");
    sb.append("    voucherRequest: ").append(toIndentedString(voucherRequest)).append("\n");
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

