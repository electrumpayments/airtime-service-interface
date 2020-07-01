package io.electrum.airtime.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Specifically describes the content of the airtime product.
 **/

@ApiModel(description = "Specifically describes the content of the airtime product.")
public class ProductContent {

    /**
     * Every airtime product unit must be classified into one of the following unit types
     */
    public enum AirtimeProductUnit {
        KB("KB"),
        MB("MB"),
        GB("GB"),
        Unit("Unit"),
        Minutes("Minutes");

        private String value;

        AirtimeProductUnit(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }

    private long amount = 0L;
    private AirtimeProductUnit unit;

    /**
     * The amount of airtime in KB, MB, GB, Unit or Minutes
     */
    public ProductContent amount(long amount) {
        this.amount = amount;
        return this;
    }

    @ApiModelProperty(value = "The amount of airtime in KB, MB, GB, Unit or Minutes")
    @JsonProperty("amount")
    @NotNull
    @Min(0L)
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    /**
     * The unit of airtime. Can be KB, MB, GB, Unit or Minutes.
     */
    public ProductContent amount(AirtimeProductUnit unit) {
        this.unit = unit;
        return this;
    }

    @ApiModelProperty(value = "The unit of airtime. Can be KB, MB, GB, Unit or Minutes.")
    @JsonProperty("unit")
    @NotNull
    public AirtimeProductUnit getUnit() {
        return unit;
    }

    public void setUnit(AirtimeProductUnit unit) {
        this.unit = unit;
    }
}
