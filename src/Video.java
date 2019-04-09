import java.util.ArrayList;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;

public class Video {
  protected String title;
  protected ArrayList<VideoTag> tags;
  protected ArrayList<JLabel> groups;
  protected ImageIcon image;
  protected UserData user;
  protected String vidPath;

  Video(String title, ArrayList<JLabel> groups, ArrayList<VideoTag> tags, ImageIcon image, UserData user, String vidPath) {
    this.title = title;
    this.groups = groups;
    this.tags = tags;
    this.image = image;
    this.user = user;
    this.vidPath = vidPath;
  }

  Video(String title, ArrayList<JLabel> groups, ArrayList<VideoTag> tags, UserData user, String vidPath) {
    this.title = title;
    this.groups = groups;
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
    this.groups.add(new JLabel(entry));
    this.user.mapping.put(entry, this);
  }

  /*private void updateTag(String tag, String newTime) {
    int ii = this.tags.indexOf(tag);
    VideoTag updatedTag = this.tags.get(ii);
    updatedTag.addTime(newTime);
  }*/

  protected ArrayList<JLabel> getGroups() {
    return this.groups;
  }

  protected void sendHome() {
    JFrame frame = new HomePage("Home", this.user);
    frame.setSize(1000, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

}
