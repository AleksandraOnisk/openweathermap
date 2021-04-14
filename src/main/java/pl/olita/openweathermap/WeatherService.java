package pl.olita.openweathermap;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String URL_WEATHER = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String URL_API_KEY = "&units=metric&appid=1ef46e80302a68f49c545c03d505606c";

    public Weather getWeatherInTheCity(String city) {

        try {
            URI finalURL = new URI(URL_WEATHER + city + URL_API_KEY);
            WeatherDto response = restTemplate.getForObject(finalURL, WeatherDto.class);
            return WeatherMapper.fromDto(response);
        } catch (Exception e) {
            throw new CityNotFoundException();
        }
    }
}