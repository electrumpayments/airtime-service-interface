package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information about the voucher provision being confirmed. This object refers to a specific voucher which was
 * previously successfully provisioned.
 **/

@ApiModel(description = "Information about the voucher provision being confirmed. This object refers to a specific voucher which was previously successfully provisioned.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-01T07:39:12.071Z")
public class VoucherConfirmation {

   private String confirmationId = null;
   private Merchant merchant = null;
   private Institution sender = null;
   private Institution processor = null;
   private Institution vendor = null;
   private String confirmDate = null;
   private Voucher voucher = null;

   /**
    * The randomly generated UUID identifying this voucher confirmation, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122). This must be the same as the confirmationId path parameter.
    **/
   public VoucherConfirmation confirmationId(String confirmationId) {
      this.confirmationId = confirmationId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this voucher confirmation, as defined for a variant 4 UUID in [RFC 4122](https://tools.ietf.org/html/rfc4122). This must be the same as the confirmationId path parameter.")
   @JsonProperty("confirmationId")
   @NotNull
   public String getConfirmationId() {
      return confirmationId;
   }

   public void setConfirmationId(String confirmationId) {
      this.confirmationId = confirmationId;
   }

   /**
    * Copied from the voucher request.
    **/
   public VoucherConfirmation merchant(Merchant merchant) {
      this.merchant = merchant;
      return this;
   }

   @ApiModelProperty(required = true, value = "Copied from the voucher request.")
   @JsonProperty("merchant")
   @NotNull
   public Merchant getMerchant() {
      return merchant;
   }

   public void setMerchant(Merchant merchant) {
      this.merchant = merchant;
   }

   /**
    * Copied from the voucher request.
    **/
   public VoucherConfirmation sender(Institution sender) {
      this.sender = sender;
      return this;
   }

   @ApiModelProperty(required = true, value = "Copied from the voucher request.")
   @JsonProperty("sender")
   @NotNull
   public Institution getSender() {
      return sender;
   }

   public void setSender(Institution sender) {
      this.sender = sender;
   }

   /**
    * Information about the processor with whom the merchant must settle.
    **/
   public VoucherConfirmation processor(Institution processor) {
      this.processor = processor;
      return this;
   }

   @ApiModelProperty(required = true, value = "Information about the processor with whom the merchant must settle.")
   @JsonProperty("processor")
   @NotNull
   public Institution getProcessor() {
      return processor;
   }

   public void setProcessor(Institution processor) {
      this.processor = processor;
   }

   /**
    * Information about the vendor who ultimately processed the voucher request.
    **/
   public VoucherConfirmation vendor(Institution receiver) {
      this.vendor = receiver;
      return this;
   }

   @ApiModelProperty(required = true, value = "Information about the vendor who ultimately processed the voucher request.")
   @JsonProperty("vendor")
   @NotNull
   public Institution getVendor() {
      return vendor;
   }

   public void setVendor(Institution vendor) {
      this.vendor = vendor;
   }

   /**
    * The date and time of the confirmation as recorded by the sender. The format shall be as defined for date-time in
    * [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional
    * time-secfrac be included up to millisecond precision.
    **/
   public VoucherConfirmation confirmDate(String confirmDate) {
      this.confirmDate = confirmDate;
      return this;
   }

   @ApiModelProperty(required = true, value = "The date and time of the confirmation as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision.")
   @JsonProperty("confirmDate")
   @NotNull
   public String getConfirmDate() {
      return confirmDate;
   }

   public void setConfirmDate(String confirmDate) {
      this.confirmDate = confirmDate;
   }

   /**
    * Information about the specific voucher being confirmed. This should at a minimum be the voucher serial number
    * returned in the VoucherResponse so that the vendor can look up the voucher to be confirmed within the vendor's
    * system.
    **/
   public VoucherConfirmation voucher(Voucher voucher) {
      this.voucher = voucher;
      return this;
   }

   @ApiModelProperty(required = true, value = "Information about the specific voucher being confirmed. This should at a minimum be the voucher serial number returned in the VoucherResponse so that the vendor can look up the voucher to be confirmed within the vendor's system.")
   @JsonProperty("voucher")
   @NotNull
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
      return Objects.equals(confirmationId, voucherConfirmation.confirmationId)
            && Objects.equals(merchant, voucherConfirmation.merchant) && Objects.equals(sender, voucherConfirmation.sender)
            && Objects.equals(processor, voucherConfirmation.processor) && Objects.equals(vendor, voucherConfirmation.vendor)
            && Objects.equals(confirmDate, voucherConfirmation.confirmDate)
            && Objects.equals(voucher, voucherConfirmation.voucher);
   }

   @Override
   public int hashCode() {
      return Objects.hash(confirmationId, merchant, sender, processor, vendor, confirmDate, voucher);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class VoucherConfirmation {\n");

      sb.append("    confirmationId: ").append(toIndentedString(confirmationId)).append("\n");
      sb.append("    merchant: ").append(toIndentedString(merchant)).append("\n");
      sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
      sb.append("    processor: ").append(toIndentedString(processor)).append("\n");
      sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
      sb.append("    confirmDate: ").append(toIndentedString(confirmDate)).append("\n");
      sb.append("    voucher: ").append(toIndentedString(voucher)).append("\n");
      sb.append("}");
      return sb.toString();
   }

   /**
    * Convert the given object to string with each line indented by 4 spaces (except the first line).
    */
   private String toIndentedString(Object o) {
      if (o == null) {
         return "null";
      }
      return o.toString().replace("\n", "\n    ");
   }
}
