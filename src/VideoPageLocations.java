import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JApplet;

// TODO: Use model class, add video player
public class VideoPageLocations extends JFrame {
  private Container northContainer, eastContainer, centerContainer, mainContainer;
  private JButton homeButton, addGroup, newTag, vidImg;
  private JLabel groupHeader, myTags, gameTitle;
  private JList<JButton> tags;
  private ArrayList<JLabel> groups;
  private String[] tagList;
  private String[] groupList;
  private JPanel resultPanel;


  // TODO: Make this constructor take a model object
  VideoPageLocations(String title) {
    super(title);
    setLayout(null);

    Font defaultFont = new Font("Serif", Font.BOLD, 24);

    // Labels indicating groups and tags for the video
    this.groupHeader = new JLabel("Groups:");
    this.groupHeader.setFont(defaultFont);
    this.myTags = new JLabel("My Tags");
    this.myTags.setFont(defaultFont);
    // Create the + button to add a group label to the video
    this.addGroup = new JButton();
    ImageIcon plusIcon = resizeImage(new ImageIcon("./images/plus-sign.png"), 25, 25);
    this.addGroup.setIcon(plusIcon);
    // Create the button to navigate back to the home page
    this.homeButton = new JButton();
    ImageIcon homeIcon = resizeImage(new ImageIcon("./images/HomeIcon.png"), 25, 25);
    this.homeButton.setIcon(homeIcon);
    // Create the button to add a new tag
    this.newTag = new JButton("New Tag");
    this.newTag.setFont(defaultFont);
    this.newTag.setPreferredSize(new Dimension(100,10));

    // TODO: Use model data here
    // Initialize dummy data for tags and groups, change this later to use the model
    this.tagList = new String[]{"Good catch", "Pass rush"};
    this.groupList = new String[]{"Football"};
    this.gameTitle = new JLabel("Game Title Here");
    this.gameTitle.setFont(defaultFont);

    // TODO: Add video player
    ImageIcon vidPlayer = resizeImage(new ImageIcon("./images/vid-player.png"), 750, 550);
    this.vidImg = new JButton();
    this.vidImg.setIcon(vidPlayer);

    // These can stay the same
    this.tags = initLabels();
    this.groups = initGroups();

    setLocations();
    addComponents();

  }


  // TODO: Change this method to use the model
  private JList<JButton> initLabels() {
    JList<JButton> tagLabels = new JList<>();
    for (String tag : tagList) {
      tagLabels.add(new JButton(tag));
    }
    return tagLabels;
  }


  // TODO: Change this method to use the model
  private ArrayList<JLabel> initGroups() {
    ArrayList<JLabel> groupLabels = new ArrayList<>();
    for (String group : groupList) {
      groupLabels.add(new JLabel(group));
    }
    return groupLabels;
  }


  private void setLocation() {

  }


  private void addGroup() {

  }


  private void newTag() {

  }


  private void prevTag(JButton tagButton) {

  }


  private void goHome() {

  }


  private void updateLayout() {

  }


  private ImageIcon resizeImage(ImageIcon imgIcon, int x, int y) {
    Image img = imgIcon.getImage();
    Image resizedImg = img.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
    imgIcon = new ImageIcon(resizedImg);
    return imgIcon;
  }


  private void setLocations() {

    homeButton.setBounds(25, 25, 25, 25);
    groupHeader.setBounds(75, 25, 100, 25);
    int curX = 175;
    for (JLabel gl : groups) {
      gl.setBounds(curX, 25, 75, 25);
      curX += 75;
    }
    addGroup.setBounds(curX, 25,25,25);

    newTag.setBounds(800, 700, 150, 50);
    myTags.setBounds(800, 25, 100, 25);
    gameTitle.setBounds(100, 75, 250, 25);
    vidImg.setBounds(25,100,750,550);
    tags.setBounds(800, 50, 175, 600);
  }


  private void addComponents() {
    add(homeButton);
    add(addGroup);
    add(newTag);
    add(groupHeader);
    add(myTags);
    add(gameTitle);
    add(vidImg);
    add(tags);
    for (JLabel gl : groups) {
      add(gl);
    }
  }


}
