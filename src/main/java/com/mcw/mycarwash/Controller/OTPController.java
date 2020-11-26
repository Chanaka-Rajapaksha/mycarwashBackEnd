package com.mcw.mycarwash.Controller;

import com.mcw.mycarwash.Model.OTPModel;
import com.mcw.mycarwash.ServiceImpl.OtpService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class OTPController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Map<String, OTPModel> otp_data = new HashMap<>();

    @Autowired
    public OtpService otpService;

    @PostMapping("/generateOtp/{mobilenumber}")
    public ResponseEntity<Object> sendOTP(@PathVariable String mobilenumber) {
        OTPModel otpModel = new OTPModel();
        otpModel.setMobileNumber(mobilenumber);
        otpModel.setOtp(String.valueOf(((int) (Math.random() * (1000 - 1000))) + 1000));
        otpModel.setExpiryTime(System.currentTimeMillis() / 20000);
        otp_data.put(mobilenumber, otpModel);
        // OTP Sending function here, Email and SMS
        return new ResponseEntity<>("OTP Send", HttpStatus.OK);
    }


    @PostMapping(value = "/validateOtp/{mobilenumber}")
    public ResponseEntity<Object> validateOtp(@PathVariable String mobilenumber, @RequestBody OTPModel otpModel) {
        if (otpModel.getOtp() == null || otpModel.getOtp().length() <= 0) {
            return new ResponseEntity<>("Please Enter Correct OTP", HttpStatus.OK);
        }
        if (otp_data.containsKey(mobilenumber)) {
            OTPModel otpModel1 = otp_data.get(mobilenumber);
            if (otpModel1 != null) {
                if (otpModel1.getExpiryTime() <= System.currentTimeMillis()) {
                    if (otpModel.getOtp().equals(otpModel1.getOtp())) {
                        otp_data.remove(mobilenumber);
                        return new ResponseEntity<>("OTP Verified", HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>("Invalid OTP", HttpStatus.BAD_REQUEST);
                    }
                } else {
                    otp_data.remove(mobilenumber);
                    return new ResponseEntity<>("OTP Expired", HttpStatus.BAD_REQUEST);
                }
            } else {
                otp_data.remove(mobilenumber);
                return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>("Mobile Number not found", HttpStatus.NOT_FOUND);
    }
}
