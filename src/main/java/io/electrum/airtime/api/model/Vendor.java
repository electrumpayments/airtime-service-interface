package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Specifically describes the vendor of the airtime voucher.
 **/

@ApiModel(description = "Specifically describes the vendor of the airtime voucher.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-26T12:50:43.313Z")
public class Vendor   {
  
  private String id = null;
  private String name = null;
  private String reference = null;

  /**
   * The vendor's ID as assigned by Electrum.
   **/
  public Vendor id(String id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "The vendor's ID as assigned by Electrum.")
  @JsonProperty("id")
  @Pattern(regexp = "[0-9]{1,11}")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The vendor's name.
   **/
  public Vendor name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "The vendor's name.")
  @JsonProperty("name")
  @Length(min = 1, max = 40)
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * The vendor's own reference for the request message.
   **/
  public Vendor reference(String reference) {
    this.reference = reference;
    return this;
  }

  
  @ApiModelProperty(value = "The vendor's own reference for the request message.")
  @JsonProperty("reference")
  @Pattern(regexp = "[A-Z0-9]{1,20}")
  public String getReference() {
    return reference;
  }
  public void setReference(String reference) {
    this.reference = reference;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vendor vendor = (Vendor) o;
    return Objects.equals(id, vendor.id) &&
        Objects.equals(name, vendor.name) &&
        Objects.equals(reference, vendor.reference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, reference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Vendor {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
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

