import java.util.ArrayList;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;

public class Video {
  protected String title;
  protected ArrayList<VideoTag> tags;
  protected ArrayList<String> groups;
  protected ImageIcon image;
  protected UserData user;
  protected String vidPath;

  Video(String title, ArrayList<VideoTag> tags, ImageIcon image, UserData user, String vidPath) {
    this.title = title;
    this.tags = tags;
    this.image = image;
    this.user = user;
    this.vidPath = vidPath;
  }

  Video(String title, ArrayList<VideoTag> tags, UserData user, String vidPath) {
    this.title = title;
    this.tags = tags;
    this.image = new ImageIcon(getClass().getResource("/vid-player.png"));
    this.user = user;
    this.vidPath = vidPath;
  }

  protected void addTag(String entry, String newTime) {
    // Add tag at the desired time
    this.tags.add(new VideoTag(entry, newTime));
  }

  protected void addGroup(String entry) {
    this.user.addGroupToVid(this, entry);
  }

  protected ArrayList<String> getGroups() {
    return this.user.getGroupsByVideo(this);
  }

  protected void sendHome() {
    JFrame frame = new HomePage("Home", this.user);
    frame.setSize(1000, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  protected void removeGroup(String gName) {
    this.groups.remove(gName);
    this.user.mapping.remove(gName, this);
    System.out.println(this.groups);
    System.out.println(this.user.mapping);
  }

}
