import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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

class LoginFrame extends JFrame {
  private JLabel usernameLabel, passwordLabel, scoutNotes;
  private JButton done;
  private JTextField username;
  private JPasswordField password;
  private Container container;
  private JPanel videoPanel;


  LoginFrame(String title) {
    super(title);

    videoPanel = new JPanel();

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
        if(username.getText().equals("username") && password.getText().equals("password") || true) {
          //JFrame frame = new HomePage("Home");
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
    videoPanel.setBounds(0, 0, 600, 600);
  }

  private void addComponents() {
    container.add(scoutNotes);
    container.add(usernameLabel);
    container.add(passwordLabel);
    container.add(username);
    container.add(password);
    container.add(done);
    container.add(videoPanel);
  }


}
