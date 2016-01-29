package no.conduct.poc.postnummer;

import no.conduct.poc.postnummer.domain.BringCache;
import no.conduct.poc.postnummer.domain.Postnummer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Collection;

@RestController
public class PostnummerController {

    @Inject
    private BringCache cache;

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/postnummer/{postnummer}")
    public Postnummer getOne(@PathVariable("postnummer") String postnummer) {
        return cache.getOne(postnummer);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/postnummer")
    public Collection<Postnummer> getAll() {
        return cache.getAll();
    }

}
