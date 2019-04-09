import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CreateGroup extends JFrame{
  Container container;
  JPanel main, groupMenu;
  JTextField groupName;
  JLabel instructions;
  JButton done;
  public boolean doneClicked;
  UserData user;
  HomePage page;


  CreateGroup(String title, UserData user, HomePage page) {
    super(title);
    doneClicked = false;

    this.page = page;

    this.user = user;

    setLayout(null);

    main = new JPanel();
    main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
    main.setBounds(0,0, 200,150);

    instructions = new JLabel("Enter group name:");
    groupName = new JTextField();
    done = new JButton("Done");

    container = getContentPane();


    instructions.setAlignmentX(Component.CENTER_ALIGNMENT);
    main.add(instructions);

    groupName.setAlignmentX(Component.CENTER_ALIGNMENT);
    groupName.setMaximumSize(new Dimension(200,50));
    main.add(groupName);

    done.setAlignmentX(Component.CENTER_ALIGNMENT);
    main.add(done);


    container.add(main);

    done.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dispose();
        doneClicked = true;
        String textEntry = groupName.getText();
        page.addGroup(textEntry);
        //user.mapping.put(textEntry, null);
        System.out.println(user.mapping.keySet());
      }
    });
  }

  public void addDoneListener(ActionListener listener) {
    done.addActionListener(listener);
  }
}
