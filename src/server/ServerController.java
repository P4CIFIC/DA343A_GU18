package server;

import client.Message;
import client.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

public class ServerController {

    private AllClients allClients;
    private OnlineClients onlineClients;
    private Message message;
    private UnsentMessages unsentMessages;

    public ServerController(int port) {

        new Connection(port).start();

        allClients = new AllClients();
        onlineClients = new OnlineClients();
        unsentMessages = new UnsentMessages();

    }

    private class Connection extends Thread {

        private int port;

        public Connection(int port) {
            this.port = port;

        }

        @Override
        public void run() {
            Socket socket;
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                while (true) {
                    socket = serverSocket.accept();
                    new ClientHandler(socket).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ClientHandler extends Thread {

        private Socket socket;
        private ObjectInputStream ois;
        private ObjectOutputStream dos;
        private LinkedList<Message> messages = new LinkedList<>();
        private User user;

        public ClientHandler(Socket socket) {
            this.socket = socket;

            try {
                ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                dos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));

                Object object = ois.readObject();

                if (object instanceof User) {
                    user = (User) object;
                }
                if (!onlineClients.containsUser(user)) {
                    onlineClients.put(user, ClientHandler.this);
                }
                if (!allClients.containsUser(user)) {
                    allClients.put(user);
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void send(Object object) {

            try {
                dos.writeObject(object);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {

            while (true) {
                try {

                    if (!onlineClients.containsUser(message.getRecipient())) {
                        Message obj = (Message) ois.readObject();
                        messages.add(obj);
                        unsentMessages.put(message.getRecipient(), messages);
                        //if satsen ska först kolla om personen finns i onlineList och ifall inte skicka det och lagra i klassen unsentMessages
                        //Finns personen så skicka det till hen
                    } else {




                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



