package io.electrum.airtime.api.model;

import io.electrum.vas.Utils;
import io.electrum.vas.interfaces.HasAmounts;
import io.electrum.vas.interfaces.HasPaymentMethods;
import io.electrum.vas.model.Amounts;
import io.electrum.vas.model.PaymentMethod;
import io.electrum.vas.model.Tender;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Information about the voucher provision request.
 **/

@ApiModel(description = "Information about the voucher provision request.")
public class VoucherRequest extends Transaction implements HasAmounts, HasPaymentMethods {

   private Amounts amounts = null;
   private Product product = null;
   private List<Tender> tenders = null;
   private List<PaymentMethod> paymentMethods = null;

   /**
    * If the product identified by the product field is not a fixed price product then the amounts field indicates the
    * value of the product referred to.
    **/
   public VoucherRequest amounts(Amounts amounts) {
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
    * The product for which the voucher should be provisioned.
    **/
   public VoucherRequest product(Product product) {
      this.product = product;
      return this;
   }

   @ApiModelProperty(required = true, value = "The product for which the voucher should be provisioned.")
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
    * An array of tenders used to pay for the transaction
    **/
   public VoucherRequest tenders(List<Tender> tenders) {
      this.tenders = tenders;
      return this;
   }

   @ApiModelProperty(required = false, value = "An array of tenders used to pay for the transaction. This is used "
         + "if payment is tendered at the point of sale. A Tender differs from a PaymentMethod in that the former "
         + "represents a payment that has already been collected at the point of sale, whereas the latter represents "
         + "a payment that still needs to be collected from a third party.")
   @JsonProperty("tenders")
   public List<Tender> getTenders() {
      return tenders;
   }

   public void setTenders(List<Tender> tenders) {
      this.tenders = tenders;
   }

   @ApiModelProperty(required = false, value = "An array of payment methods to be used as payment for the "
         + "transaction. This is used if payment is not tendered at the point of sale, but is effected through one "
         + "or more calls to third party payment providers as part of the request. A PaymentMethod differs from a "
         + "Tender in that the former represents payment that still needs to be collected from a third party, "
         + "whereas the latter represents payment that has already been collected at the point of sale.")
   @JsonProperty("paymentMethods")
   public List<PaymentMethod> getPaymentMethods() {
      return paymentMethods;
   }

   public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
      this.paymentMethods = paymentMethods;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class VoucherRequest {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append('\n');
      sb.append("    product: ").append(Utils.toIndentedString(product)).append('\n');
      sb.append("    time: ").append(Utils.toIndentedString(time)).append('\n');
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append('\n');
      sb.append("    client: ").append(Utils.toIndentedString(client)).append('\n');
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append('\n');
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append('\n');
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append('\n');
      sb.append("    tenders: ").append(Utils.toIndentedString(tenders)).append('\n');
      sb.append("    paymentMethods: ").append(Utils.toIndentedString(paymentMethods)).append('\n');
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append('\n');
      sb.append('}');
      return sb.toString();
   }
}
