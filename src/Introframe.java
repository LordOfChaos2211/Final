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
    static Dimension prefdim =new Dimension(500,500);
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

        setres = new JButton("Select resolution");
        setres.setFocusable(false);
        setres.setBounds(0,0,200,50);
        setres.setFont(new Font("Times New Roman", Font.PLAIN,25));
        setres.addActionListener(this);

        off = new JButton("Quit Program");
        off.setFocusable(false);
        off.setBounds(0,0,200,50);
        off.setFont(new Font("Times New Roman", Font.PLAIN,25));
        off.addActionListener(this);

        hold3 = new JPanel();
        hold3.setPreferredSize(new Dimension(200,400));
        //hold3.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
        hold3.setBackground(Color.WHITE);
        //hold3.add(start);
        hold3.add(setres);
        //hold3.add(off);

        hold1 = new JPanel();
        hold1.setPreferredSize(new Dimension(100,100));
        hold1.setBackground(Color.white);
        hold1.add(ResTi);

        hold2 = new JPanel();
        hold2.setBackground(Color.WHITE);
        hold2.add(hold3);
        hold2.add(start);
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
    public static void setResolution(int num1, int num2){
        prefdim.setSize(num1,num2);
        System.out.println("frame set to "+num1+"x"+num2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start){
            Inframe.dispose();
            new Mainframe(prefdim);
        }
        else if(e.getSource()==off){
            System.exit(0);
        }
        else if(e.getSource()==setres){
            new Resol();
        }
    }
}
