package client;

import java.io.Serializable;

public class MessageLogIn implements Serializable {
    private String userName;


    public MessageLogIn(String userName){
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }

}
