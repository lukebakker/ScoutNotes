import java.util.ArrayList;

public class UserData {
  String username;
  String password;
  ArrayList<Video> videos;
  ArrayList<String> groups;

  UserData(String username, String password, ArrayList<Video> videos, ArrayList<String> groups) {
    this.username = username;
    this.password = password;
    this.videos = videos;
    this.groups = groups;
  }

  UserData(String username, String password) {
    this.username = username;
    this.password = password;
    this.videos = new ArrayList<>();
    this.groups = new ArrayList<>();
  }

}
