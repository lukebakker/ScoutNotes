import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TagAdder extends JFrame {

  String textEntry;
  VideoPage page;
  Container container;
  JPanel main, groupMenu;
  JTextField tagName;
  JLabel instructions;
  JButton done;
  public boolean doneClicked;


  TagAdder(String title, VideoPage page) {
    super(title);
    doneClicked = false;
    this.page = page;

    setLayout(null);

    main = new JPanel();
    main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
    main.setBounds(0,0, 200,150);

    instructions = new JLabel("Enter group name:");
    tagName = new JTextField();
    done = new JButton("Done");

    container = getContentPane();


    instructions.setAlignmentX(Component.CENTER_ALIGNMENT);
    main.add(instructions);

    tagName.setAlignmentX(Component.CENTER_ALIGNMENT);
    tagName.setMaximumSize(new Dimension(200,50));
    main.add(tagName);

    done.setAlignmentX(Component.CENTER_ALIGNMENT);
    main.add(done);


    container.add(main);

    done.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        dispose();
        doneClicked = true;
        textEntry = tagName.getText();
        page.addTag(textEntry, "00:00");
      }
    });
  }

  public void addDoneListener(ActionListener listener) {
    done.addActionListener(listener);
  }
}
