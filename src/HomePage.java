import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.*;

class HomePage extends JFrame {
  Container container;
  private JScrollPane scrollPanel;
  private JLabel dolphinsVBengalsLabel, jetsVPatriotsLabel, cowboysVDolphinsLabel,
    jetsVRamsLabel, patriotsVRamsLabel, myGroupsLabel;
  private JButton upload, searchButton, dolphinsVBengalsButton, jetsVPatriotsButton,
          cowboysVDolphinsButton, jetsVRamsButton, patriotsVRamsButton, createGroupButton, dolphinsGroup,
  patriotsGroup, jetsGroup, ramsGroup;
  private JTextField searchBar;
  private JPanel resultPanel, groupMenu;
  private ArrayList<String> userGroups;
  private ArrayList<Video> userVideos;
  private UserData user;

  HomePage(String title, UserData user) {
    super(title);
    setLayout(null);

    this.user = user;

    this.userGroups = this.user.groups;
    this.userVideos = this.user.videos;

    upload = new JButton("Upload");
    upload.setFont(new Font("Serif", Font.BOLD, 24));
    searchBar = new JTextField();
    searchButton = new JButton("Search:");
    searchButton.setFont(new Font("Serif", Font.BOLD, 24));

    initializeVideos();

    container = getContentPane();
    addComponents();

    setResultPanelProperties();
    setLocation();

    createGroupButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFrame addGroup = new CreateGroup("Create Group");
        addGroup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addGroup.setLocation(700, 150);
        addGroup.setSize(new Dimension(200,150));
        addGroup.setVisible(true);
        ((CreateGroup) addGroup).addDoneListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            addRamsButton();
          }
        });
      }
    });

    // TODO: Dynamic search
    searchButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String searchText = searchBar.getText();

        resultPanel.remove(jetsVPatriotsButton);
        resultPanel.remove(jetsVPatriotsLabel);
        resultPanel.remove(dolphinsVBengalsButton);
        resultPanel.remove(dolphinsVBengalsLabel);
        resultPanel.remove(cowboysVDolphinsButton);
        resultPanel.remove(cowboysVDolphinsLabel);
        resultPanel.remove(jetsVRamsButton);
        resultPanel.remove(jetsVRamsLabel);
        resultPanel.setVisible(false);
        resultPanel.setVisible(true);
      }
    });
  }

  private void initializeVideos() {



  }


  private void makeGroupMenu() {
    groupMenu = new JPanel();
    groupMenu.setLayout(new BoxLayout(groupMenu, BoxLayout.PAGE_AXIS));
    createGroupButton = new JButton("Create Group");
    myGroupsLabel = new JLabel("My Groups:");
    createGroupButton.setFont(new Font("Serif", Font.BOLD, 24));
    myGroupsLabel.setFont(new Font("Serif", Font.BOLD, 24));

    createGroupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    createGroupButton.setMaximumSize(new Dimension(200, 50));
    groupMenu.add(Box.createRigidArea(new Dimension(200,50)));
    groupMenu.add(createGroupButton);
    groupMenu.add(Box.createRigidArea(new Dimension(200,50)));
    myGroupsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    groupMenu.add(myGroupsLabel);
    groupMenu.add(Box.createRigidArea(new Dimension(200,50)));

    for (String g : this.userGroups) {
      JButton button = new JButton(g);
      button.setFont(new Font("Serif", Font.BOLD, 24));
      button.setAlignmentX(Component.CENTER_ALIGNMENT);
      groupMenu.add(button);
      button.setMaximumSize(new Dimension(200,50));
    }

  }


  private void setLocation() {
    upload.setBounds(30,50,200,50);
    searchBar.setBounds(330,50,350,50);
    resultPanel.setBounds(0, 150, 700, 600);
    searchButton.setBounds(230,50,100,50);
    groupMenu.setBounds(700, 0, 300, 800);

  }

  private void buildResultPanel() {
    resultPanel = new JPanel();

    for (Video vid : this.userVideos) {
      // create the label for the video
      JLabel vidLabel = new JLabel(vid.title);
      vidLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      resultPanel.add(vidLabel);

      // create the button for the video
      JButton vidButton = new JButton(vid.image);
      vidButton.setAlignmentX(Component.CENTER_ALIGNMENT);

      // Add action listener to redirect to the video's page on-click
      vidButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          JFrame videoPage = new VideoPage(vid.title, vid);
          videoPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          videoPage.setSize(1000, 800);
          videoPage.setVisible(true);
          dispose();
        }
      });
      resultPanel.add(vidButton);
    }

    resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
    scrollPanel = new JScrollPane(resultPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPanel.setPreferredSize(new Dimension(600,600));
    scrollPanel.setBounds(0, 150, 700, 600);
  }

  private void addComponents() {
    // search results section
    buildResultPanel();

    // groups section
    makeGroupMenu();

    container.add(upload);
    container.add(scrollPanel);
    container.add(searchBar);
    container.add(searchButton);
    container.add(groupMenu);
  }

  private void setResultPanelProperties(){
    resultPanel.setBackground(Color.LIGHT_GRAY);
    groupMenu.setBackground(Color.GRAY);
  }

  private void addRamsButton() {
    System.out.println("HERE");
    ramsGroup.setAlignmentX(Component.CENTER_ALIGNMENT);
    ramsGroup.setMaximumSize(new Dimension(200,50));
    groupMenu.add(ramsGroup);
    groupMenu.setVisible(false);
    groupMenu.setVisible(true);

  }

}
