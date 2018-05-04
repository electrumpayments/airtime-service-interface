package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.electrum.vas.model.Institution;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * MSISDN related data.
 **/

@ApiModel(description = "MSISDN related data.")
public class MSISDN {

   private String msisdn = null;
   private String country = null;
   private Institution operator = null;

   /**
    * The Mobile Subscriber Integrated Services Digital Network-Number (MSISDN). This must conform to the ITU E.164
    * numbering plan (https://www.itu.int/rec/T-REC-E.164/en) e.g. 27821234567 for a South African number.
    **/
   public MSISDN msisdn(String msisdn) {
      this.msisdn = msisdn;
      return this;
   }

   @ApiModelProperty(required = true, value = "This must conform to the ITU E.164 numbering plan (https://www.itu.int/rec/T-REC-E.164/en) e.g. 27821234567 for a South African number.")
   @Pattern(regexp = "^\\+?[1-9]\\d{1,14}")
   @JsonProperty("msisdn")
   @NotNull
   public String getMsisdn() {
      return msisdn;
   }

   public void setMsisdn(String msisdn) {
      this.msisdn = msisdn;
   }

   public MSISDN country(String country) {
      this.country = country;
      return this;
   }

   /**
    * The country of the MSISDN expressed as an ISO 3166-1 Alpha-2 country code.
    * 
    * @return country
    **/
   @ApiModelProperty(value = "The country of the MSISDN expressed as an ISO 3166-1 Alpha-2 country code.")
   @JsonProperty("country")
   @Length(min = 2, max = 2)
   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   /**
    * The Mobile Network Operator (MNO) to whom the MSISDN belongs.
    **/
   public MSISDN operator(Institution operator) {
      this.operator = operator;
      return this;
   }

   @ApiModelProperty(value = "The Mobile Network Operator (MNO) to whom the MSISDN belongs.")
   @JsonProperty("operator")
   @Valid
   public Institution getOperator() {
      return operator;
   }

   public void setOperator(Institution operator) {
      this.operator = operator;
   }

   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      MSISDN msisdn = (MSISDN) o;
      return Objects.equals(this.msisdn, msisdn.msisdn) && Objects.equals(this.country, msisdn.country)
            && Objects.equals(this.operator, msisdn.operator);
   }

   @Override
   public int hashCode() {
      return Objects.hash(msisdn, country, operator);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MSISDN {\n");

      sb.append("    msisdn: ").append(Utils.toIndentedString(msisdn)).append("\n");
      sb.append("    country: ").append(Utils.toIndentedString(country)).append("\n");
      sb.append("    operator: ").append(Utils.toIndentedString(operator)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
