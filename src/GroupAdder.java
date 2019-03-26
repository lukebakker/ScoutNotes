import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Created by MattP on 3/11/19.
 */
public class GroupAdder extends JFrame {

  VideoPage page;
  Container container;
  JPanel main, groupMenu;
  JTextField groupName;
  JLabel instructions;
  JButton done;
  String textEntry;
  public boolean doneClicked;


  GroupAdder(String title, VideoPage page) {
    super(title);
    doneClicked = false;
    this.page = page;

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
        textEntry = groupName.getText();
        page.addGroup(textEntry);
        if (textEntry == null | textEntry.isEmpty()) {
        	System.out.println("No entry");
        }
      }
    });
  }

  public void addDoneListener(ActionListener listener) {
    done.addActionListener(listener);
  }
  
  public String getText() {
	  return this.textEntry;
  }
}
