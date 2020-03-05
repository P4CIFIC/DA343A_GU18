package GuiClient;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;

public class MessageListPanel extends JPanel {
    private JList messages ;
    private JScrollPane scrollpane;
    private JLabel jLabel = new JLabel("Messages");
    public MessageListPanel(){
        setPreferredSize(new Dimension(200,400));
        String[] arr = {""};
        setLayout(new BorderLayout());
        messages = new JList(arr);
        scrollpane = new JScrollPane(messages);
        //messages.setBackground(Color.LIGHT_GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createTitledBorder("Message list"));
        add(jLabel, BorderLayout.NORTH);
        add(scrollpane, BorderLayout.CENTER);
    }
    public void refreshMessageList(String[] arr){
        messages.setListData(arr);
    }

    public static void main(String[] args) {
        String[] bajs = new String[10];
        for (int i = 0; i<bajs.length; i++){
            bajs[i] = String.valueOf(i);
        }
        JOptionPane.showMessageDialog(null,new MessageListPanel());
    }

}
