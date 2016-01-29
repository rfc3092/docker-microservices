package no.conduct.poc.weather;

import no.conduct.poc.weather.domain.Weatherdata;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;

public class WeatherUnmarshaller {

    private Unmarshaller unmarshaller;

    protected WeatherUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public String getCurrentWeatherIcon(InputStream in)
        throws IOException {

        Weatherdata weatherdata = (Weatherdata) unmarshaller.unmarshal(new StreamSource(in));
        return weatherdata.getForecast().getTabular().getTime().getSymbol().getVar();

    }

}
