import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class LoginFrame extends JFrame {
  private JLabel usernameLabel, passwordLabel, scoutNotes;
  private JButton done;
  private JTextField username;
  private JPasswordField password;
  private Container container;


  LoginFrame(String title) {
    super(title);

    setLayout(null);
    scoutNotes = new JLabel ("Scout Notes");
    scoutNotes.setFont(new Font("Serif", Font.BOLD, 36));

    usernameLabel = new JLabel("Username:");
    passwordLabel = new JLabel("Password:");
    username = new JTextField();
    password = new JPasswordField();
    done = new JButton("Login");


    container = getContentPane();

    setLocation();
    addComponents();


    done.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(username.getText().equals("username") && password.getText().equals("password")) {
          JFrame frame = new HomePage("Home");
          frame.setSize(1000, 800);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setVisible(true);
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
