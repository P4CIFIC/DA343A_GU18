package client;

public class ClientController {
    private Client client;


    public ClientController(Client client){
        this.client = client;
        client.setClientController(this);
    }
//Konstruktor utan parameter behövs för GUI:t
    public ClientController() {

    }


    public void send(Message message){
        client.send(message);
    }
    public void disconnect(){
        client.disconnect();
    }

    /*
    Anropas av gui:t när användaren klickar på ett meddelande i listan.
    Skickar valt index som parameter.

    Ska se till att gui:t uppdateras med en bild som visas
    public void messageChosen(int index){


     */
}