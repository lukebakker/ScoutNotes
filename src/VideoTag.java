import java.sql.Timestamp;

import javax.swing.*;

public class VideoTag {
  private String text;
  private String time;

  VideoTag(String text, String time) {
    this.text = text;
    this.time = time;
  }

  String getText() {
    return this.text;
  }

  String getTime() { return this.time; }

  int getMs() {
    String[] split_time = this.time.split(":");
    int min = Integer.parseInt(split_time[0]);
    int sec = Integer.parseInt(split_time[1]);

    return (min * 60 + sec) * 1000;
  }

}
