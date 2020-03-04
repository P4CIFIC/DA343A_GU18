package Client;

import javax.swing.*;

public class User {

    private String name;
    private ImageIcon profilePic;

    public User(String name, ImageIcon profilePic) {
        this.name = name;
        this.profilePic = profilePic;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getProfilePic() {
        return profilePic;
    }
}
