package edu.sharif.selab.services;

import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.Message;

public class SmsMessageService implements MessageService {
    @Override
    public void sendMessage(Message message) {
        SmsMessage smsMessage = (SmsMessage) message;
        if (validatePhoneNumber(smsMessage.getSourcePhoneNumber()) && validatePhoneNumber(smsMessage.getTargetPhoneNumber())) {
            System.out.println("Sending a SMS from " + smsMessage.getSourcePhoneNumber() + " to " + smsMessage.getTargetPhoneNumber() + " with content: " + smsMessage.getContent());
        } else {
            throw new IllegalArgumentException("Phone Number is Not Correct!");
        }
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11) {
            return false;
        }
        for (char digit : phoneNumber.toCharArray()) {
            if (!Character.isDigit(digit)) {
                return false;
            }
        }
        return true;
    }
}
