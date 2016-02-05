package no.conduct.poc.weather.domain;

import no.conduct.poc.weather.ForecastUnmarshaller;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Repository
public class YrCache {

    private static final Logger LOG = Logger.getLogger(YrCache.class.getName());
    private static final String VARSEL_URL = "http://www.yr.no/sted/Norge/postnummer/%s/varsel.xml";
    private static final String IMAGE_URL = "http://symbol.yr.no/grafikk/sym/b30/%s.png";

    @Inject
    private ForecastUnmarshaller unmarshaller;

    private Map<String, YrCacheEntry> cache = new HashMap<>();

    public YrCacheEntry getForecast(String postnummer) {

        YrCacheEntry entry = cache.get(postnummer);
        if (entry == null) {
            synchronized (YrCache.class) {
                entry = cache.get(postnummer);
                if (entry == null) {
                    entry = createEntryFrom(postnummer);
                    if (entry != null) {
                        cache.put(postnummer, entry);
                    }
                }
            }
        }
        return entry;

    }

    private YrCacheEntry createEntryFrom(String postnummer) {

        YrCacheEntry entry = null;
        String imageURL = null;
        try {
            unmarshaller.unmarshal(new URL(String.format(VARSEL_URL, postnummer)).openStream());
            imageURL = String.format(IMAGE_URL, unmarshaller.getIcon());
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            try (InputStream in = new URL(imageURL).openStream()) {
                int i;
                while ((i = in.read()) != -1) {
                    buffer.write(i);
                }
            }
            entry = new YrCacheEntry(Base64.getEncoder().encodeToString(buffer.toByteArray()), unmarshaller.getLink());
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Cannot get image from URL " + imageURL, e);
        }
        return entry;

    }

}
