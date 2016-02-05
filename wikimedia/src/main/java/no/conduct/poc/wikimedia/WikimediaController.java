package no.conduct.poc.wikimedia;

import no.conduct.poc.wikimedia.domain.WikimediaCache;
import no.conduct.poc.wikimedia.domain.WikimediaCacheEntry;
import no.conduct.poc.wikimedia.services.PostnummerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class WikimediaController {

    @Inject
    private WikimediaCache cache;

    @Inject
    private PostnummerService postnummerService;

    @RequestMapping("/wiki/{text}")
    public List<WikimediaCacheEntry> get(@PathVariable("text") String postnummer) {
        return cache.get(postnummerService.getPoststed(postnummer));
    }


}
