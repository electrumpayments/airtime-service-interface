package io.electrum.airtime.api.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information about the voucher provisioned.
 **/

@ApiModel(description = "Information about the voucher provisioned.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-01T07:39:12.071Z")
public class VoucherResponse {

   private String voucherId = null;
   private Product responseProduct = null;
   private Voucher voucher = null;
   private String requestTime = null;
   private Merchant merchant = null;
   private Institution sender = null;
   private Institution processor = null;
   private Institution vendor = null;
   private SlipData slipData = null;

   /**
    * A unique identifier generated by the client representing a specific voucher request.
    **/
   public VoucherResponse voucherId(String voucherId) {
      this.voucherId = voucherId;
      return this;
   }

   @ApiModelProperty(required = true, value = "A unique identifier generated by the client representing a specific voucher request.")
   @JsonProperty("voucherId")
   public String getVoucherId() {
      return voucherId;
   }

   public void setVoucherId(String voucherId) {
      this.voucherId = voucherId;
   }

   /**
    * The product for which the voucher was provisioned. This is assumed to be the product requested if this is absent.
    **/
   public VoucherResponse responseProduct(Product responseProduct) {
      this.responseProduct = responseProduct;
      return this;
   }

   @ApiModelProperty(value = "The product for which the voucher was provisioned. This is assumed to be the product requested if this is absent.")
   @JsonProperty("responseProduct")
   public Product getResponseProduct() {
      return responseProduct;
   }

   public void setResponseProduct(Product responseProduct) {
      this.responseProduct = responseProduct;
   }

   /**
    * The voucher provisioned if the vendor processed the request successfully.
    **/
   public VoucherResponse voucher(Voucher voucher) {
      this.voucher = voucher;
      return this;
   }

   @ApiModelProperty(required = true, value = "The voucher provisioned if the vendor processed the request successfully.")
   @JsonProperty("voucher")
   public Voucher getVoucher() {
      return voucher;
   }

   public void setVoucher(Voucher voucher) {
      this.voucher = voucher;
   }

   /**
    * The date and time of the request as recorded by the sender. The format shall be as defined for date-time in [RFC
    * 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional
    * time-secfrac be included up to millisecond precision.
    **/
   public VoucherResponse requestTime(String requestTime) {
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
    * Copied from the voucher request.
    **/
   public VoucherResponse merchant(Merchant merchant) {
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
   public VoucherResponse sender(Institution sender) {
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
    * Information about the processor with whom the merchant must settle. This must be populated if the merchant settles with an entity other than the vendor and the request reached the processor.
    **/
   public VoucherResponse processor(Institution processor) {
      this.processor = processor;
      return this;
   }

   @ApiModelProperty(required = true, value = "Information about the processor with whom the merchant must settle. This must be populated if the merchant settles with an entity other than the vendor and the request reached the processor.")
   @JsonProperty("processor")
   public Institution getProcessor() {
      return processor;
   }

   public void setProcessor(Institution processor) {
      this.processor = processor;
   }

   /**
    * Information about the vendor who ultimately processed the voucher request. This must be populated if the request
    * reached the vendor.
    **/
   public VoucherResponse vendor(Institution receiver) {
      this.vendor = receiver;
      return this;
   }

   @ApiModelProperty(required = true, value = "Information about the vendor who ultimately processed the voucher reqeust. This must be populated if the request reached the vendor.")
   @JsonProperty("vendor")
   public Institution getVendor() {
      return vendor;
   }

   public void setVendor(Institution vendor) {
      this.vendor = vendor;
   }

   /**
    * Data to be printed on the slip in addition to the voucher instructions.
    **/
   public VoucherResponse slipData(SlipData slipData) {
      this.slipData = slipData;
      return this;
   }

   @ApiModelProperty(value = "Data to be printed on the slip in addition to the voucher instructions.")
   @JsonProperty("slipData")
   public SlipData getSlipData() {
      return slipData;
   }

   public void setSlipData(SlipData slipData) {
      this.slipData = slipData;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      VoucherResponse voucherResponse = (VoucherResponse) o;
      return Objects.equals(voucherId, voucherResponse.voucherId)
            && Objects.equals(responseProduct, voucherResponse.responseProduct)
            && Objects.equals(voucher, voucherResponse.voucher)
            && Objects.equals(requestTime, voucherResponse.requestTime)
            && Objects.equals(merchant, voucherResponse.merchant) && Objects.equals(sender, voucherResponse.sender)
            && Objects.equals(processor, voucherResponse.processor) && Objects.equals(vendor, voucherResponse.vendor)
            && Objects.equals(slipData, voucherResponse.slipData);
   }

   @Override
   public int hashCode() {
      return Objects.hash(voucherId, responseProduct, voucher, requestTime, merchant, sender, processor, vendor, slipData);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class VoucherResponse {\n");

      sb.append("    voucherId: ").append(toIndentedString(voucherId)).append("\n");
      sb.append("    responseProduct: ").append(toIndentedString(responseProduct)).append("\n");
      sb.append("    voucher: ").append(toIndentedString(voucher)).append("\n");
      sb.append("    requestTime: ").append(toIndentedString(requestTime)).append("\n");
      sb.append("    merchant: ").append(toIndentedString(merchant)).append("\n");
      sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
      sb.append("    processor: ").append(toIndentedString(processor)).append("\n");
      sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
      sb.append("    slipData: ").append(toIndentedString(slipData)).append("\n");
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
