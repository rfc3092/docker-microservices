package no.conduct.poc.postnummer.domain;

public class Postnummer {

    private String postnummer;
    private String poststed;
    private Kommune kommune;

    protected Postnummer(String postnummer, String poststed, Kommune kommune) {
        this.postnummer = postnummer;
        this.poststed = poststed;
        this.kommune = kommune;
    }

    public String getPostnummer() {
        return postnummer;
    }

    public String getPoststed() {
        return poststed;
    }

    public Kommune getKommune() {
        return kommune;
    }

    @Override
    public String toString() {
        return poststed;
    }

}
