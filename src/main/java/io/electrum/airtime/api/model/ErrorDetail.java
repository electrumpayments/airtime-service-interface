package io.electrum.airtime.api.model;

import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The ErrorDetail provides information about the error encountered if a provision request could not be successfully
 * processed. In the case of timeouts or system malfunctions the ErrorDetail may not be present.
 **/

@ApiModel(description = "The ErrorDetail provides information about the error encountered if a provision request could not be successfully processed. In the case of timeouts or system malfunctions the ErrorDetail may not be present.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-08-01T07:39:12.071Z")
public class ErrorDetail {

   public enum ErrorTypeEnum {
      DUPLICATE_RECORD("DUPLICATE_RECORD"),
      FORMAT_ERROR("FORMAT_ERROR"),
      FUNCTION_NOT_SUPPORTED("FUNCTION_NOT_SUPPORTED"),
      GENERAL_ERROR("GENERAL_ERROR"),
      INVALID_AMOUNT("INVALID_AMOUNT"),
      INVALID_PRODUCT("INVALID_PRODUCT"),
      ROUTING_ERROR("ROUTING_ERROR"),
      TRANSACTION_NOT_SUPPORTED("TRANSACTION_NOT_SUPPORTED"),
      UNABLE_TO_LOCATE_RECORD("UNABLE_TO_LOCATE_RECORD"),
      UPSTREAM_UNAVAILABLE("UPSTREAM_UNAVAILABLE"),
      VOUCHER_ALREADY_CONFIRMED("VOUCHER_ALREADY_CONFIRMED"),
      VOUCHER_ALREADY_VOIDED("VOUCHER_ALREADY_VOIDED");

      private String value;

      ErrorTypeEnum(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return value;
      }
   }

   private ErrorTypeEnum errorType = null;
   private String errorMessage = null;

   /**
    * The type of error that occured.
    **/
   public ErrorDetail errorType(ErrorTypeEnum errorType) {
      this.errorType = errorType;
      return this;
   }

   @ApiModelProperty(required = true, value = "The type of error that occured.")
   @JsonProperty("errorType")
   public ErrorTypeEnum getErrorType() {
      return errorType;
   }

   public void setErrorType(ErrorTypeEnum errorType) {
      this.errorType = errorType;
   }

   /**
    * A short description of the error.
    **/
   public ErrorDetail errorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
      return this;
   }

   @ApiModelProperty(value = "A short description of the error.")
   @JsonProperty("errorMessage")
   @Length(max = 20)
   public String getErrorMessage() {
      return errorMessage;
   }

   public void setErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ErrorDetail errorDetail = (ErrorDetail) o;
      return Objects.equals(errorType, errorDetail.errorType) && Objects.equals(errorMessage, errorDetail.errorMessage);
   }

   @Override
   public int hashCode() {
      return Objects.hash(errorType, errorMessage);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ErrorDetail {\n");

      sb.append("    errorType: ").append(toIndentedString(errorType)).append("\n");
      sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
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
