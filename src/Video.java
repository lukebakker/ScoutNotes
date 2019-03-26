import java.util.ArrayList;

import javax.swing.*;

public class Video {
  protected DefaultListModel<String> tags;
  protected ArrayList<JLabel> groups;

  Video(ArrayList<JLabel> groups, DefaultListModel<String> tags) {
    this.groups = groups;
    this.tags = tags;

  }

  protected void addTag(String entry) {
    this.tags.addElement(entry);
  }

  protected void addGroup(String entry) {
    this.groups.add(new JLabel(entry));
  }

  protected ArrayList<JLabel> getGroups() {
    return this.groups;
  }
}
