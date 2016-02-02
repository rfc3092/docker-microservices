package no.conduct.poc.postnummer.domain;

public class Kommune {

    private String nummer;
    private String navn;

    protected Kommune(String nummer, String navn) {
        this.nummer = nummer;
        this.navn = navn;
    }

    public String getNummer() {
        return nummer;
    }

    public String getNavn() {
        return navn;
    }

}
