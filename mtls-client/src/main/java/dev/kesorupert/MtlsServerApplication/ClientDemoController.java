package dev.kesorupert.MtlsServerApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientDemoController {

    private RestTemplate restTemplate;

    @Autowired
    public ClientDemoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/client/securehello")
    public String getSecureHello() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/hello", String.class);
        return response.getBody();
    }

}


