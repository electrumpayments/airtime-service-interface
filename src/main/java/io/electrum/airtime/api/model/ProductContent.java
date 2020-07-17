package io.electrum.airtime.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

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
        UNIT("Unit"),
        MINUTES("Minutes");

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
     * The amount of airtime in KB, MB or GB for data; Unit for SMSs; Minutes for airtime.
     */
    public ProductContent amount(long amount) {
        this.amount = amount;
        return this;
    }

    @ApiModelProperty(required = true, value = "The amount of airtime in KB, MB or GB for data; Unit for SMSs; Minutes for airtime.")
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
     * The unit of airtime. Can be KB, MB or GB for data; Unit for SMSs or Minutes for airtime.
     */
    public ProductContent unit(AirtimeProductUnit unit) {
        this.unit = unit;
        return this;
    }

    @ApiModelProperty(required = true, value = "The unit of airtime. Can be KB, MB or GB for data; Unit for SMSs; Minutes for airtime.")
    @JsonProperty("unit")
    @NotNull
    public AirtimeProductUnit getUnit() {
        return unit;
    }

    public void setUnit(AirtimeProductUnit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductContent{");
        sb.append("amount=").append(amount);
        sb.append(", unit=").append(unit);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductContent that = (ProductContent) o;
        return amount == that.amount &&
                unit == that.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, unit);
    }
}
