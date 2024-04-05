package dev.kesorupert.MtlsServerApplication;

import org.springframework.boot.ssl.SslBundle;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    private String serverUrl = "http://localhost:8081";

    @Bean
    public RestTemplate sslRestTemplate(RestTemplateBuilder builder, SslBundles sslBundles) {
        SslBundle sslBundle = sslBundles.getBundle("clientbundle");
        return builder.rootUri(serverUrl).setSslBundle(sslBundle).build();
    }
}
