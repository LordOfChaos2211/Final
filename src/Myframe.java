import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Myframe implements ActionListener{
    JButton button;
    JFrame frame;
    JLabel label;
    JPanel base;
    Myframe(){
        frame = new JFrame();
        label = new JLabel("Press the button");
        label.setFont(new Font("Times New Roman", Font.PLAIN,15));
        label.setForeground(Color.white);
        label.setBackground(Color.BLACK);
        label.setOpaque(true);

        base = new JPanel();
        base.setSize(250,250);
        base.setBackground(Color.BLACK);
        base.add(label);

        button = new JButton();
        button.setFocusable(false);
        button.setSize(100,50);
        button.setText("Press");
        button.addActionListener(this);

        base.add(button);

        frame.add(base);
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
        }
    }
}
