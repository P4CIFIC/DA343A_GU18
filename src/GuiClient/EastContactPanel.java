package GuiClient;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class EastContactPanel extends JPanel {
    private File picture = new File("pictures/test.png.png");
    private JLabel JLName = new JLabel("Name: ");
    private JLabel JLNameC = new JLabel("");
    private ImageIcon ContactPicutere = new ImageIcon("pictures/test.png.png");
    private JLabel JLPicture = new JLabel(ContactPicutere);
    public EastContactPanel(){
        setPreferredSize(new Dimension(100,100));
        JLName.setPreferredSize(new Dimension(10,20));
        JLNameC.setPreferredSize(new Dimension(10,20));
        add(JLName);
        add(JLNameC);
        JLPicture.setPreferredSize(new Dimension(20,40));
        add(JLPicture);

    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,new EastContactPanel());
    }

}
