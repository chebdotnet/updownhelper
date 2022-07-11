package net.chebdotnet.updownhelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class UpdownApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpdownApplication.class, args);
    }

}
