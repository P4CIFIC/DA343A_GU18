package GuiClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

public class TextPanel extends JPanel {
    private JPanel pnlNorth = new JPanel(new BorderLayout());
    private JPanel pnlSouth = new JPanel(new FlowLayout());
    private JTextArea JTAmessages = new JTextArea();
    private JLabel labelMessage = new JLabel("hejsnabajsam");
    private JTextArea JTWriteMessage = new JTextArea();
    private JScrollPane scrollpanemessages = new JScrollPane(JTAmessages);
    private JScrollPane scrollPaneJTAsouth = new JScrollPane(JTWriteMessage);
    private JPanel pnlSouthEast = new JPanel(new GridLayout(2,1,5,2));
    private JButton JBSend = new JButton("Send");
    private JButton JBaddPic = new JButton("Add picture");
    private MainPanel mainPanel;
    private ImageIcon picture = new ImageIcon("images/Hippo.jpg");
    private JLabel JLPicture = new JLabel(picture);

    public TextPanel(MainPanel panel){
       setPreferredSize(new Dimension(400,400));
       setLayout(new BorderLayout());
       this.mainPanel = panel;
       pnlNorth.setPreferredSize(new Dimension(400,290));
       pnlSouth.setPreferredSize(new Dimension(400,100));
       pnlSouthEast.setPreferredSize(new Dimension(120,100));
       scrollPaneJTAsouth.setPreferredSize(new Dimension(200,100));
       scrollpanemessages.setPreferredSize(new Dimension(100,20));
       scrollPaneJTAsouth.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);


       JBSend.addActionListener(new listener());
       pnlSouthEast.add(JBSend);
       pnlSouthEast.add(JBaddPic);
       pnlSouthEast.setBorder(BorderFactory.createEmptyBorder(7,7,7,7));
       JTWriteMessage.setBorder(BorderFactory.createEmptyBorder(7,7,7,7));
       pnlNorth.add(JLPicture, BorderLayout.NORTH);
       //pnlNorth.add(scrollpanemessages, BorderLayout.CENTER);
        pnlNorth.add(labelMessage, BorderLayout.SOUTH);
       pnlSouth.add(scrollPaneJTAsouth);
       pnlSouth.add(pnlSouthEast);

       add(pnlNorth, BorderLayout.NORTH);
       add(pnlSouth, BorderLayout.SOUTH);

   }
   public String getTextForMessage(){
       return JTWriteMessage.getText();
   }
   public void appendTextToTextArea(String MessageText){
        JTAmessages.append(MessageText+"\n");
   }
   private class listener implements ActionListener{

       @Override
       public void actionPerformed(ActionEvent e) {
           if(e.getSource() == JBSend){
               String temp = JTWriteMessage.getText();
               mainPanel.messageSent(temp);
               appendTextToTextArea(temp);
               JTWriteMessage.setText("");


           }
       }
   }
    public static void main(String[] args) {

    }
}
