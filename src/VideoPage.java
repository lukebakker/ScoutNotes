import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Screen;


// TODO: Use model class, add video player
public class VideoPage extends JFrame {
  private JPanel vidPanel;

  private JButton homeButton, plusGroup, newTag;
  private JLabel groupHeader, myTags, gameTitle;
  private JList<String> tags;
  private ArrayList<JLabel> groups;
  private String[] dummyGroupList;
  private DefaultListModel<String> tagHolder;
  private Video videoObj;
  private JPanel videoPanel;


  // TODO: Make this constructor take a model object
  VideoPage(String title, Video vid) {
    super(title);
    setLayout(null);

    // Create the video player


    videoPanel = new JPanel();


    this.dummyGroupList = new String[]{"Football"};

    // Initialize dummy data for tags and groups, change this later to use the model
    if (vid.groups.isEmpty() && vid.tags.isEmpty()) {
      this.tagHolder = new DefaultListModel<>();
      // TODO: Delete dummy data
      this.tagHolder.addElement("Good catch");
      this.tagHolder.addElement("Pass rush");

      this.groups = initGroups();
    }
    // or use the actual model data
    else {
      this.tagHolder = vid.tags;
      this.groups = vid.groups;
    }

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
        JFrame groupAdder = new GroupAdder("Add Group");
        groupAdder.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        groupAdder.setLocation(700, 150);
        groupAdder.setSize(new Dimension(200,150));
        groupAdder.setVisible(true);
        ((GroupAdder) groupAdder).addDoneListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            // TODO: Feed this the actual text
            addGroup("Rams");
          }
        });
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
        JFrame frame = new HomePage("Home");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        dispose();
      }
    });

    this.newTag.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFrame tagAdder = new TagAdder("Add Tag");
        tagAdder.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tagAdder.setLocation(700, 150);
        tagAdder.setSize(new Dimension(200,150));
        tagAdder.setVisible(true);
        ((TagAdder) tagAdder).addDoneListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            // TODO: Feed this the actual text
            addTag("Sample Tag");
          }
        });
      }
    });

    this.videoObj = vid;

    // TODO: Use model data here
    this.gameTitle = new JLabel(title);
    this.gameTitle.setFont(defaultFont);

    // TODO: Add event listeners

    // Set up the page
    setLocations();
    initVideoPlayer();
    addComponents();

  }


  // TODO: Change this method to use the model
  private ArrayList<JLabel> initGroups() {
    ArrayList<JLabel> groupLabels = new ArrayList<>();
    for (String group : dummyGroupList) {
      groupLabels.add(new JLabel(group));
    }
    return groupLabels;
  }


  private void addGroup(String entry) {
    this.groups.add(new JLabel(entry));

    this.refreshLayout();
  }


  private void addTag(String entry) {
    this.tagHolder.addElement(entry);

    this.refreshLayout();
  }


  private void deleteTag(String tag) {
    this.tagHolder.removeElement(tag);
  }


  private void prevTag(JButton tagButton) {

  }


  private void goHome() {
    JFrame frame = new HomePage("ScoutNotes");
    frame.setSize(1000, 800);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setVisible(true);
  }


  private void refreshLayout() {
    JFrame frame = new VideoPage("Video Page", new Video(this.groups, this.tagHolder));
    frame.setSize(1000, 800);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
   //vidImg.setBounds(25,100,750,550);
    videoPanel.setBounds(25,100,750,550);
    tags.setBounds(800, 50, 175, 600);
  }


  private void addComponents() {
    add(homeButton);
    add(plusGroup);
    add(newTag);
    add(groupHeader);
    add(myTags);
    add(gameTitle);
    add(tags);
    add(videoPanel);
    for (JLabel gl : groups) {
      add(gl);
    }
  }

  private void initVideoPlayer(){
    final JFXPanel VFXPanel = new JFXPanel();

    File video_source = new File("videos/EdelmanCatch.mp4");
    Media m = new Media(video_source.toURI().toString());
    MediaPlayer player = new MediaPlayer(m);
    MediaView viewer = new MediaView(player);
    MediaControl mediaControl = new MediaControl(player);

    StackPane root = new StackPane();
    Scene scene = new Scene(root);
    scene.setRoot(mediaControl);


    // center video position
    javafx.geometry.Rectangle2D screen = Screen.getPrimary().getVisualBounds();
    viewer.setX((screen.getWidth() - videoPanel.getWidth()) / 2);
    viewer.setY((screen.getHeight() - videoPanel.getHeight()) / 2);

    // resize video based on screen size
    DoubleProperty width = viewer.fitWidthProperty();
    DoubleProperty height = viewer.fitHeightProperty();
    width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
    height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
    viewer.setPreserveRatio(true);

    // add video to stackpane
    root.getChildren().add(viewer);

    VFXPanel.setScene(scene);
    videoPanel.setLayout(new BorderLayout());
    videoPanel.add(VFXPanel, BorderLayout.CENTER);
  }


}
