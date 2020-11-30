package com.mcw.mycarwash.ServiceImpl;


import com.mcw.mycarwash.Functions.EmailSender;
import com.mcw.mycarwash.Model.EmailBodyType;
import com.mcw.mycarwash.Model.OTPModel;
import com.mcw.mycarwash.Service.OtpService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OtpServiceImpl implements OtpService {

    @Override
    public OTPModel SendOTP(int mobileNumber, String email) {
        Random random = new Random();
        int otp = 1000 + random.nextInt(9000);
        OTPModel otpModel = new OTPModel();
        otpModel.setMobileNumber(mobileNumber);
        otpModel.setOtp(String.valueOf(otp));
        otpModel.setExpiryTime(System.currentTimeMillis() / 20000);
        String body = EmailBodyType.OTPBody(otpModel.getOtp());
        EmailSender emailSender = new EmailSender();
        emailSender.sendMail("", email, body);
        return otpModel;
    }

    @Override
    public OTPModel ValidateOtp(int mobileNumber, OTPModel otpModel) {
        return null;
    }
}
