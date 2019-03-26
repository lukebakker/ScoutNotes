import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
  private ArrayList<VideoTag> defaultTags;
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
    this.defaultTags = new ArrayList<>();
    this.defaultTags.add(new VideoTag("Good catch", "00:00"));
    this.defaultTags.add(new VideoTag("Nice block", "00:00"));

    this.dummyTags = new ArrayList<>();
    this.dummyTags.add(new JLabel("Football"));

    ImageIcon cowboysVDolphinsImg = new ImageIcon(getClass().getResource("/CowboysVDolphins.jpg"));
    ImageIcon dolphinsVBengalsImg = new ImageIcon(getClass().getResource("/DolphinsVBengals.jpeg"));
    ImageIcon jetsVPatriotsImg = new ImageIcon(getClass().getResource("/JetsVPatriots.jpeg"));
    ImageIcon jetsVRamsImg = new ImageIcon(getClass().getResource("/JetsVRams.jpg"));
    ImageIcon patriotsVRamsImg = new ImageIcon(getClass().getResource("/PatriotsVRams.jpeg"));

    this.userVideos = new ArrayList<>();

    this.userGroups = new ArrayList<>();

    testUser = new UserData("username", "password", this.userVideos, this.userGroups);

    dolphinsVBengals = new Video("Dolphins vs. Bengals", this.dummyTags, this.defaultTags, dolphinsVBengalsImg, testUser);
    jetsVPatriots = new Video("Jets vs. Patriots", this.dummyTags, this.defaultTags, jetsVPatriotsImg, testUser);
    cowboysVDolphins = new Video("Cowboys vs. Dolphins", this.dummyTags, this.defaultTags, cowboysVDolphinsImg, testUser);
    jetsVRams = new Video("Jets vs. Rams", this.dummyTags, this.defaultTags, jetsVRamsImg, testUser);
    patriotsVRams = new Video("Patriots vs. Rams", this.dummyTags, this.defaultTags, patriotsVRamsImg, testUser);

    this.userGroups.add("Jets");
    this.userGroups.add("Patriots");
    this.userGroups.add("Dolphins");

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
