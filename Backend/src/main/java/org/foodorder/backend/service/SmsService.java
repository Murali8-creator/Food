package org.foodorder.backend.service;

//import com.twilio.twiml.messaging.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.foodorder.backend.configuration.TwilioConfig;
import org.foodorder.backend.model.SmsRequest;
import org.foodorder.backend.model.SmsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;

import java.util.Map;

@Service
@Slf4j
public class SmsService {

    @Autowired
    private TwilioConfig twilioConfig;

    public SmsResponse sendSms(SmsRequest smsRequest){
//        log.info("Sending sms {} ", smsRequest);
//        PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
//        PhoneNumber from = new PhoneNumber(twilioConfig.getPhoneNumber());
//        smsRequest.setMessage( "Your Food is on the way!! - Sent from Food Order App");
//        String message = smsRequest.getMessage();

//        Message sms = Message.creator(to, from, message).create();

        Message sms = Message.creator(
                new com.twilio.type.PhoneNumber(smsRequest.getPhoneNumber()),
                new com.twilio.type.PhoneNumber("+15184921159"),
                "Thanks for Ordering. Your Order is on the way" ).create();

        log.info("SMS sent successfully with sid {}", sms.getSid());
        log.info("sms status : {}",sms.getStatus());
        log.info("sms error code : {}",sms.getErrorCode());
        log.info("sms error message : {}",sms.getErrorMessage());
        log.info("sms {}",sms.getFrom());

        return new SmsResponse("SMS Sent!", true);
    }

}
