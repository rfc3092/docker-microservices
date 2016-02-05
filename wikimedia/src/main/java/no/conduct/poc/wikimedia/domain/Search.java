package no.conduct.poc.wikimedia.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Search {

    private String concepturi;
    private String label;
    private String description;
    private Match match;

    public String getConcepturi() {
        return concepturi;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public Match getMatch() {
        return match;
    }

}
