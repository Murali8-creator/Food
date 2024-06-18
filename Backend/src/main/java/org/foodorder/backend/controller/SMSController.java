package org.foodorder.backend.controller;


import org.foodorder.backend.model.SmsRequest;
import org.foodorder.backend.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SMSController {

    @Autowired
    private SmsService smsService;

    @PostMapping("/sms")
    public void sendSms(@RequestBody SmsRequest smsRequest){
        smsService.sendSms(smsRequest);
    }
}
