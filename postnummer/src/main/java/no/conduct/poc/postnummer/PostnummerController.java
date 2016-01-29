package no.conduct.poc.postnummer;

import no.conduct.poc.postnummer.domain.BringCache;
import no.conduct.poc.postnummer.domain.Postnummer;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@CrossOrigin(origins = "*")
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
