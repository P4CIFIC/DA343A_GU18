package server;

import client.User;
import com.sun.security.ntlm.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerController {

    private Clients clients = new Clients();

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
                        socket = serverSocket.accept();


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



