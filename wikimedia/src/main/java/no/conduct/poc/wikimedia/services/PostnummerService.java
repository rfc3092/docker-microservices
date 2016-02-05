package no.conduct.poc.wikimedia.services;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PostnummerService {

    private static final String BASE_URL = "http://localhost:8081/postnummer/%s";

    public String getPoststed(String postnummer) {
        return new RestTemplate().getForObject(String.format(BASE_URL, postnummer), Postnummer.class).getPoststed();
    }

}
