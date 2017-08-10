package io.electrum.airtime.api.model;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.Institution;
import io.electrum.vas.model.SlipData;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Information about the voucher provisioned.
 **/

@ApiModel(description = "Information about the voucher provisioned.")
public class VoucherResponse extends Transaction {

   private Amounts amounts = null;
   private Product responseProduct = null;
   private Voucher voucher = null;
   private SlipData slipData = null;

   /**
    * If the product identified by the product field is not a fixed price product then the amounts field indicates the
    * value of the product in the response.
    **/
   public VoucherResponse amounts(Amounts amounts) {
      this.amounts = amounts;
      return this;
   }

   @ApiModelProperty(required = false, value = "If the product identified by the product field is not a fixed price "
         + "product then the amounts field indicates the value of the product in the response.")
   @JsonProperty("amounts")
   @Valid
   public Amounts getAmounts() {
      return amounts;
   }

   public void setAmounts(Amounts amounts) {
      this.amounts = amounts;
   }

   /**
    * The product for which the voucher was provisioned. This is assumed to be the product requested if this is absent.
    **/
   public VoucherResponse responseProduct(Product responseProduct) {
      this.responseProduct = responseProduct;
      return this;
   }

   @ApiModelProperty(value = "The product for which the voucher was provisioned. This is assumed to be the product "
         + "requested if this is absent.")
   @JsonProperty("responseProduct")
   @Valid
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

   @ApiModelProperty(required = true, value = "The voucher provisioned if the vendor processed the request "
         + "successfully.")
   @JsonProperty("voucher")
   @NotNull
   @Valid
   public Voucher getVoucher() {
      return voucher;
   }

   public void setVoucher(Voucher voucher) {
      this.voucher = voucher;
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
   @ApiModelProperty(required = true, value = "Data relating to the sender of the VoucherRequest.")
   @JsonProperty("client")
   @NotNull
   public Institution getClient() {
      return client;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class VoucherResponse {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    responseProduct: ").append(Utils.toIndentedString(responseProduct)).append("\n");
      sb.append("    voucher: ").append(Utils.toIndentedString(voucher)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
