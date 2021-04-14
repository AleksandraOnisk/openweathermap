package pl.olita.openweathermap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class WeatherParametersDto {

    private BigDecimal temperatureNow;
    private BigDecimal temperatureFelt;
    private BigDecimal temperatureMax;
    private BigDecimal temperatureMin;
    private BigDecimal pressure;
    private BigDecimal humidity;

    @JsonCreator
    public WeatherParametersDto(
            @JsonProperty("temp") BigDecimal temperatureNow,
            @JsonProperty("feels_like") BigDecimal temperatureFelt,
            @JsonProperty("temp_max") BigDecimal temperatureMax,
            @JsonProperty("temp_min") BigDecimal temperatureMin,
            @JsonProperty("pressure") BigDecimal pressure,
            @JsonProperty("humidity") BigDecimal humidity) {
        this.temperatureNow = temperatureNow;
        this.temperatureFelt = temperatureFelt;
        this.temperatureMax = temperatureMax;
        this.temperatureMin = temperatureMin;
        this.pressure = pressure;
        this.humidity = humidity;
    }
}
