package pl.olita.openweathermap;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String URL_WEATHER = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String URL_API_KEY = "&units=metric&appid=1ef46e80302a68f49c545c03d505606c";

    public Weather getWeatherInTheCity(String city) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            String finalURL = URL_WEATHER + city + URL_API_KEY;
            WeatherDto response = restTemplate.getForObject(finalURL, WeatherDto.class);
            return fromDto(response);
        } catch (Exception e) {
            throw new CityNotFoundException();
        }
    }

    public Weather fromDto(WeatherDto weatherDto) {
        Weather newWeather = new Weather();

        newWeather.setCity(weatherDto.getName());
        newWeather.setTemperatureNow(weatherDto.getMain().getTemperatureNow());
        newWeather.setTemperatureFelt(weatherDto.getMain().getTemperatureFelt());
        newWeather.setTemperatureMin(weatherDto.getMain().getTemperatureMin());
        newWeather.setTemperatureMax(weatherDto.getMain().getTemperatureMax());
        newWeather.setPressure(weatherDto.getMain().getPressure());
        newWeather.setHumidity(weatherDto.getMain().getHumidity());

        return newWeather;
    }
}