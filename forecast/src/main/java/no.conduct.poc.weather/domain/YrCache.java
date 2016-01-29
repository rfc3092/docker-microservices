package no.conduct.poc.weather.domain;

import no.conduct.poc.weather.WeatherUnmarshaller;
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
    private static final String BASE_URL = "http://symbol.yr.no/grafikk/sym/b30/%s.png";

    @Inject
    private WeatherUnmarshaller unmarshaller;

    private Map<String, String> cache = new HashMap<>();

    public String getBase64EncodedImage(String url) {

        String image = cache.get(url);
        if (image == null) {
            synchronized (YrCache.class) {
                image = cache.get(url);
                if (image == null) {
                    image = base64EncodeImage(getImageFromUrl(url));
                    if (image != null) {
                        cache.put(url, image);
                    }
                }
            }
        }
        return image;

    }

    private byte[] getImageFromUrl(String url) {

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            url = String.format(BASE_URL, unmarshaller.getCurrentWeatherIcon(new URL(url).openStream()));
            try (InputStream in = new URL(url).openStream()) {
                int i;
                while ((i = in.read()) != -1) {
                    buffer.write(i);
                }
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Cannot get image from URL " + url, e);
        }
        return buffer.toByteArray();

    }

    private String base64EncodeImage(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

}
