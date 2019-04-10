import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

class LoginFrame extends JFrame {
  private JLabel usernameLabel, passwordLabel, scoutNotes;
  private JButton done;
  private JTextField username;
  private JPasswordField password;
  private Container container;
  private UserData testUser;
  private String[] dummyGroupList;
  private ArrayList<Video> dummyData;
  private ArrayList<VideoTag> defaultTags1, defaultTags2, defaultTags3, defaultTags4, defaultTags5;
  private ArrayList<Video> userVideos;
  private ArrayList<JLabel> dummyTags;
  private ArrayList<String> userGroups;
  private Video dolphinsVBengals, jetsVPatriots, cowboysVDolphins,
          jetsVRams, patriotsVRams;
  HomePage testUserFrame;

  LoginFrame(String title) {
    super(title);

    setLayout(null);
    scoutNotes = new JLabel ("Scout Notes");
    scoutNotes.setFont(new Font("Serif", Font.BOLD, 36));

    // Initialize all dummy data

    this.dummyGroupList = new String[]{"Football"};

    // initialize dummy data
    this.defaultTags1 = new ArrayList<>();
    this.defaultTags1.add(new VideoTag("Good catch", "00:41"));
    this.defaultTags1.add(new VideoTag("Nice block", "00:12"));

    this.defaultTags2 = new ArrayList<>();
    this.defaultTags2.add(new VideoTag("Good catch", "00:41"));
    this.defaultTags2.add(new VideoTag("Nice block", "00:12"));

    this.defaultTags3 = new ArrayList<>();
    this.defaultTags3.add(new VideoTag("Good catch", "00:41"));
    this.defaultTags3.add(new VideoTag("Nice block", "00:12"));

    this.defaultTags4 = new ArrayList<>();
    this.defaultTags4.add(new VideoTag("Good catch", "00:41"));
    this.defaultTags4.add(new VideoTag("Nice block", "00:12"));

    this.defaultTags5 = new ArrayList<>();
    this.defaultTags5.add(new VideoTag("Good catch", "00:41"));
    this.defaultTags5.add(new VideoTag("Nice block", "00:12"));

    ImageIcon cowboysVDolphinsImg = new ImageIcon(getClass().getResource("/CowboysVDolphins.jpg"));
    ImageIcon dolphinsVBengalsImg = new ImageIcon(getClass().getResource("/DolphinsVBengals.jpeg"));
    ImageIcon jetsVPatriotsImg = new ImageIcon(getClass().getResource("/JetsVPatriots.jpeg"));
    ImageIcon jetsVRamsImg = new ImageIcon(getClass().getResource("/JetsVRams.jpg"));
    ImageIcon patriotsVRamsImg = new ImageIcon(getClass().getResource("/PatriotsVRams.jpeg"));

    this.userVideos = new ArrayList<>();
    HashMap<Video, ArrayList<String>> userMap = new HashMap<>();

    testUser = new UserData("username", "password", this.userVideos, userMap);

    dolphinsVBengals = new Video("Dolphins vs. Bengals", this.defaultTags1, dolphinsVBengalsImg, testUser, "videos/dolphins-bengals.mp4");
    jetsVPatriots = new Video("Jets vs. Patriots", this.defaultTags2, jetsVPatriotsImg, testUser, "videos/jets-patriots.mp4");
    cowboysVDolphins = new Video("Cowboys vs. Dolphins", this.defaultTags3, cowboysVDolphinsImg, testUser, "videos/cowboys-dolphins.mp4");
    jetsVRams = new Video("Jets vs. Rams", this.defaultTags4, jetsVRamsImg, testUser, "videos/jets-rams.mp4");
    patriotsVRams = new Video("Patriots vs. Rams", this.defaultTags5, patriotsVRamsImg, testUser, "videos/patriots-rams.mp4");

    ArrayList<String> grouplist1 = new ArrayList<>();
    ArrayList<String> grouplist2 = new ArrayList<>();
    ArrayList<String> grouplist3 = new ArrayList<>();
    ArrayList<String> grouplist4 = new ArrayList<>();
    ArrayList<String> grouplist5 = new ArrayList<>();

    grouplist1.add("Football");
    grouplist2.add("Football");
    grouplist3.add("Football");
    grouplist4.add("Football");
    grouplist5.add("Football");

    userMap.put(dolphinsVBengals, grouplist1);
    userMap.put(jetsVPatriots, grouplist2);
    userMap.put(cowboysVDolphins, grouplist3);
    userMap.put(jetsVRams, grouplist4);
    userMap.put(patriotsVRams, grouplist5);

    this.userVideos.add(dolphinsVBengals);
    this.userVideos.add(jetsVPatriots);
    this.userVideos.add(cowboysVDolphins);
    this.userVideos.add(jetsVRams);
    this.userVideos.add(patriotsVRams);


    usernameLabel = new JLabel("Username:");
    passwordLabel = new JLabel("Password:");
    username = new JTextField();
    password = new JPasswordField();
    done = new JButton("Login");

    testUserFrame = new HomePage("Home", testUser);

    container = getContentPane();

    setLocation();
    addComponents();


    done.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(username.getText().equals("username") && password.getText().equals("password")|| true) {
          testUserFrame = new HomePage("Home", testUser);
          testUserFrame.setSize(1000, 800);
          testUserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          testUserFrame.setVisible(true);
          dispose();
        }
      }
    });

  }

  private void setLocation() {
    scoutNotes.setBounds(350,100,200,50);
    usernameLabel.setBounds(350,200,100,30);
    passwordLabel.setBounds(350,240,100,30);
    username.setBounds(450,200,150,30);
    password.setBounds(450,240,150,30);
    done.setBounds(350,280,250,30);
  }

  private void addComponents() {
    container.add(scoutNotes);
    container.add(usernameLabel);
    container.add(passwordLabel);
    container.add(username);
    container.add(password);
    container.add(done);
  }

}
