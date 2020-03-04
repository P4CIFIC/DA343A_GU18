package Client;

public class ClientController {
    private Client client;


    public ClientController(Client client){
        this.client = client;
        client.setClientController(this);
    }


    public void send(Message message){
        client.send(message);
    }
    public void disconnect(){
        client.disconnect();
    }

}