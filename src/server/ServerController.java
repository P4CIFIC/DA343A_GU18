package server;

import client.Client;
import client.Message;
import client.User;
import com.sun.security.ntlm.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerController {

    private Clients clients = new Clients();
    private Message message;

    public ServerController(int port) {
        new Connection(port).start();
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
                    try {
                        ClientHandler clientHandler;
                        User user = message.getSender();

                        if (clients.containsUser(user)) {
                            clientHandler = (ClientHandler) clients.get(user);
                            clientHandler.start();

                        } else {

                            socket = serverSocket.accept();
                            clientHandler = new ClientHandler(socket);
                            clients.put(user, clientHandler);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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
        private Clients clients;


        public ClientHandler(Socket socket) {
            clients = new Clients();
            this.socket = socket;

            try {
                ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                dos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {

                try {

                    Object obj = ois.readObject();
                    if () {
                        //if satsen ska först kolla om personen finns i onlineList och ifall inte skicka det och lagra i klassen unsentMessages
                        //Finns personen så skicka det till hen


                    } else {
                        // här finns kod som ska lagra i unsentMessages
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



