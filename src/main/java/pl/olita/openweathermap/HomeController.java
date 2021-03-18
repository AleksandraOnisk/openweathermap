package pl.olita.openweathermap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final WeatherService weatherService;

    public HomeController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    private String home(Model model, @RequestParam(required = false) String city) {
        if (city != null) {
            model.addAttribute("weather", weatherService.getWeatherInTheCity(city));
        }
        return "home";
    }
}
