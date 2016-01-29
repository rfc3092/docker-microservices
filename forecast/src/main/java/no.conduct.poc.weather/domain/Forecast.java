package no.conduct.poc.weather.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Forecast {

    private Tabular tabular;

    @XmlElement
    public Tabular getTabular() {
        return tabular;
    }

    public void setTabular(Tabular tabular) {
        this.tabular = tabular;
    }

}
