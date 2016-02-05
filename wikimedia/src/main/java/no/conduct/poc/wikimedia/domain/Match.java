package no.conduct.poc.wikimedia.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Match {

    private String type;
    private String language;
    private String text;

    public String getType() {
        return type;
    }

    public String getLanguage() {
        return language;
    }

    public String getText() {
        return text;
    }

}
