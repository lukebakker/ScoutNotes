import java.util.ArrayList;
import java.util.HashMap;

class UserData {
  String username;
  String password;
  ArrayList<Video> videos;
  HashMap<String, Video> mapping;

  UserData(String username, String password, ArrayList<Video> videos, HashMap<String, Video> mapping) {
    this.username = username;
    this.password = password;
    this.videos = videos;
    this.mapping = mapping;
  }

}
