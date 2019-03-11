import java.awt.*;

import javax.swing.*;

class HomePage extends JFrame {
  Container container;
  private JLabel dolphinsVBengalsLabel, jetsVPatriotsLabel, cowboysVDolphinsLabel,
    jetsVRamsLabel, patriotsVRamsLabel;
  private JButton upload, searchButton, dolphinsVBengalsButton, jetsVPatriotsButton,
          cowboysVDolphinsButton, jetsVRamsButton, patriotsVRamsButton;
  private JTextField searchBar;
  private JPanel resultPanel;

  HomePage(String title) {
    super(title);
    setLayout(null);

    upload = new JButton("Upload");
    upload.setFont(new Font("Serif", Font.BOLD, 24));
    searchBar = new JTextField();
    searchButton = new JButton("Search:");
    searchButton.setFont(new Font("Serif", Font.BOLD, 24));

    ImageIcon cowboysVDolphins = new ImageIcon("../images/CowboysVDolphins.jpg");
    ImageIcon dolphinsVBengals = new ImageIcon("../images/DolphinsVBengals.jpeg");
    ImageIcon jetsVPatriots = new ImageIcon("../images/JetsVPatriots.jpeg");
    ImageIcon jetsVRams = new ImageIcon("./JetsVRams.jpg");
    ImageIcon patriotsVRams = new ImageIcon("../images/PatriotsVRams.jpeg");


    cowboysVDolphinsButton = new JButton(cowboysVDolphins);
    jetsVPatriotsButton = new JButton(jetsVPatriots);
    jetsVRamsButton = new JButton(jetsVRams);
    dolphinsVBengalsButton = new JButton(dolphinsVBengals);
    patriotsVRamsButton = new JButton(patriotsVRams);

    dolphinsVBengalsLabel = new JLabel("Dolphins vs. Bengals");
    jetsVRamsLabel = new JLabel("Jets vs. Rams");
    dolphinsVBengalsLabel = new JLabel("Dolphins vs. Bengals");
    jetsVPatriotsLabel = new JLabel("Jets vs. Patriots");
    patriotsVRamsLabel = new JLabel("Patriots vs. Rams");

    resultPanel = new JPanel();
    resultPanel.setLayout(new GridLayout(0,2));


    container = getContentPane();

    setLocation();
    setResultPanelProperties();
    addComponents();
  }

  private void setLocation() {
    upload.setBounds(30,50,200,50);
    searchBar.setBounds(330,50,350,50);
    resultPanel.setBounds(0, 150, 700, 800);
    searchButton.setBounds(230,50,100,50);


  }

  private void addComponents() {
    resultPanel.add(cowboysVDolphinsButton);
    resultPanel.add(dolphinsVBengalsButton);
    resultPanel.add(jetsVPatriotsButton);
    resultPanel.add(jetsVRamsButton);
    resultPanel.add(patriotsVRamsButton);
    resultPanel.add(cowboysVDolphinsLabel);
    resultPanel.add(dolphinsVBengalsLabel);
    resultPanel.add(jetsVPatriotsLabel);
    resultPanel.add(jetsVRamsLabel);
    resultPanel.add(patriotsVRamsLabel);




    container.add(upload);
    container.add(searchBar);
    container.add(searchButton);
    container.add(resultPanel);

  }

  private void setResultPanelProperties(){
    resultPanel.setBackground(Color.LIGHT_GRAY);
  }

}
