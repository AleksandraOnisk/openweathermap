package pl.olita.openweathermap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {

    private String name;
    private Map<String, BigDecimal> parameters;
}
