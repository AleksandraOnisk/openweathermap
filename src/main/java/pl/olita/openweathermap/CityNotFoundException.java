package pl.olita.openweathermap;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException() {
        super("Błąd podczas pobierania miejscowości.");
    }
}
