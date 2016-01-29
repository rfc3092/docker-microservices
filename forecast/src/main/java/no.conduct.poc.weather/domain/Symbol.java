package no.conduct.poc.weather.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Symbol {

    private String var;

    @XmlAttribute
    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

}
