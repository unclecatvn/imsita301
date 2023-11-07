/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.io.IOException;

public class SendPhone123 {

    public static final String ACCOUNT_SID = "AC519467a987361badcd9438f3f9b48df1";
    public static final String AUTH_TOKEN = "4082ca186ac6c9ba96d658940a8a312a";
    public static final String TWILIO_PHONE_NUMBER = "+18557910841";

    // Phương thức tạo mã CAPTCHA
    public static String createCaptcha() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    // Phương thức gửi SMS với số điện thoại và nội dung cụ thể
    public static void sendSms(String to, String body) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new PhoneNumber(to),
                new PhoneNumber(TWILIO_PHONE_NUMBER),
                body
        ).create();

        System.out.println("Sent message SID: " + message.getSid());
    }
    
    public static void main(String[] args) throws IOException {
        SendPhone123 s = new SendPhone123();
        s.sendSms("0964061319", "0129318");
    }
}

