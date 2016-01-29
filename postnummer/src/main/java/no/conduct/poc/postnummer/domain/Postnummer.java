package no.conduct.poc.postnummer.domain;

public class Postnummer {

    private String postnummer;
    private String poststed;

    protected Postnummer(String postnummer, String poststed) {
        this.postnummer = postnummer;
        this.poststed = poststed;
    }

    public String getPostnummer() {
        return postnummer;
    }

    public String getPoststed() {
        return poststed;
    }

    @Override
    public String toString() {
        return poststed;
    }

}
