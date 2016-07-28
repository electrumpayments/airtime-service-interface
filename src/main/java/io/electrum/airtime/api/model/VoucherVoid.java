package io.electrum.airtime.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.airtime.api.model.Receiver;
import io.electrum.airtime.api.model.Voucher;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Information about the voucher provision being voided. This object refers to a specific voucher which was previously successfully provisioned.
 **/

@ApiModel(description = "Information about the voucher provision being voided. This object refers to a specific voucher which was previously successfully provisioned.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T12:50:43.313Z")
public class VoucherVoid   {
  
  private Receiver receiver = null;
  private String voidDate = null;
  private Voucher voucher = null;

  /**
   * Information about the receiver of the VoucherRequest who must process the void. This information originates from the VoucherResponse and should be included if available.
   **/
  public VoucherVoid receiver(Receiver receiver) {
    this.receiver = receiver;
    return this;
  }

  
  @ApiModelProperty(value = "Information about the receiver of the VoucherRequest who must process the void. This information originates from the VoucherResponse and should be included if available.")
  @JsonProperty("receiver")
  public Receiver getReceiver() {
    return receiver;
  }
  public void setReceiver(Receiver receiver) {
    this.receiver = receiver;
  }

  /**
   * The date and time of the void as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision.
   **/
  public VoucherVoid voidDate(String voidDate) {
    this.voidDate = voidDate;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "The date and time of the void as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision.")
  @JsonProperty("voidDate")
  public String getVoidDate() {
    return voidDate;
  }
  public void setVoidDate(String voidDate) {
    this.voidDate = voidDate;
  }

  /**
   * Information about the specific voucher to be voided. This should at a minimum be the voucher serial number returned in the VoucherResponse so that the vendor can look up the voucher to be voided within the vendor's system.
   **/
  public VoucherVoid voucher(Voucher voucher) {
    this.voucher = voucher;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Information about the specific voucher to be voided. This should at a minimum be the voucher serial number returned in the VoucherResponse so that the vendor can look up the voucher to be voided within the vendor's system.")
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
    VoucherVoid voucherVoid = (VoucherVoid) o;
    return Objects.equals(receiver, voucherVoid.receiver) &&
        Objects.equals(voidDate, voucherVoid.voidDate) &&
        Objects.equals(voucher, voucherVoid.voucher);
  }

  @Override
  public int hashCode() {
    return Objects.hash(receiver, voidDate, voucher);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoucherVoid {\n");
    
    sb.append("    receiver: ").append(toIndentedString(receiver)).append("\n");
    sb.append("    voidDate: ").append(toIndentedString(voidDate)).append("\n");
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

