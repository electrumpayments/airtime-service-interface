package io.electrum.airtime.api.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.SlipData;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A response to a successful purchase of an airtime product.
 **/

@ApiModel(description = "A response to a successful request for an airtime product.")
public class PurchaseResponse extends Transaction {

   private Amounts amounts = null;
   private Product product = null;
   private Msisdn msisdn = null;
   private Voucher voucher = null;
   private SlipData slipData = null;

   /**
    * If the product identified by the product field is not a fixed price product then the amounts field indicates the
    * value of the product referred to.
    **/
   public PurchaseResponse amounts(Amounts amounts) {
      this.amounts = amounts;
      return this;
   }

   @ApiModelProperty(required = false, value = "If the product identified by the product field is not a fixed price "
         + "product then the amounts field indicates the value of the product referred to.")
   @JsonProperty("amounts")
   @Valid
   public Amounts getAmounts() {
      return amounts;
   }

   public void setAmounts(Amounts amounts) {
      this.amounts = amounts;
   }

   /**
    * A description of the product requested.
    **/
   public PurchaseResponse product(Product product) {
      this.product = product;
      return this;
   }

   @ApiModelProperty(required = true, value = "A description of the product requested.")
   @JsonProperty("product")
   @NotNull
   @Valid
   public Product getProduct() {
      return product;
   }

   public void setProduct(Product product) {
      this.product = product;
   }

   /**
    * The Msisdn of the customer who will use the product specified.
    **/
   public PurchaseResponse msisdn(Msisdn msisdn) {
      this.msisdn = msisdn;
      return this;
   }

   @ApiModelProperty(value = "The Msisdn of the customer who will use the product requested.")
   @JsonProperty("msisdn")
   @Valid
   public Msisdn getMsisdn() {
      return msisdn;
   }

   public void setMsisdn(Msisdn msisdn) {
      this.msisdn = msisdn;
   }

   /**
    * In the case of a PIN based product, this details the voucher to be redeemed for the requested product.
    **/
   public PurchaseResponse voucher(Voucher voucher) {
      this.voucher = voucher;
      return this;
   }

   @ApiModelProperty(value = "In the case of a PIN based product, this details the voucher to be redeemed for the requested product.")
   @JsonProperty("voucher")
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
   public PurchaseResponse slipData(SlipData slipData) {
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
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PurchaseRequest {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append("\n");
      sb.append("    product: ").append(Utils.toIndentedString(product)).append("\n");
      sb.append("    msisdn: ").append(Utils.toIndentedString(msisdn)).append("\n");
      sb.append("    voucher: ").append(Utils.toIndentedString(voucher)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
