package no.conduct.poc.weather;

import no.conduct.poc.weather.domain.Weatherdata;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;

public class ForecastUnmarshaller {

    private Unmarshaller unmarshaller;
    private String icon;
    private String link;

    protected ForecastUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public void unmarshal(InputStream in)
        throws IOException {

        Weatherdata weatherdata = (Weatherdata) unmarshaller.unmarshal(new StreamSource(in));
        icon = weatherdata.getForecast().getTabular().getTime().getSymbol().getVar();
        link = weatherdata.getCredit().getLink().getUrl();

    }

    public String getIcon() {
        return icon;
    }

    public String getLink() {
        return link;
    }

}
