import javax.swing.*;
import java.awt.*;

public class Mainframe extends JFrame {
    JFrame mainframe;
    Mainframe(Dimension dim){
        mainframe = new JFrame();
        mainframe.setSize(dim);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setResizable(false);
        mainframe.setVisible(true);
    }
}
