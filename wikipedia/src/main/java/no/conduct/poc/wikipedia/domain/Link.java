package no.conduct.poc.wikipedia.domain;

import java.net.URL;

public class Link {

    private String url;
    private String description;

    protected Link(URL url, String description) {
        this.url = url.toString();
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

}
