package no.conduct.poc.wikipedia.domain;

import org.springframework.stereotype.Repository;

import javax.inject.Singleton;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Singleton
@Repository
public class WikipediaCache {

    public Map<String, Collection<Link>> cache = new HashMap<>();

    public Collection<Link> searchFor(String text) {

        // TODO: Implement.
        return null;

    }

    private class Item {

        private long created;
        private Collection<Link> data;

        private Item(Collection<Link> data) {
            created = System.currentTimeMillis();
            this.data = data;
        }
    }

}
