import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TagAdder extends JFrame {

  String textEntry;
  VideoPage page;
  Container container;
  JPanel main, groupMenu;
  JTextField tagName, time_entry;
  JLabel instructions, time_instructions;
  JButton done;
  public boolean doneClicked;


  TagAdder(String title, VideoPage page) {
    super(title);
    doneClicked = false;
    this.page = page;

    setLayout(null);

    main = new JPanel();
    main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
    main.setBounds(0,0, 200,450);

    instructions = new JLabel("Enter group name:");
    tagName = new JTextField();

    time_instructions = new JLabel("Enter time stamp (MM:SS):");
    time_entry = new JTextField();

    done = new JButton("Done");

    container = getContentPane();


    instructions.setAlignmentX(Component.CENTER_ALIGNMENT);
    main.add(instructions);

    tagName.setAlignmentX(Component.CENTER_ALIGNMENT);
    tagName.setMaximumSize(new Dimension(200,50));
    main.add(tagName);

    time_instructions.setAlignmentX(Component.CENTER_ALIGNMENT);
    main.add(time_instructions);

    time_entry.setAlignmentX(Component.CENTER_ALIGNMENT);
    time_entry.setMaximumSize(new Dimension(100, 30));
    main.add(time_entry);

    done.setAlignmentX(Component.CENTER_ALIGNMENT);
    main.add(done);


    container.add(main);

    done.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        dispose();
        doneClicked = true;
        textEntry = tagName.getText();
        String time = time_entry.getText();
        page.addTag(textEntry, time);
      }
    });
  }

  public void addDoneListener(ActionListener listener) {
    done.addActionListener(listener);
  }
}
