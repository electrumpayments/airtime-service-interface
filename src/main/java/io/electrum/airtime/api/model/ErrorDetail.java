package io.electrum.airtime.api.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents the outcome of a completed transaction
 **/
@ApiModel(description = "Represents the outcome of a completed transaction")
public class ErrorDetail {

   /**
    * Every failure must be classified into one of the following failure types
    */
   public enum ErrorType {
      DUPLICATE_RECORD("DUPLICATE_RECORD"),
      FORMAT_ERROR("FORMAT_ERROR"),
      FUNCTION_NOT_SUPPORTED("FUNCTION_NOT_SUPPORTED"),
      GENERAL_ERROR("GENERAL_ERROR"),
      INVALID_AMOUNT("INVALID_AMOUNT"),
      ROUTING_ERROR("ROUTING_ERROR"),
      TRANSACTION_NOT_SUPPORTED("TRANSACTION_NOT_SUPPORTED"),
      UNABLE_TO_LOCATE_RECORD("UNABLE_TO_LOCATE_RECORD"),
      UPSTREAM_UNAVAILABLE("UPSTREAM_UNAVAILABLE"),
      INVALID_PRODUCT("INVALID_PRODUCT"),
      ACCOUNT_ALREADY_SETTLED("ACCOUNT_ALREADY_SETTLED"),
      INVALID_MERCHANT("INVALID_MERCHANT"),
      OUT_OF_STOCK("OUT_OF_STOCK"),
      INVALID_AN32_TOKEN("INVALID_AN32_TOKEN"),
      DO_NOT_HONOR("DO_NOT_HONOR"),
      DECLINED_BY_MNO("DECLINED_BY_MNO"),
      INVALID_MSISDN("INVALID_MSISDN"),
      INVALID_LOYALTY_CARD("INVALID_LOYALTY_CARD");

      private String value;

