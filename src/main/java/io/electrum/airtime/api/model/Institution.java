package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Originating, acquiring, processing, or receiving institution details.
 **/

@ApiModel(description = "Originating, acquiring, processing, or receiving institution details.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-01T07:39:12.071Z")
public class Institution {

   private String id = null;
   private String name = null;
   private String reference = null;

   /**
    * The institution's ID as assigned by Electrum.
    **/
   public Institution id(String id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "The institution's ID as assigned by Electrum.")
   @JsonProperty("id")
   @Pattern(regexp = "[0-9]{1,11}")
   @NotNull
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   /**
    * The institutions's name.
    **/
   public Institution name(String name) {
      this.name = name;
      return this;
   }

   @ApiModelProperty(required = true, value = "The institutions's name.")
   @JsonProperty("name")
   @Length(min = 1, max = 40)
   @NotNull
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   /**
    * The vendor's own reference for the request message.
    **/
   public Institution reference(String reference) {
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
      Institution institution = (Institution) o;
      return Objects.equals(id, institution.id) && Objects.equals(name, institution.name) && Objects.equals(reference, institution.reference);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, name, reference);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Institution {\n");

      sb.append("    id: ").append(toIndentedString(id)).append("\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
      sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
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
