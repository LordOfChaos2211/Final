import javax.swing.*;
import java.awt.*;

public class Mainframe extends JFrame {
    JFrame mainframe;
    JPanel leftPane;
    JPanel bottomPane;
    JPanel content;
    Mainframe(Dimension dim){
        mainframe = new JFrame();
        mainframe.setSize(dim);

        leftPane = new JPanel();
        leftPane.setPreferredSize(new Dimension((int) (mainframe.getWidth()*.2),100));
        leftPane.setBackground(Color.RED);
        //leftPane.setOpaque(true);

        bottomPane = new JPanel();
        bottomPane.setPreferredSize(new Dimension(100,(int) (mainframe.getHeight()*.2)));
        bottomPane.setBackground(Color.BLUE);
       // bottomPane.setOpaque(true);

        content = new JPanel();
        content.setBackground(Color.GREEN);
        //content.setOpaque(true);

        mainframe.setLayout(new BorderLayout());
        mainframe.add(leftPane,BorderLayout.WEST);
        mainframe.add(bottomPane,BorderLayout.SOUTH);
        mainframe.add(content,BorderLayout.CENTER);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setResizable(false);
        mainframe.setVisible(true);
    }
}
