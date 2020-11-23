package com.mcw.mycarwash.Model;

public class EmailBodyType {


    public static String OTPBody(int OTP) {
        String body = "<html>\n" +
                "<head>\n" +
                "    <title>Your OTP Number</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    \n" +
                "<p><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"a.jpg\" alt=\"MyCarWash\" width=\"150\" height=\"150\" />Dear Valued Customer,</p>\n" +
                "<p>Please use the following OTP:&nbsp;<strong>"+OTP+"</strong>&nbsp;to complete your Mobile Banking request. This One Time Password (OTP) is issued to you for verification purposes and should not be shared with anyone else, as it would compromise your security.</p>\n" +
                "<p>&nbsp;</p>\n" +
                "<p>Best Regards<br />Team MyCarWash</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
        return body;
    }
    public static String WelcomeBody(Customer customer){
        String body="";
        return body;
    }
    public static String ConfirmBody(Customer customer){
        String body="";
        return body;
    }
    public static String BookingBody(Customer customer){
        String body="";
        return body;
    }
    public static String BookingCancelBody(Customer customer){
        String body="";
        return body;
    }
    public static String PaymentBody(Customer customer){
        String body="";
        return body;
    }
}
