package io.electrum.airtime.api.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information about the voucher provision request.
 **/

@ApiModel(description = "Information about the voucher provision request.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-01T07:39:12.071Z")
public class VoucherRequest {

   private String voucherId = null;
   private Product product = null;
   private String requestTime = null;
   private Institution sender = null;
   private Merchant merchant = null;
   private Institution processor = null;
   private Institution vendor = null;

   /**
    * The randomly generated UUID identifying this voucher request, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122). This must be the same as the voucherId path parameter.
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
    * The product for which the voucher should be provisioned.
    **/
   public VoucherRequest product(Product product) {
      this.product = product;
      return this;
   }

   @ApiModelProperty(required = true, value = "The product for which the voucher should be provisioned.")
   @JsonProperty("product")
   public Product getProduct() {
      return product;
   }

   public void setProduct(Product product) {
      this.product = product;
   }

   /**
    * The date and time of the request as recorded by the sender. The format shall be as defined for date-time in [RFC
    * 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional
    * time-secfrac be included up to millisecond precision.
    **/
   public VoucherRequest requestTime(String requestTime) {
      this.requestTime = requestTime;
      return this;
   }

   @ApiModelProperty(required = true, value = "The date and time of the request as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision.")
   @JsonProperty("requestTime")
   public String getRequestTime() {
      return requestTime;
   }

   public void setRequestTime(String requestTime) {
      this.requestTime = requestTime;
   }

   /**
    * Information about the merchant who originated this request.
    **/
   public VoucherRequest merchant(Merchant merchant) {
      this.merchant = merchant;
      return this;
   }

   @ApiModelProperty(required = true, value = "Information about the merchant who originated this request.")
   @JsonProperty("merchant")
   public Merchant getMerchant() {
      return merchant;
   }

   public void setMerchant(Merchant merchant) {
      this.merchant = merchant;
   }

   /**
    * Information about the sender of this request.
    **/
   public VoucherRequest sender(Institution sender) {
      this.sender = sender;
      return this;
   }

   @ApiModelProperty(required = true, value = "Information about the sender of this request.")
   @JsonProperty("sender")
   public Institution getSender() {
      return sender;
   }

   public void setSender(Institution sender) {
      this.sender = sender;
   }

   /**
    * Information about the processor who should process this request.
    **/
   public VoucherRequest processor(Institution processor) {
      this.processor = processor;
      return this;
   }

   @ApiModelProperty(value = "Information about the processor who should process this request.")
   @JsonProperty("processor")
   public Institution getProcessor() {
      return processor;
   }

   public void setProcessor(Institution processor) {
      this.processor = processor;
   }

   /**
    * Information about the vendor who should process this request.
    **/
   public VoucherRequest vendor(Institution vendor) {
      this.vendor = vendor;
      return this;
   }

   @ApiModelProperty(required = true, value = "Information about the vendor who should process this request.")
   @JsonProperty("vendor")
   public Institution getVendor() {
      return vendor;
   }

   public void setVendor(Institution vendor) {
      this.vendor = vendor;
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
      return Objects.equals(voucherId, voucherRequest.voucherId) && Objects.equals(product, voucherRequest.product)
            && Objects.equals(requestTime, voucherRequest.requestTime) 
            && Objects.equals(merchant, voucherRequest.merchant) && Objects.equals(sender, voucherRequest.sender)
            && Objects.equals(processor, voucherRequest.processor) && Objects.equals(vendor, voucherRequest.vendor);
   }

   @Override
   public int hashCode() {
      return Objects.hash(voucherId, product, requestTime, merchant, sender, processor, vendor);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class VoucherRequest {\n");

      sb.append("    voucherId: ").append(toIndentedString(voucherId)).append("\n");
      sb.append("    product: ").append(toIndentedString(product)).append("\n");
      sb.append("    requestTime: ").append(toIndentedString(requestTime)).append("\n");
      sb.append("    merchant: ").append(toIndentedString(merchant)).append("\n");
      sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
      sb.append("    processor: ").append(toIndentedString(processor)).append("\n");
      sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
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
