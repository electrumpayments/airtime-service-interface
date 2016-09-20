package io.electrum.airtime.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicReversal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information about the voucher provision being reversed.
 **/

@ApiModel(description = "Information about the voucher provision being reversed.")
public class VoucherReversal extends BasicReversal {
   
   @Deprecated
   private VoucherRequest voucherRequest = null;

   @Deprecated
   public VoucherReversal voucherRequest(VoucherRequest voucherRequest) {
      this.voucherRequest = voucherRequest;
      return this;
   }

   /**
    * <p>
    * Deprecated: This field is redundant and has been deprecated. It has been 
    * preserved for backwards compatibility but should not be used. If present it 
    * will be ignored.
    * </p>
    * <p>
    * The original Voucher Request being reversed.
    * </p>
   **/
   @ApiModelProperty(value = "<p>Deprecated: This field is redundant and has been deprecated. It has been preserved for backwards compatibility but should not be used. If present it will be ignored.</p><p>The original Voucher Request being reversed.</p>")
   @JsonProperty("voucherRequest")
   @Deprecated
   public VoucherRequest getVoucherRequest() {
      return voucherRequest;
   }

   @Deprecated
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
