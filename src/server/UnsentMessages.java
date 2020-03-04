package server;

import client.Message;
import client.User;

import java.util.ArrayList;
import java.util.HashMap;

public class UnsentMessages {
    private HashMap<User, ArrayList<Message>> unsent = new HashMap<>();

    public synchronized void put(User user, Message message){

        unsent.put(u)

    }
}
