package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.airtime.api.model.Institution;
import io.electrum.airtime.api.model.Merchant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * The Sender object encapsulates data relating to the originator of the transaction.
 **/

@ApiModel(description = "The Sender object encapsulates data relating to the originator of the transaction.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T12:50:43.313Z")
public class Sender   {
  
  private Institution institution = null;
  private String referenceNumber = null;
  private Merchant merchant = null;

  /**
   * The institution originating the request, as issued by Electrum.
   **/
  public Sender institution(Institution institution) {
    this.institution = institution;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "The institution originating the request, as issued by Electrum.")
  @JsonProperty("institution")
  public Institution getInstitution() {
    return institution;
  }
  public void setInstitution(Institution institution) {
    this.institution = institution;
  }

  /**
   * A reference number useful to the sender for identifying transactions, also known as a retrieval reference number.
   **/
  public Sender referenceNumber(String referenceNumber) {
    this.referenceNumber = referenceNumber;
    return this;
  }

  
  @ApiModelProperty(value = "A reference number useful to the sender for identifying transactions, also known as a retrieval reference number.")
  @JsonProperty("referenceNumber")
  @Pattern(regexp = "[0-9A-Za-z ]{1,12}")
  public String getReferenceNumber() {
    return referenceNumber;
  }
  public void setReferenceNumber(String referenceNumber) {
    this.referenceNumber = referenceNumber;
  }

  /**
   * Merchant data.
   **/
  public Sender merchant(Merchant merchant) {
    this.merchant = merchant;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Merchant data.")
  @JsonProperty("merchant")
  public Merchant getMerchant() {
    return merchant;
  }
  public void setMerchant(Merchant merchant) {
    this.merchant = merchant;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sender sender = (Sender) o;
    return Objects.equals(institution, sender.institution) &&
        Objects.equals(referenceNumber, sender.referenceNumber) &&
        Objects.equals(merchant, sender.merchant);
  }

  @Override
  public int hashCode() {
    return Objects.hash(institution, referenceNumber, merchant);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sender {\n");
    
    sb.append("    institution: ").append(toIndentedString(institution)).append("\n");
    sb.append("    referenceNumber: ").append(toIndentedString(referenceNumber)).append("\n");
    sb.append("    merchant: ").append(toIndentedString(merchant)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

