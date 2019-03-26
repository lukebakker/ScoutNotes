import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
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

  HomePage(String title) {
    super(title);
    setLayout(null);

    upload = new JButton("Upload");
    upload.setFont(new Font("Serif", Font.BOLD, 24));
    searchBar = new JTextField();
    searchButton = new JButton("Search:");
    searchButton.setFont(new Font("Serif", Font.BOLD, 24));

    makeSearchResults();
    makeGroupMenu();
    createGroupButton.setFont(new Font("Serif", Font.BOLD, 24));
    jetsGroup.setFont(new Font("Serif", Font.BOLD, 24));
    patriotsGroup.setFont(new Font("Serif", Font.BOLD, 24));
    dolphinsGroup.setFont(new Font("Serif", Font.BOLD, 24));
    ramsGroup.setFont(new Font("Serif", Font.BOLD, 24));





    container = getContentPane();
    setLocation();
    setResultPanelProperties();
    addComponents();

    patriotsVRamsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Video newVid = new Video(new ArrayList<>(),new DefaultListModel<>());
        JFrame videoPage = new VideoPage("Rams vs. Patriots", newVid);
        videoPage.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        videoPage.setSize(1000, 800);
        videoPage.setVisible(true);
        dispose();
      }
    });

    jetsVRamsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Video newVid = new Video(new ArrayList<>(),new DefaultListModel<>());
        JFrame videoPage = new VideoPage("Jets vs. Rams", newVid);
        videoPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        videoPage.setSize(1000, 800);
        videoPage.setVisible(true);
        dispose();
      }
    });

    dolphinsVBengalsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Video newVid = new Video(new ArrayList<>(),new DefaultListModel<>());
        JFrame videoPage = new VideoPage("Dolphins vs. Bengals", newVid);
        videoPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        videoPage.setSize(1000, 800);
        videoPage.setVisible(true);
        dispose();
      }
    });

    cowboysVDolphinsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Video newVid = new Video(new ArrayList<>(),new DefaultListModel<>());
        JFrame videoPage = new VideoPage("Cowboys vs. Dolphins", newVid);
        videoPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        videoPage.setSize(1000, 800);
        videoPage.setVisible(true);
        dispose();
      }
    });

    jetsVPatriotsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Video newVid = new Video(new ArrayList<>(),new DefaultListModel<>());
        JFrame videoPage = new VideoPage("Jets vs. Patriots", newVid);
        videoPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        videoPage.setSize(1000, 800);
        videoPage.setVisible(true);
        dispose();
      }
    });

    createGroupButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFrame addGroup = new CreateGroup("Create Group");
        addGroup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    searchButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
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


  private void makeGroupMenu() {
    groupMenu = new JPanel();
    groupMenu.setLayout(new BoxLayout(groupMenu, BoxLayout.PAGE_AXIS));
    createGroupButton = new JButton("Create Group");
    myGroupsLabel = new JLabel("My Groups:");
    myGroupsLabel.setFont(new Font("Serif", Font.BOLD, 24));
    dolphinsGroup = new JButton("Dolphins");
    jetsGroup = new JButton("Jets");
    patriotsGroup = new JButton("Patriots");
    ramsGroup = new JButton("Rams");

  }

  private void makeSearchResults() {
    ImageIcon cowboysVDolphins = new ImageIcon(getClass().getResource("/CowboysVDolphins.jpg"));
    ImageIcon dolphinsVBengals = new ImageIcon(getClass().getResource("/DolphinsVBengals.jpeg"));
    ImageIcon jetsVPatriots = new ImageIcon(getClass().getResource("/JetsVPatriots.jpeg"));
    ImageIcon jetsVRams = new ImageIcon(getClass().getResource("/JetsVRams.jpg"));
    ImageIcon patriotsVRams = new ImageIcon(getClass().getResource("/PatriotsVRams.jpeg"));


    cowboysVDolphinsButton = new JButton(cowboysVDolphins);
    jetsVPatriotsButton = new JButton(jetsVPatriots);
    jetsVRamsButton = new JButton(jetsVRams);
    dolphinsVBengalsButton = new JButton(dolphinsVBengals);
    patriotsVRamsButton = new JButton(patriotsVRams);

    cowboysVDolphinsLabel = new JLabel("Cowboys vs. Dolphins");
    jetsVPatriotsLabel = new JLabel("Jets vs. Patriots");
    jetsVRamsLabel = new JLabel("Jets vs. Rams");
    dolphinsVBengalsLabel = new JLabel("Dolphins vs. Bengals");
    patriotsVRamsLabel = new JLabel("Patriots vs Rams");

    resultPanel = new JPanel();
    resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
    scrollPanel = new JScrollPane(resultPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPanel.setPreferredSize(new Dimension(600,600));
    scrollPanel.setBounds(0, 150, 700, 600);
  }

  private void setLocation() {
    upload.setBounds(30,50,200,50);
    searchBar.setBounds(330,50,350,50);
    resultPanel.setBounds(0, 150, 700, 600);
    searchButton.setBounds(230,50,100,50);
    groupMenu.setBounds(700, 0, 300, 800);
    createGroupButton.setMaximumSize(new Dimension(200,50));
    jetsGroup.setMaximumSize(new Dimension(200,50));
    patriotsGroup.setMaximumSize(new Dimension(200,50));
    dolphinsGroup.setMaximumSize(new Dimension(200,50));

  }

  private void addComponents() {

    // search results section

    dolphinsVBengalsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    resultPanel.add(dolphinsVBengalsLabel);

    dolphinsVBengalsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    resultPanel.add(dolphinsVBengalsButton);

    cowboysVDolphinsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    resultPanel.add(cowboysVDolphinsLabel);

    cowboysVDolphinsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    resultPanel.add(cowboysVDolphinsButton);

    jetsVPatriotsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    resultPanel.add(jetsVPatriotsLabel);

    jetsVPatriotsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    resultPanel.add(jetsVPatriotsButton);

    jetsVRamsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    resultPanel.add(jetsVRamsLabel);

    jetsVRamsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    resultPanel.add(jetsVRamsButton);

    patriotsVRamsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    resultPanel.add(patriotsVRamsLabel);

    patriotsVRamsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    resultPanel.add(patriotsVRamsButton);

    // groups section

    createGroupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    groupMenu.add(Box.createRigidArea(new Dimension(200,50)));
    groupMenu.add(createGroupButton);
    groupMenu.add(Box.createRigidArea(new Dimension(200,50)));
    myGroupsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    groupMenu.add(myGroupsLabel);
    groupMenu.add(Box.createRigidArea(new Dimension(200,50)));
    jetsGroup.setAlignmentX(Component.CENTER_ALIGNMENT);
    groupMenu.add(jetsGroup);
    patriotsGroup.setAlignmentX(Component.CENTER_ALIGNMENT);
    groupMenu.add(patriotsGroup);
    dolphinsGroup.setAlignmentX(Component.CENTER_ALIGNMENT);
    groupMenu.add(dolphinsGroup);


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
