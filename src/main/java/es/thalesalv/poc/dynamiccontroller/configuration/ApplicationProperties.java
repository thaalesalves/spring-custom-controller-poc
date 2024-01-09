package es.thalesalv.poc.dynamiccontroller.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {

    private List<String> controllersEnabled;
}
