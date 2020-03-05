package server;

import client.Message;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {

    private AllClients allClients;
    private OnlineClients onlineClients;
    private Message message;

    public ServerController(int port) {
        new Connection(port).start();
    }

    private class Connection extends Thread {

        private int port;

        public Connection(int port) {
            this.port = port;
            allClients = new AllClients();
        }

        @Override
        public void run() {
            Socket socket;
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                while (true) {
                    socket = serverSocket.accept();
                    new ClientHandler(socket);
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

        public ClientHandler(Socket socket) {

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
                    message = (Message) ois.readObject();
                    if (socket == null) {
                        messages.add(message);
                    }


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



