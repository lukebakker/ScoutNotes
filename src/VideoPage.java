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
import javafx.util.Duration;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

// TODO: Use model class, add video player
public class VideoPage extends JFrame {
  private JButton homeButton, plusGroup, newTag, vidImg;
  private JLabel groupHeader, myTags, gameTitle;
  private JList<String> tags;
  private ArrayList<String> groups;
  private Video videoObj;
  private String title;
  private VideoPage page;
  private JFXPanel VFXPanel;
  private MediaControl mediaControl;
  private JPanel videoPanel, tagPanel;
  private JScrollPane tagScroll, groupScroll;
  private Font defaultFont;

  // TODO: Make this constructor take a model object
  VideoPage(String title, Video vid) {
    super(vid.title);
    this.title = vid.title;
    setLayout(null);
    this.page = this;
    this.videoObj = vid;

    videoPanel = new JPanel();

    this.groups = vid.getGroups();

    buildTagPanel();

    Font defaultFont = new Font("Serif", Font.BOLD, 24);

    buildGroups();

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
        dispose();
      }
    });

    this.newTag.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFrame tagAdder = new TagAdder("Add Tag", page);
        tagAdder.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tagAdder.setLocation(700, 150);
        tagAdder.setSize(new Dimension(200,200));
        tagAdder.setVisible(true);
      }
    });

    this.videoObj = vid;

    this.gameTitle = new JLabel(title);
    this.gameTitle.setFont(defaultFont);

    // TODO: Add event listeners

    // Set up the page
    setLocations();
    initVideoPlayer();
    addComponents();

  }


  void addGroup(String entry) {
    this.videoObj.addGroup(entry);

    refreshGroups();

    //this.refreshLayout();
  }


  void addTag(String entry, String time) {
    this.videoObj.addTag(entry, time);

    refreshTags();

    //this.refreshLayout();
  }


  private ImageIcon resizeImage(ImageIcon imgIcon, int x, int y) {
    Image img = imgIcon.getImage();
    Image resizedImg = img.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
    imgIcon = new ImageIcon(resizedImg);
    return imgIcon;
  }


  private void setLocations() {
    homeButton.setBounds(25, 25, 40, 40);
    newTag.setBounds(800, 700, 150, 50);
    myTags.setBounds(800, 25, 100, 25);
    gameTitle.setBounds(50, 100, 250, 25);
    videoPanel.setBounds(25,125,750,550);
    tagScroll.setBounds(800, 50, 375, 600);
  }

  private void buildGroups() {
    // Labels indicating groups and tags for the video
    this.groupHeader = new JLabel("Groups:");
    this.groupHeader.setFont(defaultFont);
    this.myTags = new JLabel("My Tags");
    this.myTags.setFont(defaultFont);

    System.out.println(this.groups);

    groupHeader.setBounds(75, 25, 50, 25);

    // Create the + button to add a group label to the video
    this.plusGroup = new JButton();
    ImageIcon plusIcon = resizeImage(new ImageIcon(getClass().getResource("/plus-sign.png")), 20, 20);
    this.plusGroup.setIcon(plusIcon);

    // Add listener for adding group
    this.plusGroup.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFrame groupAdder = new GroupAdder("Add Group", page);
        groupAdder.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        groupAdder.setLocation(700, 150);
        groupAdder.setSize(new Dimension(200,150));
        groupAdder.setVisible(true);
      }
    });

    this.plusGroup.setBounds(125, 25, 30, 30);

    JPanel groupPane = new JPanel();
    groupPane.setLayout(new BoxLayout(groupPane, BoxLayout.LINE_AXIS));

    groupScroll = new JScrollPane(groupPane, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    groupScroll.setBounds(175, 25, 600, 50);

    for (String gl : this.groups) {
      JButton gButton = new JButton(gl);
      groupPane.add(gButton);
      gButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          videoObj.removeGroup(gButton.getText());
          refreshGroups();
        }
      });
    }

  }

  private void buildTagPanel() {
    tagPanel = new JPanel();
    ImageIcon deleteImgIcon = resizeImage(new ImageIcon(getClass().getResource("/delete-icon.jpg")), 20, 10);
    int cntr = 0;

    for (VideoTag tag : this.videoObj.tags) {
      cntr++;
      // Create horizontal pane with delete, previous tag, and go-to-time buttons
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));

      JButton delButton = new JButton(deleteImgIcon);
      delButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          deleteTag(tag);
        }
      });

      JButton tagButton = new JButton(tag.getText());
      tagButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          double timeInSeconds = mediaControl.getCurrentTime().toSeconds();
          int minutes = (int) Math.floor(timeInSeconds / 60);
          int seconds = (int) Math.floor(timeInSeconds % 60);
          String secondsString = "";
          String minutesString = "";
          if (seconds < 10) {
            secondsString = "0" + seconds;
          } else {
            secondsString = "" + seconds;
          }

          if (minutes < 10) {
            minutesString = "0" + minutes;
          } else {
            minutesString = "" + minutes;
          }



          prevTag(tag.getText(), minutesString + ":" + secondsString);
        }
      });

      JButton timeButton = new JButton(tag.getTime());
      timeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          goToTime(new Duration(tag.getMs())) ;
        }
      });
      delButton.setMaximumSize(new Dimension(5, 25));
      timeButton.setMaximumSize(new Dimension(25, 25));

      buttonPane.add(delButton);
      buttonPane.add(tagButton);
      buttonPane.add(timeButton);

      buttonPane.add(Box.createRigidArea(new Dimension(140, 25)));

      buttonPane.setAlignmentX(Component.LEFT_ALIGNMENT);
      if (cntr % 2 == 1) {
        buttonPane.setBackground(Color.LIGHT_GRAY);
      }

      tagPanel.add(buttonPane);
    }
    tagPanel.setLayout(new BoxLayout(tagPanel, BoxLayout.PAGE_AXIS));
    tagScroll = new JScrollPane(tagPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    tagScroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

  }


  private void addComponents() {
    add(homeButton);
    add(plusGroup);
    add(newTag);
    add(groupHeader);
    add(groupScroll);
    add(myTags);
    add(gameTitle);
    add(tagScroll);
    add(videoPanel);
  }

  private void initVideoPlayer(){
    VFXPanel = new JFXPanel();

    File video_source = new File(this.videoObj.vidPath);
    Media m = new Media(video_source.toURI().toString());
    MediaPlayer player = new MediaPlayer(m);
    MediaView viewer = new MediaView(player);
    mediaControl = new MediaControl(player);

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


  private void goToTime(Duration currTime) {
    mediaControl.setTime(currTime);
    mediaControl.updateValues();
  }


  private void deleteTag(VideoTag tag) {
    this.videoObj.tags.remove(tag);

    refreshTags();
  }


  private void prevTag(String text, String time) {
    System.out.println(text + time);

    JFrame tagAdder = new TagAdder("Add Tag", page, text, time);
    tagAdder.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    tagAdder.setLocation(700, 150);
    tagAdder.setSize(new Dimension(200,200));
    tagAdder.setVisible(true);
  }

  private void refreshGroups() {
    remove(groupScroll);
    buildGroups();
    add(groupScroll);

    groupScroll.repaint();
    groupScroll.revalidate();
  }

  private void refreshTags() {
    remove(tagScroll);
    buildTagPanel();
    tagScroll.setBounds(800, 50, 375, 600);
    add(tagScroll);

    tagScroll.repaint();
    tagScroll.revalidate();
  }


}
