import java.awt.*;

import javax.swing.*;

class HomePage extends JFrame {
  Container container;
  private JLabel dolphinsVBengalsLabel, jetsVPatriotsLabel, cowboysVDolphinsLabel,
    jetsVRamsLabel, PatriotsVRamsLabel;
  private JButton upload, searchButton, dolphinsVBengalsButton, jetsVPatriotsButton,
          cowboysVDolphinsButton, jetsVRamsButton, PatriotsVRamsButton;
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

    ImageIcon cowboysVDolphins = new ImageIcon("./images/CowboysVDolphins.jpg");
    ImageIcon dolphinsVBengals = new ImageIcon("./images/DolphinsVBengals.jpeg");
    ImageIcon jetsVPatriots = new ImageIcon("./images/JetsVPatriots.jpeg");
    ImageIcon jetsVRams = new ImageIcon("./images/JetsVRams.jpg");
    ImageIcon patriotsVRams = new ImageIcon("./images/PatriotsVRams.jpeg");


    cowboysVDolphinsButton = new JButton(cowboysVDolphins);
    jetsVPatriotsButton = new JButton(jetsVPatriots);
    jetsVRamsButton = new JButton(jetsVRams);
    dolphinsVBengalsButton = new JButton(dolphinsVBengals);
    PatriotsVRamsButton = new JButton(patriotsVRams);

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
    cowboysVDolphinsButton.setBounds(0,50,300,200);


  }

  private void addComponents() {
    resultPanel.add(cowboysVDolphinsButton);
    resultPanel.add(dolphinsVBengalsButton);
    resultPanel.add(jetsVPatriotsButton);
    resultPanel.add(jetsVRamsButton);
    resultPanel.add(PatriotsVRamsButton);

    container.add(upload);
    container.add(resultPanel);
    container.add(searchBar);
    container.add(searchButton);
  }

  private void setResultPanelProperties(){
    resultPanel.setBackground(Color.LIGHT_GRAY);
  }

}
