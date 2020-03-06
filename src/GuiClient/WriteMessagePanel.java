package GuiClient;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;

public class WriteMessagePanel extends JPanel {
    private  ImageIcon icon;
   private JPanel panel = new JPanel(new BorderLayout());
   private JTextArea jTextArea = new JTextArea();
   private JScrollPane jScrollPane = new JScrollPane(jTextArea);
    private JButton buttonSend = new JButton("Send");
    private JButton buttonExit = new JButton("Close");
    private JButton buttonAddPicture = new JButton("Add picture");
    private JPanel panelButtons = new JPanel(new GridLayout());
    private JFileChooser fileChooser;
    private MessageShowPanel messageShowPanel;
    public WriteMessagePanel (String name, MessageShowPanel messageShowPanel){
        setPreferredSize(new Dimension(600,400));
        setLayout(new BorderLayout());
        this.messageShowPanel = messageShowPanel;
        panel.setBorder(new TitledBorder("Writing a message to " +name));
        panel.add(jScrollPane);

        //actionlisteners

        buttonSend.addActionListener(e -> sendMessage());
        buttonAddPicture.addActionListener(e -> addPicture());
        panelButtons.add(buttonSend);
        panelButtons.add(buttonAddPicture);
        panelButtons.add(buttonExit);
        add(panel);
        add(panelButtons,BorderLayout.SOUTH);

    }
    public void sendMessage(){

    }
    public void addPicture(){
        fileChooser= new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
            System.out.println(selectedFile.getAbsolutePath());
            setupImage(selectedFile);

        }


    }
    public void setupImage(File file){
        icon = new ImageIcon(file.getAbsolutePath());
    }
    public ImageIcon getImageIcon(){
        if(icon != null){

        }
        return icon;
    }


    public void showPanelinFrame(){
        JFrame frame = new JFrame("Write your message");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
    }


}
