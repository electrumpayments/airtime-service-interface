package io.electrum.airtime.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data that may be printed on the customer slip for information purposes.
 **/

@ApiModel(description = "Data that may be printed on the customer slip for information purposes.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-01T07:39:12.071Z")
public class SlipData {

   private List<String> messageLines = new ArrayList<String>();
   private String vendorReference = null;

   /**
    * An array of free text lines to be printed on the customer slip.
    **/
   public SlipData messageLines(List<String> messageLines) {
      this.messageLines = messageLines;
      return this;
   }

   @ApiModelProperty(value = "An array of free text lines to be printed on the customer slip.")
   @JsonProperty("messageLines")
   public List<String> getMessageLines() {
      return messageLines;
   }

   public void setMessageLines(List<String> messageLines) {
      this.messageLines = messageLines;
   }

   /**
    * An identifier that uniquely references the request associated with the slip. This is printed on the customer slip
    * and uniquely identifies the voucher purchase on the vendor's system. This value is used by the customer to
    * identify a voucher purchase with the vendor. It is thus important that this number can be used to locate a
    * specific voucher purchase at some time after the voucher has been provisioned.
    **/
   public SlipData vendorReference(String vendorReference) {
      this.vendorReference = vendorReference;
      return this;
   }

   @ApiModelProperty(required = true, value = "An identifier that uniquely references the request associated with the slip. This is printed on the customer slip and uniquely identifies the voucher purchase on the vendor's system. This value is used by the customer to identify a voucher purchase with the vendor. It is thus important that this number can be used to locate a specific voucher purchase at some time after the voucher has been provisioned.")
   @JsonProperty("vendorReference")
   @Pattern(regexp = "[0-9A-Z]{1,20}")
   @NotNull
   public String getVendorReference() {
      return vendorReference;
   }

   public void setVendorReference(String vendorReference) {
      this.vendorReference = vendorReference;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      SlipData slipData = (SlipData) o;
      return Objects.equals(messageLines, slipData.messageLines)
            && Objects.equals(vendorReference, slipData.vendorReference);
   }

   @Override
   public int hashCode() {
      return Objects.hash(messageLines, vendorReference);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class SlipData {\n");

      sb.append("    messageLines: ").append(toIndentedString(messageLines)).append("\n");
      sb.append("    vendorReference: ").append(toIndentedString(vendorReference)).append("\n");
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
