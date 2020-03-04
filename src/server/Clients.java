package server;


import client.Client;
import client.User;

import java.util.HashMap;

public class Clients {
        private HashMap<User, ClientHandler> clients = new HashMap<>();

        // egna tillägg

        public synchronized void put(User user,ClientHandler client) {
            clients.put(user,client);
        }

        public synchronized ClientHandler get(User user) {
            return get(user);
        }


// fler synchronized-metoder som behövs
}
