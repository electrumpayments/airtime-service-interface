package io.electrum.airtime.api.model;

import java.time.temporal.ChronoUnit;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Specifically describes the length of time for which a product is valid.
 * Any unused portion of a product (e.g. unused data) will be forfeit at the end of the validity period.
 * @since 5.14.0
 **/

@ApiModel(description = "Specifically describes the length of time for which a product is valid. " +
        "Any unused portion of a product (e.g. unused data) will be forfeit at the end of the validity period.")
public class ValidityPeriod {

   private long duration;
   private ChronoUnit durationUnit;

   public ValidityPeriod duration(long duration) {
      this.duration = duration;
      return this;
   }

   /**
    * A long value describing the number of durationUnits for the validity period.
    *
    * @return duration
    */
   @ApiModelProperty(required = true, value = "A long value describing the number of durationUnits for the validity period.")
   @JsonProperty("duration")
   @NotNull
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

   /**
    * A value describing the unit of measurement to be applied to the validity period.
    *
    * @return durationUnit
    */
   @ApiModelProperty(required = true, value = "A value describing the unit of measurement to be applied to the validity period.")
   @JsonProperty("durationUnit")
   @NotNull
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
      return Objects.equals(duration, validityPeriod.duration)
            && Objects.equals(durationUnit, validityPeriod.durationUnit);
   }

   @Override
   public int hashCode() {
      return Objects.hash(duration, durationUnit);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ValidityPeriod {").append(System.lineSeparator());
      sb.append("    duration: ").append(Utils.toIndentedString(duration)).append(System.lineSeparator());
      sb.append("    durationUnit: ").append(Utils.toIndentedString(durationUnit)).append(System.lineSeparator());
      sb.append('}');
      return sb.toString();
   }
}
