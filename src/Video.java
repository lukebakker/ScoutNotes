import java.util.ArrayList;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;

public class Video {
  protected String title;
  protected ArrayList<VideoTag> tags;
  protected ArrayList<JLabel> groups;
  protected ImageIcon image;
  protected UserData user;

  Video(String title, ArrayList<JLabel> groups, ArrayList<VideoTag> tags, ImageIcon image, UserData user) {
    this.title = title;
    this.groups = groups;
    this.tags = tags;
    this.image = image;
    this.user = user;
  }

  Video(String title, ArrayList<JLabel> groups, ArrayList<VideoTag> tags, UserData user) {
    this.title = title;
    this.groups = groups;
    this.tags = tags;
    this.image = new ImageIcon(getClass().getResource("/vid-player.png"));
    this.user = user;
  }

  protected void addTag(String entry, String newTime) {
    ArrayList<String> tagStrings = new ArrayList<String>();
    for (VideoTag t : tags) {
      tagStrings.add(t.getText());
    }
    // If the tag is already present, add the newly desired time
    /*if (tagStrings.contains(entry)) {
      updateTag(entry, newTime);
    }*/
    // If the tag does not exist in this video yet, add it at the desired time
    this.tags.add(new VideoTag(entry, newTime));
  }

  protected void addGroup(String entry) {
    this.groups.add(new JLabel(entry));
    System.out.println("Added to model");
    System.out.println(entry);
    System.out.println(this.groups);
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
