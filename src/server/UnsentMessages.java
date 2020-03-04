package server;

import client.Message;
import client.User;

import java.util.ArrayList;
import java.util.HashMap;

public class UnsentMessages {

    private HashMap<User, ArrayList<Message>> unsent = new HashMap<>();

    public synchronized void put(User user, ArrayList<Message> messages){
        unsent.put(user, messages);
    }

    public synchronized ArrayList<Message> get(User user){

        return unsent.get(user);

    }
}
