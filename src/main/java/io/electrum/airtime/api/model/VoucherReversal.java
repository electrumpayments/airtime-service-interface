package io.electrum.airtime.api.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information about the voucher provision being reversed.
 **/

@ApiModel(description = "Information about the voucher provision being reversed.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-01T07:39:12.071Z")
public class VoucherReversal {

   private String reversalId = null;
   private Merchant merchant = null;
   private Institution sender = null;
   private Institution processor = null;
   private Institution vendor = null;
   private String reversalTime = null;
   private VoucherRequest voucherRequest = null;

   /**
    * The randomly generated UUID identifying this voucher reversal, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122). This must be the same as the reversalId path parameter.
    **/
   public VoucherReversal reversalId(String reversalId) {
      this.reversalId = reversalId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this voucher reversal, as defined for a variant 4 UUID in [RFC 4122](https://tools.ietf.org/html/rfc4122). This must be the same as the reversalId path parameter.")
   @JsonProperty("reversalId")
   public String getReversalId() {
      return reversalId;
   }

   public void setReversalId(String reversalId) {
      this.reversalId = reversalId;
   }

   /**
    * Information about the merchant who originated the request.
    **/
   public VoucherReversal merchant(Merchant merchant) {
      this.merchant = merchant;
      return this;
   }

   @ApiModelProperty(required = true, value = "Information about the merchant who originated the request.")
   @JsonProperty("merchant")
   public Merchant getMerchant() {
      return merchant;
   }

   public void setMerchant(Merchant merchant) {
      this.merchant = merchant;
   }

   /**
    * Information about the sender of this reversal.
    **/
   public VoucherReversal sender(Institution sender) {
      this.sender = sender;
      return this;
   }

   @ApiModelProperty(required = true, value = "Information about the sender of this reversal.")
   @JsonProperty("sender")
   public Institution getSender() {
      return sender;
   }

   public void setSender(Institution sender) {
      this.sender = sender;
   }

   /**
    * Information about the processor who should process this reversal. This must be populated if present in the VoucherResponse.
    **/
   public VoucherReversal processor(Institution processor) {
      this.processor = processor;
      return this;
   }

   @ApiModelProperty(value = "Information about the processor who should process this reversal. This must be populated if present in the VoucherResponse.")
   @JsonProperty("processor")
   public Institution getProcessor() {
      return processor;
   }

   public void setProcessor(Institution processor) {
      this.processor = processor;
   }

   /**
    * Information about the vendor who should process this reversal. This must be populated if present in the VoucherResponse.
    **/
   public VoucherReversal vendor(Institution vendor) {
      this.vendor = vendor;
      return this;
   }

   @ApiModelProperty(required = true, value = "Information about the vendor who should process this request. This must be populated if present in the VoucherResponse.")
   @JsonProperty("vendor")
   public Institution getVendor() {
      return vendor;
   }

   public void setVendor(Institution vendor) {
      this.vendor = vendor;
   }

   /**
    * The date and time of the reversal as recorded by the sender. The format shall be as defined for date-time in [RFC
    * 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional
    * time-secfrac be included up to millisecond precision.
    **/
   public VoucherReversal reversalTime(String reversalTime) {
      this.reversalTime = reversalTime;
      return this;
   }

   @ApiModelProperty(required = true, value = "The date and time of the reversal as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision.")
   @JsonProperty("reversalTime")
   public String getReversalTime() {
      return reversalTime;
   }

   public void setReversalTime(String reversalTime) {
      this.reversalTime = reversalTime;
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
      return Objects.equals(reversalId, voucherReversal.reversalId)
            && Objects.equals(merchant, voucherReversal.merchant) && Objects.equals(sender, voucherReversal.sender)
            && Objects.equals(processor, voucherReversal.processor) && Objects.equals(vendor, voucherReversal.vendor)
            && Objects.equals(reversalTime, voucherReversal.reversalTime)
            && Objects.equals(voucherRequest, voucherReversal.voucherRequest);
   }

   @Override
   public int hashCode() {
      return Objects.hash(reversalId, merchant, sender, processor, vendor, reversalTime, voucherRequest);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class VoucherReversal {\n");

      sb.append("    reversalId: ").append(toIndentedString(reversalId)).append("\n");
      sb.append("    merchant: ").append(toIndentedString(merchant)).append("\n");
      sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
      sb.append("    processor: ").append(toIndentedString(processor)).append("\n");
      sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
      sb.append("    reversalTime: ").append(toIndentedString(reversalTime)).append("\n");
      sb.append("    voucherRequest: ").append(toIndentedString(voucherRequest)).append("\n");
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
