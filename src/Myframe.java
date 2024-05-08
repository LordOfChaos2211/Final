import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Myframe implements ActionListener{
    JButton button;
    JFrame frame;
    Myframe(){
        frame = new JFrame();
        
        button = new JButton();
        button.setFocusable(false);
        button.setText("Press");
        button.addActionListener(this);

        frame.add(button);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            frame.dispose();
            JOptionPane.showMessageDialog(null,
                    "You pressed the button",
                    "Button pressed",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
