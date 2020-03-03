import javax.swing.*;
import java.util.Date;

public class Message {

    private String messageText;
    private ImageIcon messageImage;
    private User sender;
    private User recipient;
    private Date timeSent;
    private Date timeDelivered;

    public Message(String messageText, User sender, User recipient, Date timeSent) {
        this.messageText = messageText;
        this.sender = sender;
        this.recipient = recipient;
        this.timeSent = timeSent;
    }

    public Message(String messageText, ImageIcon messageImage, User sender, User recipient, Date timeSent) {
        this.messageText = messageText;
        this.messageImage = messageImage;
        this.sender = sender;
        this.recipient = recipient;
        this.timeSent = timeSent;
    }
}
