package GuiClient;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

public class ContactListPanel extends JPanel {
    private String[] contactListArray;
    private JList<String> contactList;
    private JScrollPane scrollPane;
    private JLabel contactListLabel = new JLabel("Contact list");
    public ContactListPanel(String[] contactListArray){
        setPreferredSize(new Dimension(150,400));
        contactListLabel.setPreferredSize(new Dimension(150,20));
        setLayout(new BorderLayout());
        this.contactListArray = contactListArray;
        contactList = new JList<String>(contactListArray);
        this.scrollPane  = new JScrollPane(contactList);

        setBorder(BorderFactory.createTitledBorder("Contact list"));
        add(scrollPane, BorderLayout.CENTER);
        //add(contactListLabel, BorderLayout.NORTH);

    }
    public void refreshContactList(String[] contactListArray){
        this.contactListArray = contactListArray;
        repaint();

    }}
