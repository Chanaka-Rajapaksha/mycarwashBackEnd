package com.mcw.mycarwash.Functions;

import java.util.Random;

public class OTPGenerator {
    public String generateOTP(int length){
        String otpNumber = null;
        String numbers = "0123456789";
        Random rndm_method = new Random();
        char[] otp = new char[length];
        for (int i = 0; i < length; i++) {
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        otpNumber=otp.toString();
        return otpNumber;
    }
}
