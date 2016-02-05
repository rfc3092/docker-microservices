package no.conduct.poc.wikimedia.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    private Collection<Search> search;

    public Collection<Search> getSearch() {
        return search;
    }

}
