package no.conduct.poc.wikimedia.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Postnummer {

    private String poststed;

    public String getPoststed() {
        return poststed;
    }

}
