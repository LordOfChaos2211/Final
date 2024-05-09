import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Introframe implements ActionListener {
    JFrame Inframe;
    JLabel ResTi;
    JButton start;
    JButton setres;
    JButton off;
    JPanel hold1;
    JPanel hold2;
    JPanel hold3;
    Dimension prefdim =new Dimension(500,500);
    Introframe() {
        ResTi = new JLabel("Please set preferred resolution");
        ResTi.setFont(new Font("Times New Roman", Font.PLAIN,25));
        ResTi.setVisible(true);
        ResTi.setBounds(0,0,500,100);

        start = new JButton("Start Program");
        start.setFocusable(false);
        start.setBounds(0,0,200,50);
        start.setFont(new Font("Times New Roman", Font.PLAIN,25));
        start.addActionListener(this);

        hold3 = new JPanel();
        hold3.setPreferredSize(new Dimension(200,400));
        hold3.setBackground(Color.WHITE);
        hold3.add(start);

        hold1 = new JPanel();
        hold1.setPreferredSize(new Dimension(100,100));
        hold1.setBackground(Color.white);
        hold1.add(ResTi);

        hold2 = new JPanel();
        hold2.setBackground(Color.WHITE);
        hold2.add(hold3);
        hold3.setLayout(null);

        Inframe = new JFrame();
        Inframe.setSize(500, 500);
        Inframe.setResizable(false);
        Inframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Inframe.add(hold1,BorderLayout.NORTH);
        Inframe.add(hold2,BorderLayout.CENTER);
        Inframe.setVisible(true);
        Inframe.setTitle("Program Initializer");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start){
            Inframe.dispose();
            new Mainframe(prefdim);
        }
    }
}
