package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {

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

                if () {

                    //är personen en ny användare? dvs kolla user och lagra namn samt bild där om personen inte finns sedan tidigare
                }

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
