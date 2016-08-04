package io.electrum.airtime.api.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information about the voucher provision being voided. This object refers to a specific voucher which was previously
 * successfully provisioned.
 **/

@ApiModel(description = "Information about the voucher provision being voided. This object refers to a specific voucher which was previously successfully provisioned.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-01T07:39:12.071Z")
public class VoucherVoid {

   private String voidId = null;
   private Merchant merchant = null;
   private Institution sender = null;
   private Institution processor = null;
   private Institution vendor = null;
   private String voidDate = null;
   private Voucher voucher = null;

   /**
    * The randomly generated UUID identifying this voucher void, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122). This must be the same as the voidId path parameter.
    **/
   public VoucherVoid voidId(String voidId) {
      this.voidId = voidId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this voucher void, as defined for a variant 4 UUID in [RFC 4122](https://tools.ietf.org/html/rfc4122). This must be the same as the voidId path parameter.")
   @JsonProperty("voidId")
   public String getVoidId() {
      return voidId;
   }

   public void setVoidId(String voidId) {
      this.voidId = voidId;
   }

   /**
    * Copied from the voucher request.
    **/
   public VoucherVoid merchant(Merchant merchant) {
      this.merchant = merchant;
      return this;
   }

   @ApiModelProperty(required = true, value = "Copied from the voucher request.")
   @JsonProperty("merchant")
   public Merchant getMerchant() {
      return merchant;
   }

   public void setMerchant(Merchant merchant) {
      this.merchant = merchant;
   }

   /**
    * Copied from the voucher request.
    **/
   public VoucherVoid sender(Institution sender) {
      this.sender = sender;
      return this;
   }

   @ApiModelProperty(required = true, value = "Copied from the voucher request.")
   @JsonProperty("sender")
   public Institution getSender() {
      return sender;
   }

   public void setSender(Institution sender) {
      this.sender = sender;
   }

   /**
    * Information about the processor with whom the merchant must settle.
    **/
   public VoucherVoid processor(Institution processor) {
      this.processor = processor;
      return this;
   }

   @ApiModelProperty(required = true, value = "Information about the processor with whom the merchant must settle.")
   @JsonProperty("processor")
   public Institution getProcessor() {
      return processor;
   }

   public void setProcessor(Institution processor) {
      this.processor = processor;
   }

   /**
    * Information about the vendor who ultimately processed the voucher request.
    **/
   public VoucherVoid vendor(Institution receiver) {
      this.vendor = receiver;
      return this;
   }

   @ApiModelProperty(required = true, value = "Information about the vendor who ultimately processed the voucher reqeust.")
   @JsonProperty("vendor")
   public Institution getVendor() {
      return vendor;
   }

   public void setVendor(Institution vendor) {
      this.vendor = vendor;
   }

   /**
    * The date and time of the void as recorded by the sender. The format shall be as defined for date-time in [RFC 3339
    * section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be
    * included up to millisecond precision.
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
    * Information about the specific voucher to be voided. This should at a minimum be the voucher serial number
    * returned in the VoucherResponse so that the vendor can look up the voucher to be voided within the vendor's
    * system.
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
      return Objects.equals(voidId, voucherVoid.voidId)
            && Objects.equals(merchant, voucherVoid.merchant) && Objects.equals(sender, voucherVoid.sender)
            && Objects.equals(processor, voucherVoid.processor) && Objects.equals(vendor, voucherVoid.vendor) && Objects.equals(voidDate, voucherVoid.voidDate)
            && Objects.equals(voucher, voucherVoid.voucher);
   }

   @Override
   public int hashCode() {
      return Objects.hash(voidId, merchant, sender, processor, vendor, voidDate, voucher);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class VoucherVoid {\n");

      sb.append("    voidId: ").append(toIndentedString(voidId)).append("\n");
      sb.append("    merchant: ").append(toIndentedString(merchant)).append("\n");
      sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
      sb.append("    processor: ").append(toIndentedString(processor)).append("\n");
      sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
      sb.append("    voidDate: ").append(toIndentedString(voidDate)).append("\n");
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
