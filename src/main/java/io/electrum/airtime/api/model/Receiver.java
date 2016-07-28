package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.airtime.api.model.Institution;
import io.electrum.airtime.api.model.Vendor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * The Receiver object encapsulates data relating to the receiver of the transaction.
 **/

@ApiModel(description = "The Receiver object encapsulates data relating to the receiver of the transaction.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T12:50:43.313Z")
public class Receiver   {
  
  private Institution institution = null;
  private String referenceNumber = null;
  private Vendor vendor = null;

  /**
   * The institution which processed the request, as issued by Electrum.
   **/
  public Receiver institution(Institution institution) {
    this.institution = institution;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "The institution which processed the request, as issued by Electrum.")
  @JsonProperty("institution")
  public Institution getInstitution() {
    return institution;
  }
  public void setInstitution(Institution institution) {
    this.institution = institution;
  }

  /**
   * A reference number useful to the receiver for identifying transactions, also known as a retrieval reference number.
   **/
  public Receiver referenceNumber(String referenceNumber) {
    this.referenceNumber = referenceNumber;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "A reference number useful to the receiver for identifying transactions, also known as a retrieval reference number.")
  @JsonProperty("referenceNumber")
  @Pattern(regexp = "[0-9A-Za-z ]{1,12}")
  public String getReferenceNumber() {
    return referenceNumber;
  }
  public void setReferenceNumber(String referenceNumber) {
    this.referenceNumber = referenceNumber;
  }

  /**
   * The voucher vendor which ultimately processed the request. This is typically the mobile network operator.
   **/
  public Receiver vendor(Vendor vendor) {
    this.vendor = vendor;
    return this;
  }

  
  @ApiModelProperty(value = "The voucher vendor which ultimately processed the request. This is typically the mobile network operator.")
  @JsonProperty("vendor")
  public Vendor getVendor() {
    return vendor;
  }
  public void setVendor(Vendor vendor) {
    this.vendor = vendor;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Receiver receiver = (Receiver) o;
    return Objects.equals(institution, receiver.institution) &&
        Objects.equals(referenceNumber, receiver.referenceNumber) &&
        Objects.equals(vendor, receiver.vendor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(institution, referenceNumber, vendor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Receiver {\n");
    
    sb.append("    institution: ").append(toIndentedString(institution)).append("\n");
    sb.append("    referenceNumber: ").append(toIndentedString(referenceNumber)).append("\n");
    sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
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

