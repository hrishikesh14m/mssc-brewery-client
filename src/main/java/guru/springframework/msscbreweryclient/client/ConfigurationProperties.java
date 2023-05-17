package guru.springframework.msscbreweryclient.client;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ApiProperies.class)
public class ConfigurationProperties {
}
