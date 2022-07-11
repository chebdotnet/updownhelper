package net.chebdotnet.updownhelper.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("updown-api")
public class UpdownApiProperties {

    private String baseUrl;
    private String apiKey;

}
