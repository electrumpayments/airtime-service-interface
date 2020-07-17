package io.electrum.airtime.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * Specifically describes the validity period of an airtime purchase.
 **/

@ApiModel(description = "Specifically describes the validity period of an airtime voucher.")
public class ValidityPeriod {

    private long duration;
    private ChronoUnit durationUnit;

    public ValidityPeriod duration(long duration) {
        this.duration = duration;
        return this;
    }

    @ApiModelProperty(required = true, value = "A long value describing the number of durationUnits for the validity period.")
    @JsonProperty("duration")
    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public ValidityPeriod durationUnit(ChronoUnit durationUnit) {
        this.durationUnit = durationUnit;
        return this;
    }

    @ApiModelProperty(required = true, value = "A ChronoUnit value describing the unit of measurement to be applied to the validity period.")
    @JsonProperty("durationUnit")
    public ChronoUnit getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(ChronoUnit durationUnit) {
        this.durationUnit = durationUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ValidityPeriod validityPeriod = (ValidityPeriod) o;
        return Objects.equals(duration, validityPeriod.duration) &&
                Objects.equals(durationUnit, validityPeriod.durationUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration, durationUnit);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ValidityPeriod {\n");
        sb.append("    duration: ").append(Utils.toIndentedString(duration)).append(System.lineSeparator());
        sb.append("    durationUnit: ").append(Utils.toIndentedString(durationUnit)).append(System.lineSeparator());
        sb.append('}');
        return sb.toString();
    }
}
