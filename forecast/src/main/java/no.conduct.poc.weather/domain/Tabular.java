package no.conduct.poc.weather.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tabular {

    private Time time;

    @XmlElement
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
