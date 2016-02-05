package no.conduct.poc.weather;

import no.conduct.poc.weather.domain.YrCache;
import no.conduct.poc.weather.domain.YrCacheEntry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "*")
@RestController
public class ForecastController {

    @Inject
    private YrCache cache;

    @RequestMapping("/weather/{postnummer}")
    public YrCacheEntry getForecastFor(@PathVariable("postnummer") String postnummer) {
        return cache.getForecast(postnummer);
    }

}
