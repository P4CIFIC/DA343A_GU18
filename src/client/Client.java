package client;

import java.io.*;
import java.net.Socket;

public class

Client {
    private ClientController controller;
    private Socket socket;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    public Client(String ip, int port) throws IOException {

        socket = new Socket(ip,port);

        ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        new Reciever().start();
    }
    public void setClientController(ClientController controller) {
        this.controller = controller;
    }



    public void send(Message message){
        try {
            oos.writeObject(message);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Reciever extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    ois.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
