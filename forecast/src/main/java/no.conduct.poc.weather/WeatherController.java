package no.conduct.poc.weather;

import no.conduct.poc.weather.domain.YrCache;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class WeatherController {

    private static final String BASE_URL = "http://www.yr.no/sted/Norge/postnummer/%s/varsel.xml";

    @Inject
    private YrCache cache;

    @RequestMapping("/weather/{postnummer}")
    public String get(@PathVariable("postnummer") String postnummer) {
        return cache.getBase64EncodedImage(String.format(BASE_URL, postnummer));
    }

}
