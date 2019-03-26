import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JApplet;

// TODO: Use model class, add video player
public class VideoPage extends JFrame {
  private JButton homeButton, plusGroup, newTag, vidImg;
  private JLabel groupHeader, myTags, gameTitle;
  private JList<String> tags;
  private ArrayList<JLabel> groups;
  private DefaultListModel<String> tagHolder;
  private Video videoObj;
  private String title;
  private VideoPage page;


  // TODO: Make this constructor take a model object
  VideoPage(String title, Video vid) {
    super(vid.title);
    this.title = vid.title;
    setLayout(null);
    this.page = this;


    this.tagHolder = new DefaultListModel<String>();
    for (VideoTag t : vid.tags) {
      this.tagHolder.addElement(t.getText());
    }
    this.groups = vid.groups;

    this.tags = new JList<>(this.tagHolder);

    Font defaultFont = new Font("Serif", Font.BOLD, 24);

    // Labels indicating groups and tags for the video
    this.groupHeader = new JLabel("Groups:");
    this.groupHeader.setFont(defaultFont);
    this.myTags = new JLabel("My Tags");
    this.myTags.setFont(defaultFont);
    // Create the + button to add a group label to the video
    this.plusGroup = new JButton();
    ImageIcon plusIcon = resizeImage(new ImageIcon(getClass().getResource("/plus-sign.png")), 25, 25);
    this.plusGroup.setIcon(plusIcon);

    // Add listener for adding group
    this.plusGroup.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFrame groupAdder = new GroupAdder("Add Group", page);
        groupAdder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        groupAdder.setLocation(700, 150);
        groupAdder.setSize(new Dimension(200,150));
        groupAdder.setVisible(true);
      }
    });

    // Create the button to navigate back to the home page
    this.homeButton = new JButton();
    ImageIcon homeIcon = resizeImage(new ImageIcon(getClass().getResource("/HomeIcon.png")), 25, 25);
    this.homeButton.setIcon(homeIcon);
    // Create the button to add a new tag
    this.newTag = new JButton("New Tag");
    this.newTag.setFont(defaultFont);
    this.newTag.setPreferredSize(new Dimension(100,10));

    homeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        videoObj.sendHome();
      }
    });

    this.newTag.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFrame tagAdder = new TagAdder("Add Tag", page);
        tagAdder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tagAdder.setLocation(700, 150);
        tagAdder.setSize(new Dimension(200,150));
        tagAdder.setVisible(true);
      }
    });

    this.videoObj = vid;

    // TODO: Use model data here
    this.gameTitle = new JLabel(title);
    this.gameTitle.setFont(defaultFont);

    // TODO: Add video player
    ImageIcon vidPlayer = resizeImage(new ImageIcon(getClass().getResource("/vid-player.png")), 750, 550);
    this.vidImg = new JButton();
    this.vidImg.setIcon(vidPlayer);

    // TODO: Add event listeners

    // Set up the page
    setLocations();
    addComponents();

  }


  void addGroup(String entry) {
    this.videoObj.addGroup(entry);

    this.refreshLayout();
  }


  void addTag(String entry, String time) {
    this.videoObj.addTag(entry, "00:00");

    this.refreshLayout();
  }


  //private void deleteTag(String tag) {
  //  this.tagHolder.removeElement(tag);
  //}


  private void prevTag(JButton tagButton) {

  }


  protected void refreshLayout() {
    JFrame frame = new VideoPage(this.title, this.videoObj);
    frame.setSize(1000, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    dispose();

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
    for (JLabel gl : this.groups) {
      gl.setBounds(curX, 25, 75, 25);
      curX += 75;
    }
    plusGroup.setBounds(curX, 25,25,25);

    newTag.setBounds(800, 700, 150, 50);
    myTags.setBounds(800, 25, 100, 25);
    gameTitle.setBounds(50, 75, 250, 25);
    vidImg.setBounds(25,100,750,550);
    tags.setBounds(800, 50, 175, 600);
  }


  private void addComponents() {
    add(homeButton);
    add(plusGroup);
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
