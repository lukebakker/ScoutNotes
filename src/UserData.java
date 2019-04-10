import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class UserData {
  String username;
  String password;
  ArrayList<Video> videos;
  HashMap<Video, ArrayList<String>> mapping;

  UserData(String username, String password, ArrayList<Video> videos, HashMap<Video, ArrayList<String>> mapping) {
    this.username = username;
    this.password = password;
    this.videos = videos;
    this.mapping = mapping;
  }

  ArrayList<String> getGroupsByVideo(Video vid) {

    return mapping.get(vid);
  }

  public void addGroupToVid(Video video, String entry) {
    ArrayList<String> newGroupList = this.mapping.get(video);
    if (newGroupList == null) {
      newGroupList = new ArrayList<>();
    }
    newGroupList.add(entry);

    this.mapping.put(video, newGroupList);
  }
}
