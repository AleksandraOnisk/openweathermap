package pl.olita.openweathermap;

public class WeatherMapper {

    public static Weather fromDto(WeatherDto weatherDto) {
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
