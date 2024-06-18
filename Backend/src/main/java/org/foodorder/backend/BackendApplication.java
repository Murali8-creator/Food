package org.foodorder.backend;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.foodorder.backend.configuration.TwilioConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class BackendApplication {

    @Autowired
    private TwilioConfig twilioConfig;

    @PostConstruct
    public void init(){
        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
    }

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
