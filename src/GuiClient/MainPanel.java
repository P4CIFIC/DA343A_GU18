package GuiClient;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private ClientController clientController;
   private  ContactListPanel contactListPanel;
   private TextPanel textPanel = new TextPanel(this);
   private MessagePanel messagePanel;
   public MainPanel(String [] contactlistArray,ClientController controller){
       this.clientController = controller;
       setLayout(new BorderLayout());
       contactListPanel = new ContactListPanel(contactlistArray);
       messagePanel = new MessagePanel();
       setPreferredSize(new Dimension(800,400));
       add(contactListPanel, BorderLayout.WEST);
       add(textPanel, BorderLayout.CENTER);
       add(messagePanel, BorderLayout.EAST);
       refreshContactList(contactlistArray);
       showPanelinFrame();
       repaint();
   }
   public String getText(){
       return textPanel.getTextForMessage();
   }
   public void messageSent(String message){

   }
   public void appendText(String Messagetext){
       textPanel.appendTextToTextArea(Messagetext);

   }
   public void showPanelinFrame(){
       JFrame frame = new JFrame("Messanger");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.add(this);
       frame.pack();
       frame.setVisible(true);
   }
   public void refreshContactList(String[] contactlist){
       contactListPanel.refreshContactList(contactlist);
   }

    public static void main(String[] args) {
        String[] arr = new String[3];
        arr[0] = "a";
        arr[1] = "b";
        arr[2] = "c";
        MainPanel panel = new MainPanel(arr, new ClientController());
    }
}
