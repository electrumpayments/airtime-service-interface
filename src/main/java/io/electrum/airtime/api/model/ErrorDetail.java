package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

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
public class ErrorDetail implements Cloneable {

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
      VOUCHER_ALREADY_REVERSED("VOUCHER_ALREADY_REVERSED"),
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
   private Object detailMessage = null;

   /**
    * The type of error that occured.
    **/
   public ErrorDetail errorType(ErrorTypeEnum errorType) {
      this.errorType = errorType;
      return this;
   }

   @ApiModelProperty(required = true, value = "The type of error that occured.")
   @JsonProperty("errorType")
   @NotNull
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

   /**
    * A free form detailed description of a particular failure condition may optionally be supplied. The detailMessage
    * field is not intended to be processed programmatically but can optionally be used to better describe the error
    * encountered by the server.
    **/
   public ErrorDetail detailMessage(Object detailMessage) {
      this.detailMessage = detailMessage;
      return this;
   }

   @ApiModelProperty(value = "A free form detailed description of a particular failure condition may optionally be supplied. The detailMessage field is not intended to be processed programmatically but can optionally be used to better describe the error encountered by the server.")
   @JsonProperty("detailMessage")
   public Object getDetailMessage() {
      return detailMessage;
   }

   public void setDetailMessage(Object detailMessage) {
      this.detailMessage = detailMessage;
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
      return Objects.equals(errorType, errorDetail.errorType) && Objects.equals(errorMessage, errorDetail.errorMessage)
            && Objects.equals(detailMessage, errorDetail.detailMessage);
   }

   @Override
   public int hashCode() {
      return Objects.hash(errorType, errorMessage, detailMessage);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ErrorDetail {\n");

      sb.append("    errorType: ").append(toIndentedString(errorType)).append("\n");
      sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
      sb.append("    detailMessage: ").append(toIndentedString(detailMessage)).append("\n");
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
