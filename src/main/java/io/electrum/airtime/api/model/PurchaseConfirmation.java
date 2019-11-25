package io.electrum.airtime.api.model;

import io.electrum.vas.Utils;
import io.electrum.vas.model.TenderAdvice;
import io.swagger.annotations.ApiModel;

/**
 * Confirm that a previous {@link PurchaseRequest} has completed successfully at the POS.
 **/

@ApiModel(description = "Confirm that a previous {@link PurchaseRequest} has completed successfully at the POS.")
public class PurchaseConfirmation extends TenderAdvice {

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PurchaseConfirmation {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append('\n');
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append('\n');
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append('\n');
      sb.append("    time: ").append(Utils.toIndentedString(time)).append('\n');
      sb.append("    tenders: ").append(Utils.toIndentedString(tenders)).append('\n');
      sb.append('}');
      return sb.toString();
   }
}
