package com.mcw.mycarwash.Service;

import com.mcw.mycarwash.Model.OTPModel;


public interface OtpService {
    public OTPModel SendOTP(int mobileNumber,String email);
    public OTPModel ValidateOtp(int mobileNumber,OTPModel otpModel);

}
