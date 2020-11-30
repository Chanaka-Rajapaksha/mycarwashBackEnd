package com.mcw.mycarwash.Controller;

import com.mcw.mycarwash.Model.OTPModel;
import com.mcw.mycarwash.Service.OtpService;
import com.mcw.mycarwash.ServiceImpl.OtpServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/otp")
public class OTPController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Map<Integer, OTPModel> otp_data = new HashMap<>();

    @Autowired
    public OtpService otpModeService;

    @PostMapping("/generateOtp/{mobilenumber}/{email}")
    public ResponseEntity<Object> sendOTP(@PathVariable int mobilenumber,@PathVariable String email) {
        otp_data.put(mobilenumber, otpModeService.SendOTP(mobilenumber,email));
        return new ResponseEntity<>("OTP Send", HttpStatus.OK);
    }

    @PostMapping(value = "/validateOtp/{mobilenumber}")
    public ResponseEntity<Object> validateOtp(@PathVariable int mobilenumber, @RequestBody OTPModel otpModel) {
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
