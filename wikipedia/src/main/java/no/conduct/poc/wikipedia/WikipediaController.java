package no.conduct.poc.wikipedia;

import no.conduct.poc.wikipedia.domain.WikipediaCache;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@CrossOrigin(origins = "*")
@RestController
public class WikipediaController {

    @Inject
    private WikipediaCache cache;

}
