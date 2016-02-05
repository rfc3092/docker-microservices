package no.conduct.poc.weather.domain;

public class YrCacheEntry {

    String image;
    String link;

    protected YrCacheEntry(String image, String link) {
        this.image = image;
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }

}
