package no.conduct.poc.weather.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Credit {

    private Link link;

    @XmlElement
    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

}
