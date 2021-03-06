package io.electrum.airtime.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Specifically describes the voucher provisioned by the vendor.
 **/

@ApiModel(description = "Specifically describes the voucher provisioned by the vendor.")
public class Voucher {

   private String pin = null;
   protected DateTime expiryDate = null;
   private String serialNumber = null;
   private String batchNumber = null;
   private List<String> redeemInstructions = new ArrayList<String>();

   /**
    * The voucher's PIN used by the customer to redeem the voucher. This must be present in VoucherResponse messages. It
    * is recommended this field not be populated in other instances as it may be considered sensitive data.
    **/
   public Voucher pin(String pin) {
      this.pin = pin;
      return this;
   }

   @ApiModelProperty(value = "The voucher's PIN used by the customer to redeem the voucher. This must be present in VoucherResponse messages. It is recommended this field not be populated in other instances as it may be considered sensitive data.")
   @JsonProperty("pin")
   @Pattern(regexp = "[0-9]{1,20}")
   public String getPin() {
      return pin;
   }

   public void setPin(String pin) {
      this.pin = pin;
   }

   /**
    * The date and time at which the voucher expires in UTC. The format shall be as defined for date-time in [RFC 3339
    * section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).
    **/
   public Voucher expiryDate(DateTime expiryDate) {
      this.expiryDate = expiryDate;
      return this;
   }

   @ApiModelProperty(value = "The date and time at which the voucher expires in UTC. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6).")
   @JsonProperty("expiryDate")
   public DateTime getExpiryDate() {
      return expiryDate;
   }

   public void setExpiryDate(DateTime expiryDate) {
      this.expiryDate = expiryDate;
   }

   /**
    * The voucher's serial number. This can be used to identify the voucher in the vendor's system but cannot be used to
    * redeem the voucher.
    **/
   public Voucher serialNumber(String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @ApiModelProperty(required = true, value = "The voucher's serial number. This can be used to identify the voucher in the vendor's system but cannot be used to redeem the voucher.")
   @JsonProperty("serialNumber")
   @Pattern(regexp = "[0-9a-zA-Z]{1,20}")
   @NotNull
   public String getSerialNumber() {
      return serialNumber;
   }

   public void setSerialNumber(String serialNumber) {
      this.serialNumber = serialNumber;
   }

   /**
    * The voucher's batch number. This can be used to help identify the voucher in the vendor's system but cannot be
    * used to redeem the voucher.
    **/
   public Voucher batchNumber(String batchNumber) {
      this.batchNumber = batchNumber;
      return this;
   }

   @ApiModelProperty(value = "The voucher's batch number. This can be used to help identify the voucher in the vendor's system but cannot be used to redeem the voucher.")
   @JsonProperty("batchNumber")
   @Pattern(regexp = "[0-9a-zA-Z]{1,20}")
   public String getBatchNumber() {
      return batchNumber;
   }

   public void setBatchNumber(String batchNumber) {
      this.batchNumber = batchNumber;
   }

   /**
    * An array of free text lines which provide the customer with information on how to redeem the voucher. This are
    * intended to be printed on a customer's receipt slip.
    **/
   public Voucher redeemInstructions(List<String> redeemInstructions) {
      this.redeemInstructions = redeemInstructions;
      return this;
   }

   @ApiModelProperty(value = "An array of free text lines which provide the customer with information on how to redeem the voucher. This are intended to be printed on a customer's receipt slip.")
   @JsonProperty("redeemInstructions")
   public List<String> getRedeemInstructions() {
      return redeemInstructions;
   }

   public void setRedeemInstructions(List<String> redeemInstructions) {
      this.redeemInstructions = redeemInstructions;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Voucher voucher = (Voucher) o;
      return Objects.equals(pin, voucher.pin) && Objects.equals(expiryDate, voucher.expiryDate)
            && Objects.equals(serialNumber, voucher.serialNumber) && Objects.equals(batchNumber, voucher.batchNumber)
            && Objects.equals(redeemInstructions, voucher.redeemInstructions);
   }

   @Override
   public int hashCode() {
      return Objects.hash(pin, expiryDate, serialNumber, batchNumber, redeemInstructions);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Voucher {\n");

      sb.append("    pin: ").append(Utils.toIndentedString(pin)).append('\n');
      sb.append("    expiryDate: ").append(Utils.toIndentedString(expiryDate)).append('\n');
      sb.append("    serialNumber: ").append(Utils.toIndentedString(serialNumber)).append('\n');
      sb.append("    batchNumber: ").append(Utils.toIndentedString(batchNumber)).append('\n');
      sb.append("    redeemInstructions: ").append(Utils.toIndentedString(redeemInstructions)).append('\n');
      sb.append('}');
      return sb.toString();
   }
}
