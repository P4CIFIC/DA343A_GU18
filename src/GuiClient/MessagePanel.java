package GuiClient;

import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel {
    private JList messages = new JList();
    private JScrollPane Scrollpane = new JScrollPane(messages);
    public MessagePanel (){
        setPreferredSize(new Dimension(200,400));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Message list"));
        add(Scrollpane);
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,new MessagePanel());
    }
}
