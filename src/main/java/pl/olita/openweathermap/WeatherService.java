package pl.olita.openweathermap;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class WeatherService {

    private static final String URL_WEATHER = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String URL_API_KEY = "&appid=1ef46e80302a68f49c545c03d505606c";
    private static final BigDecimal KELVIN_ZERO = BigDecimal.valueOf(273.15);

    public Weather getWeatherInTheCity(String city) {

            try {
                RestTemplate restTemplate = new RestTemplate();
                String finalURL = URL_WEATHER + city + URL_API_KEY;
                WeatherDto response = restTemplate.getForObject(finalURL, WeatherDto.class);
                return fromDto(response);
            } catch (Exception e){
                throw new CityNotFoundException();
        }
    }

    public Weather fromDto(WeatherDto weatherDto) {
        Weather newWeather = new Weather();

        newWeather.setCity(weatherDto.getName());
        newWeather.setTemperatureNow(weatherDto.getParameters().get("temperatureNow").subtract(KELVIN_ZERO));
        newWeather.setTemperatureFelt(weatherDto.getParameters().get("temperatureFelt").subtract(KELVIN_ZERO));
        newWeather.setTemperatureMin(weatherDto.getParameters().get("temperatureMin").subtract(KELVIN_ZERO));
        newWeather.setTemperatureMax(weatherDto.getParameters().get("temperatureMax").subtract(KELVIN_ZERO));
        newWeather.setPressure(weatherDto.getParameters().get("pressure"));
        newWeather.setHumidity(weatherDto.getParameters().get("humidity"));

        return newWeather;
    }
}