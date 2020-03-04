package server;


import client.Client;
import client.User;

import java.util.HashMap;

public class Clients {
        private HashMap<User, Object> clients = new HashMap<>();

        // egna tillägg

        public synchronized void put(User user,Object client) {
            clients.put(user,client);
        }

        public synchronized Object get(User user) {
            return get(user);
        }
        public synchronized Boolean containsUser(User user) {
            if (clients.containsKey(user)) {
                return true;
            } else {
                return false;
            }
        }


// fler synchronized-metoder som behövs
}
