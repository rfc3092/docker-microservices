package no.conduct.poc.weather;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WeatherConfiguration {

    @Bean
    public WeatherUnmarshaller getVarselUnmarshaller() {

        Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
        unmarshaller.setPackagesToScan("no.conduct.poc.weather.domain");
        return new WeatherUnmarshaller(unmarshaller);

    }

}
