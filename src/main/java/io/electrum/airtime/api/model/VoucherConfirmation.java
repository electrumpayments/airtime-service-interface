package io.electrum.airtime.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.airtime.api.model.Receiver;
import io.electrum.airtime.api.model.Voucher;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Information about the voucher provision being confirmed. This object refers to a specific voucher which was previously successfully provisioned.
 **/

@ApiModel(description = "Information about the voucher provision being confirmed. This object refers to a specific voucher which was previously successfully provisioned.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T12:50:43.313Z")
public class VoucherConfirmation   {
  
  private Receiver receiver = null;
  private String confirmDate = null;
  private Voucher voucher = null;

  /**
   * Information about the receiver of the VoucherRequest who must process the confirmation. This information originates from the VoucherResponse and should be included if available.
   **/
  public VoucherConfirmation receiver(Receiver receiver) {
    this.receiver = receiver;
    return this;
  }

  
  @ApiModelProperty(value = "Information about the receiver of the VoucherRequest who must process the confirmation. This information originates from the VoucherResponse and should be included if available.")
  @JsonProperty("receiver")
  public Receiver getReceiver() {
    return receiver;
  }
  public void setReceiver(Receiver receiver) {
    this.receiver = receiver;
  }

  /**
   * The date and time of the confirmation as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision.
   **/
  public VoucherConfirmation confirmDate(String confirmDate) {
    this.confirmDate = confirmDate;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "The date and time of the confirmation as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision.")
  @JsonProperty("confirmDate")
  public String getConfirmDate() {
    return confirmDate;
  }
  public void setConfirmDate(String confirmDate) {
    this.confirmDate = confirmDate;
  }

  /**
   * Information about the specific voucher being confirmed. This should at a minimum be the voucher serial number returned in the VoucherResponse so that the vendor can look up the voucher to be confirmed within the vendor's system.
   **/
  public VoucherConfirmation voucher(Voucher voucher) {
    this.voucher = voucher;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Information about the specific voucher being confirmed. This should at a minimum be the voucher serial number returned in the VoucherResponse so that the vendor can look up the voucher to be confirmed within the vendor's system.")
  @JsonProperty("voucher")
  public Voucher getVoucher() {
    return voucher;
  }
  public void setVoucher(Voucher voucher) {
    this.voucher = voucher;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoucherConfirmation voucherConfirmation = (VoucherConfirmation) o;
    return Objects.equals(receiver, voucherConfirmation.receiver) &&
        Objects.equals(confirmDate, voucherConfirmation.confirmDate) &&
        Objects.equals(voucher, voucherConfirmation.voucher);
  }

  @Override
  public int hashCode() {
    return Objects.hash(receiver, confirmDate, voucher);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoucherConfirmation {\n");
    
    sb.append("    receiver: ").append(toIndentedString(receiver)).append("\n");
    sb.append("    confirmDate: ").append(toIndentedString(confirmDate)).append("\n");
    sb.append("    voucher: ").append(toIndentedString(voucher)).append("\n");
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

