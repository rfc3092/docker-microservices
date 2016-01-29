package no.conduct.poc.postnummer.domain;

import org.springframework.stereotype.Repository;

import javax.inject.Singleton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Repository
public class BringCache {

    private static final Logger LOG = Logger.getLogger(BringCache.class.getName());
    private static final String URL = "http://www.bring.no/radgivning/sende-noe/adressetjenester/postnummer/_attachment/615728?_download=true&_ts=15040ebe588";

    private final SortedMap<String, Postnummer> cache = new TreeMap<>(Comparator.naturalOrder());

    public BringCache() {

        LOG.log(Level.INFO, "Populating cache");
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(URL).openStream(), "Cp1252"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    cache.putAll(parse(line));
                }
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Unable to read data from source", e);
        }

    }

    private Map<String, Postnummer> parse(String line) {

        Map<String, Postnummer> parsed = new HashMap<>(1);
        String[] parts = line.split("\t");
        parsed.put(parts[0], new Postnummer(parts[0], parts[1]));
        return parsed;

    }

    public Postnummer getOne(String postnummer) {
        Postnummer poststed = cache.get(postnummer);
        LOG.log(Level.INFO, "Looked up " + postnummer +" -> " + poststed);
        return poststed;
    }

    public Collection<Postnummer> getAll() {
        return cache.values();
    }

}
