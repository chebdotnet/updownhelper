package net.chebdotnet.updownhelper.api;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class UpdownBean {

    private String token;
    private String url;
    private String alias;
    private String lastStatus;
    private String uptime;
    private Boolean down;
    private String error;
    private String period;
    private String apdexT;
    private String stringMatch;
    private Boolean enabled;
    private Boolean published;
    private List<String> disabledLocations;
    private List<?> recipients;
    private LocalDateTime lastCheckAt;
    private LocalDateTime extCheckAt;
    private String muteUntil;
    private String faviconUrl;
    private Object customHeaders;
    private String httpVerb;
    private String httpBody;

}