      ErrorType(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   /**
    * The following request types are recognised
    */
   public enum RequestType {
      VOUCHER_REQUEST("VOUCHER_REQUEST"),
      VOUCHER_REVERSAL("VOUCHER_REVERSAL"),
      VOUCHER_CONFIRMATION("VOUCHER_CONFIRMATION"),
      VOUCHER_VOID("VOUCHER_VOID"),
      MSISDN_INFO_REQUEST("MSISDN_INFO_REQUEST"),
      PURCHASE_REQUEST("PURCHASE_REQUEST"),
      PURCHASE_CONFIRMATION("PURCHASE_CONFIRMATION"),
      PURCHASE_STATUS_REQUEST("PURCHASE_STATUS_REQUEST"),
      PURCHASE_REVERSAL("PURCHASE_REVERSAL");

      private String value;

      RequestType(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   private String id;
   private String originalId;
   private ErrorType errorType = null;
   private String errorMessage = null;
   private RequestType requestType = null;
   private Object detailMessage = null;
   private String providerErrorCode = null;
   private String providerErrorMsg = null;
   private String providerRef = null;

   /**
    * The randomly generated UUID identifying this errorDetail, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122)
    */
   public ErrorDetail id(String id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this errorDetail, as defined for"
         + " a variant 4 UUID in [RFC 4122](https://tools.ietf.org/html/rfc4122)")
   @JsonProperty("id")
   @NotNull
   @Length(max = 20)
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   /**
    * The UUID of the original request message in the case of an error occurring for an advice message
    */
   public ErrorDetail originalId(String originalId) {
      this.originalId = originalId;
      return this;
   }

   @ApiModelProperty(value = "The UUID of the original request message in the case of an error occurring for an advice message")
   @JsonProperty("originalId")
   public String getOriginalId() {
      return originalId;
   }

   public void setOriginalId(String originalId) {
      this.originalId = originalId;
   }

   /**
    * The type of error that occurred
    **/
   public ErrorDetail requestType(RequestType requestType) {
      this.requestType = requestType;
      return this;
   }

   @ApiModelProperty(required = true, value = "The type of request that preceeded the error")
   @JsonProperty("requestType")
   @NotNull
   public RequestType getRequestType() {
      return requestType;
   }

   public void setRequestType(RequestType requestType) {
      this.requestType = requestType;
   }

   /**
    * The type of error that occurred
    **/
   public ErrorDetail errorType(ErrorType errorType) {
      this.errorType = errorType;
      return this;
   }

   @ApiModelProperty(required = true, value = "The type of error that occurred")
   @JsonProperty("errorType")
   @NotNull
   public ErrorType getErrorType() {
      return errorType;
   }

   public void setErrorType(ErrorType errorType) {
      this.errorType = errorType;
   }

   /**
    * A short description of the error
    **/
   public ErrorDetail errorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
      return this;
   }

   @ApiModelProperty(required = true, value = "A short description of the error")
   @JsonProperty("errorMessage")
   @NotNull
   @Length(max = 20)
   public String getErrorMessage() {
      return errorMessage;
   }

   public void setErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
   }

   /**
    * A free form detailed description of a particular failure condition may optionally be supplied
    **/
   public ErrorDetail detailMessage(Object detailMessage) {
      this.detailMessage = detailMessage;
      return this;
   }

   @ApiModelProperty(value = "A free form detailed description of a particular failure condition may optionally be supplied")
   @JsonProperty("detailMessage")
   public Object getDetailMessage() {
      return detailMessage;
   }

   public void setDetailMessage(Object detailMessage) {
      this.detailMessage = detailMessage;
   }

   /**
    * The error code returned by the service provider. Note that this should be used for informational purposes only.
    * Messages displayed on the POS should make use of errorType and errorMessage to ensure a consistent set of
    * responses.
    **/
   public ErrorDetail providerErrorCode(String providerErrorCode) {
      this.providerErrorCode = providerErrorCode;
      return this;
   }

   @JsonProperty("providerErrorCode")
   @ApiModelProperty(value = "The error code returned by the service provider. Note that this should be used for informational purposes only. Messages displayed on the POS should make use of errorType and errorMessage to ensure a consistent set of responses.")
   public String getProviderErrorCode() {
      return providerErrorCode;
   }

   public void setProviderErrorCode(String providerErrorCode) {
      this.providerErrorCode = providerErrorCode;
   }

   /**
    * The error message returned by the service provider. Note that this should be used for informational purposes only.
    * Messages displayed on the POS should make use of errorType and errorMessage to ensure a consistent set of
    * responses.
    */
   public ErrorDetail providerErrorMsg(String providerErrorMsg) {
      this.providerErrorMsg = providerErrorMsg;
      return this;
   }

   @JsonProperty("providerErrorMsg")
   @ApiModelProperty(value = "The error message returned by the service provider. Note that this should be used for informational purposes only. Messages displayed on the POS should make use of errorType and errorMessage to ensure a consistent set of responses.")
   public String getProviderErrorMsg() {
      return providerErrorMsg;
   }

   public void setProviderErrorMsg(String providerErrorMessage) {
      this.providerErrorMsg = providerErrorMessage;
   }

   /**
    * The reference returned by the service provider.
    */
   public ErrorDetail providerRef(String providerRef) {
      this.providerRef = providerRef;
      return this;
   }

   @JsonProperty("providerRef")
   @ApiModelProperty(value = "The reference returned by the service provider.")
   public String getProviderRef() {
      return providerRef;
   }

   public void setProviderRef(String providerRef) {
      this.providerRef = providerRef;
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
            && Objects.equals(detailMessage, errorDetail.detailMessage)
            && Objects.equals(providerErrorCode, errorDetail.providerErrorCode)
            && Objects.equals(providerErrorMsg, errorDetail.providerErrorMsg)
            && Objects.equals(providerRef, errorDetail.providerRef);
   }

   @Override
   public int hashCode() {
      return Objects.hash(
            id,
            originalId,
            errorType,
            errorMessage,
            requestType,
            detailMessage,
            providerErrorCode,
            providerErrorMsg,
            providerRef);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ErrorDetail {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    originalId: ").append(Utils.toIndentedString(originalId)).append("\n");
      sb.append("    errorType: ").append(Utils.toIndentedString(errorType)).append("\n");
      sb.append("    responseMessage: ").append(Utils.toIndentedString(errorMessage)).append("\n");
      sb.append("    requestType: ").append(Utils.toIndentedString(requestType)).append("\n");
      sb.append("    detailMessage: ").append(Utils.toIndentedString(detailMessage)).append("\n");
      sb.append("    providerErrorCode: ").append(Utils.toIndentedString(providerErrorCode)).append("\n");
      sb.append("    providerErrorMsg: ").append(Utils.toIndentedString(providerErrorMsg)).append("\n");
      sb.append("    providerRef: ").append(Utils.toIndentedString(providerRef)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
