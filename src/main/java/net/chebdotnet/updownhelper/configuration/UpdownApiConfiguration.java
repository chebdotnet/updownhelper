package net.chebdotnet.updownhelper.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.RequestInterceptor;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import feign.optionals.OptionalDecoder;
import lombok.RequiredArgsConstructor;
import net.chebdotnet.updownhelper.api.UpdownRestApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static feign.Logger.Level.FULL;

@Configuration
@RequiredArgsConstructor
public class UpdownApiConfiguration {

    private final ObjectMapper objectMapper;
    private final UpdownApiProperties properties;

    @Bean
    public UpdownRestApi updownRestApi() {
        return build().target(UpdownRestApi.class, properties.getBaseUrl());
    }


    private RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("X-API-KEY", properties.getApiKey());
        };
    }

    private Feign.Builder build() {
        return Feign.builder()
                .logLevel(FULL)
                .requestInterceptor(requestInterceptor())
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new OptionalDecoder(new JacksonDecoder(objectMapper)))
                .contract(new JAXRSContract());
    }

}
