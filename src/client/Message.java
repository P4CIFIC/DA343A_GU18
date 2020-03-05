package client;

import javax.swing.*;
import java.io.Serializable;
import java.util.Calendar;

public class Message implements Serializable {

    private String messageText;
    private ImageIcon messageImage;
    private User sender;
    private User recipient;
    private Calendar timeSent;
    private Calendar timeDelivered;

    public Message(String messageText, User sender, User recipient) {
        this.messageText = messageText;
        this.sender = sender;
        this.recipient = recipient;
        this.timeSent = Calendar.getInstance();
    }

    public Message(String messageText, ImageIcon messageImage, User sender, User recipient) {
        this.messageText = messageText;
        this.messageImage = messageImage;
        this.sender = sender;
        this.recipient = recipient;
        this.timeSent = Calendar.getInstance();
    }

    public void setTimeDelivered(Calendar timeDelivered) {
        this.timeDelivered = timeDelivered;
    }

    public String getMessageText() {
        return messageText;
    }

    public ImageIcon getMessageImage() {
        return messageImage;
    }

    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public Calendar getTimeSent() {
        return timeSent;
    }

    public Calendar getTimeDelivered() {
        return timeDelivered;
    }
}
