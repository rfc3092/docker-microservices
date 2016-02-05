package no.conduct.poc.wikimedia.domain;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Repository
public class WikimediaCache {

    private static final String BASE_URL = "https://www.wikidata.org/w/api.php?action=wbsearchentities&search=%s&language=no&format=json";

    private Map<String, List<WikimediaCacheEntry>> cache = new HashMap<>();

    public List<WikimediaCacheEntry> get(String text) {

        List<WikimediaCacheEntry> result = cache.get(text);
        if (result == null) {
            synchronized (WikimediaCache.class) {
                result = cache.get(text);
                if (result == null) {
                    result = search(text);
                    cache.put(text, result);
                }
            }
        }
        return result;

    }

    private List<WikimediaCacheEntry> search(String text) {

        List<WikimediaCacheEntry> entries = new ArrayList<>();

        new RestTemplate().getForObject(String.format(BASE_URL, text), Result.class).getSearch().forEach(search -> entries.add(new WikimediaCacheEntry(search)));

        return entries;

    }

}
