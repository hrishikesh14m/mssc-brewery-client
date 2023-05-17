package guru.springframework.msscbreweryclient.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "sfg.brewery",ignoreUnknownFields = false)
@AllArgsConstructor
@Getter
public class ApiProperies {

    private final String apiHost;

}
