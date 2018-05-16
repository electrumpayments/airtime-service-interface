package io.electrum.airtime.api.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.PaymentMethod;
import io.electrum.vas.model.Tender;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A request to purchase an airtime product. This may be for airtime, data or SMS products or a combination. Purchase
 * requests may be for PIN based or PIN-less products.
 **/

@ApiModel(description = "A request for an airtime product. This may be for airtime, data or SMS products or a combination. Airtime requests may be for PIN based or PIN-less products.")
public class PurchaseRequest extends Transaction {

   private Product product = null;
   private List<Tender> tenders = null;
   private List<PaymentMethod> paymentMethods = null;
   private MSISDN recipientMsisdn = null;
   private MSISDN senderMsisdn = null;

   /**
    * A description of the product requested.
    **/
   public PurchaseRequest product(Product product) {
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
    * An array of tenders used to pay for the transaction
    **/
   public PurchaseRequest tenders(List<Tender> tenders) {
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

   /**
    * The MSISDN of the customer who will receive or make use of the product requested.
    **/
   public PurchaseRequest recipientMsisdn(MSISDN recipientMsisdn) {
      this.recipientMsisdn = recipientMsisdn;
      return this;
   }

   @ApiModelProperty(value = "The MSISDN of the customer who will receive or make use of the product requested.")
   @JsonProperty("recipientMsisdn")
   @Valid
   public MSISDN getRecipientMsisdn() {
      return recipientMsisdn;
   }

   public void setRecipientMsisdn(MSISDN recipientMsisdn) {
      this.recipientMsisdn = recipientMsisdn;
   }

   /**
    * The MSISDN of the customer who purchasing product requested. This field may be mandatory for certain providers
    * especially in the case of international purchases.
    **/
   public PurchaseRequest senderMsisdn(MSISDN senderMsisdn) {
      this.senderMsisdn = senderMsisdn;
      return this;
   }

   @ApiModelProperty(value = "The MSISDN of the customer who purchasing product requested. This field may be mandatory for certain providers especially in the case of international purchases.")
   @JsonProperty("senderMsisdn")
   @Valid
   public MSISDN getSenderMsisdn() {
      return senderMsisdn;
   }

   public void setSenderMsisdn(MSISDN senderMsisdn) {
      this.senderMsisdn = senderMsisdn;
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
      sb.append("    product: ").append(Utils.toIndentedString(product)).append("\n");
      sb.append("    tenders: ").append(Utils.toIndentedString(tenders)).append("\n");
      sb.append("    paymentMethods: ").append(Utils.toIndentedString(paymentMethods)).append("\n");
      sb.append("    recipientMsisdn: ").append(Utils.toIndentedString(recipientMsisdn)).append("\n");
      sb.append("    senderMsisdn: ").append(Utils.toIndentedString(senderMsisdn)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
