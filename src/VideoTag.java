import java.sql.Timestamp;

import javax.swing.*;

public class VideoTag {
  private String text;
  private DefaultListModel<String> times;

  VideoTag(String text, String newTime) {
    this.text = text;
    this.times = new DefaultListModel<>();

    this.times.addElement(newTime);
  }

  String getText() {
    return this.text;
  }

  void addTime(String time) {
    this.times.addElement(time);
  }

}
