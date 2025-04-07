package edu.sharif.selab.services;

import edu.sharif.selab.models.TelegramMessage;
import edu.sharif.selab.models.Message;

public class TelegramMessageService implements MessageService {
    @Override
    public void sendMessage(Message message) {
        TelegramMessage telegramMessage = (TelegramMessage) message;
        if (validatePhoneNumber(telegramMessage.getSourcePhoneNumber()) && validatePhoneNumber(telegramMessage.getTargetPhoneNumber())) {
            System.out.println("Sending a Telegram message from " + telegramMessage.getSourcePhoneNumber() + " to " + telegramMessage.getTargetPhoneNumber() + " with content: " + telegramMessage.getContent());
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
