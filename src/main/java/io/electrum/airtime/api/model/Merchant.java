package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Merchant related data. Identifies the originator of the request.
 **/

@ApiModel(description = "Merchant related data. Identifies the originator of the request.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-01T07:39:12.071Z")
public class Merchant {

   private String merchantType = null;
   private String merchantId = null;
   private String merchantName = null;
   private String terminalId = null;
   private Institution institution = null;

   /**
    * The assigned four digit merchant category code.
    **/
   public Merchant merchantType(String merchantType) {
      this.merchantType = merchantType;
      return this;
   }

   @ApiModelProperty(required = true, value = "The assigned four digit merchant category code.")
   @JsonProperty("merchantType")
   @Pattern(regexp = "[0-9]{4}")
   public String getMerchantType() {
      return merchantType;
   }

   public void setMerchantType(String merchantType) {
      this.merchantType = merchantType;
   }

   /**
    * The assigned merchant identifier. Also known as card acceptor ID.
    **/
   public Merchant merchantId(String merchantId) {
      this.merchantId = merchantId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The assigned merchant identifier. Also known as card acceptor ID.")
   @JsonProperty("merchantId")
   @Length(min = 15, max = 15)
   public String getMerchantId() {
      return merchantId;
   }

   public void setMerchantId(String merchantId) {
      this.merchantId = merchantId;
   }

   /**
    * The name of a merchant.
    **/
   public Merchant merchantName(String merchantName) {
      this.merchantName = merchantName;
      return this;
   }

   @ApiModelProperty(required = true, value = "The name of a merchant.")
   @JsonProperty("merchantName")
   public String getMerchantName() {
      return merchantName;
   }

   public void setMerchantName(String merchantName) {
      this.merchantName = merchantName;
   }

   /**
    * The ID that uniquely identifies each device or system in a merchant institution capable of sending requests.
    * Required for transactions initiated from physical card entry or point-of-sale devices.
    **/
   public Merchant terminalId(String terminalId) {
      this.terminalId = terminalId;
      return this;
   }

   @ApiModelProperty(value = "The ID that uniquely identifies each device or system in a merchant institution capable of sending requests. Required for transactions initiated from physical card entry or point-of-sale devices.")
   @JsonProperty("terminalId")
   @Pattern(regexp = "[a-zA-Z0-9]{8}")
   public String getTerminalId() {
      return terminalId;
   }

   public void setTerminalId(String terminalId) {
      this.terminalId = terminalId;
   }

   /**
    * The ID that uniquely identifies each device or system in a merchant institution capable of sending requests.
    * Required for transactions initiated from physical card entry or point-of-sale devices.
    **/
   public Merchant institution(Institution institution) {
      this.institution = institution;
      return this;
   }

   @ApiModelProperty(value = "The ID that uniquely identifies each device or system in a merchant institution capable of sending requests. Required for transactions initiated from physical card entry or point-of-sale devices.")
   @JsonProperty("institution")
   @Pattern(regexp = "[a-zA-Z0-9]{8}")
   public Institution getInstitution() {
      return institution;
   }

   public void setInstitution(Institution institution) {
      this.institution = institution;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Merchant merchant = (Merchant) o;
      return Objects.equals(merchantType, merchant.merchantType) && Objects.equals(merchantId, merchant.merchantId)
            && Objects.equals(merchantName, merchant.merchantName) && Objects.equals(terminalId, merchant.terminalId)
            && Objects.equals(institution, merchant.institution);
   }

   @Override
   public int hashCode() {
      return Objects.hash(merchantType, merchantId, merchantName, terminalId, institution);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Merchant {\n");

      sb.append("    merchantType: ").append(toIndentedString(merchantType)).append("\n");
      sb.append("    merchantId: ").append(toIndentedString(merchantId)).append("\n");
      sb.append("    merchantName: ").append(toIndentedString(merchantName)).append("\n");
      sb.append("    terminalId: ").append(toIndentedString(terminalId)).append("\n");
      sb.append("    institution: ").append(toIndentedString(institution)).append("\n");
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
