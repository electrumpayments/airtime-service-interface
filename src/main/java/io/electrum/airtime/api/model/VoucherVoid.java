package io.electrum.airtime.api.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.BasicReversal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information about the voucher provision being voided. This object refers to a specific voucher which was previously
 * successfully provisioned.
 **/

@ApiModel(description = "Information about the voucher provision being voided. This object refers to a specific voucher which was previously successfully provisioned.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-01T07:39:12.071Z")
public class VoucherVoid extends BasicReversal {
   
   private Voucher voucher = null;

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
   @NotNull
   public Voucher getVoucher() {
      return voucher;
   }

   public void setVoucher(Voucher voucher) {
      this.voucher = voucher;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class VoucherVoid {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    reversalReason: ").append(Utils.toIndentedString(reversalReason)).append("\n");
      sb.append("    voucher: ").append(Utils.toIndentedString(voucher)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
