package io.electrum.airtime.api.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicReversal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information about the voucher provision being reversed.
 **/

@ApiModel(description = "Information about the voucher provision being reversed.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-01T07:39:12.071Z")
public class VoucherReversal extends BasicReversal {
   private VoucherRequest voucherRequest = null;

   /**
   **/
   public VoucherReversal voucherRequest(VoucherRequest voucherRequest) {
      this.voucherRequest = voucherRequest;
      return this;
   }

   @ApiModelProperty(required = true, value = "The original Voucher Request being reversed.")
   @JsonProperty("voucherRequest")
   @NotNull
   public VoucherRequest getVoucherRequest() {
      return voucherRequest;
   }

   public void setVoucherRequest(VoucherRequest voucherRequest) {
      this.voucherRequest = voucherRequest;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class VoucherReversal {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    reversalReason: ").append(Utils.toIndentedString(reversalReason)).append("\n");
      sb.append("    voucherRequest: ").append(Utils.toIndentedString(voucherRequest)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
