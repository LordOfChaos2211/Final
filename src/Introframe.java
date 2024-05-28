import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Introframe implements ActionListener {
    JFrame Inframe;
    JFrame res;

    JLabel ResTi;

    JButton start;
    JButton setres;
    JButton off;

    JPanel hold1;
    JPanel hold2;
    JPanel hold3;

    JRadioButton a;
    JRadioButton b;
    JRadioButton c;
    JRadioButton d;
    JRadioButton g;
    JRadioButton f;

    Dimension prefdim = new Dimension(500,500);

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
        hold3.setSize(new Dimension(400,400));
        hold3.setLayout(new GridLayout(3,1,0,75));
        hold3.setBackground(Color.WHITE);
        hold3.add(start);
        hold3.add(setres);
        hold3.add(off);

        hold1 = new JPanel();
        hold1.setPreferredSize(new Dimension(100,100));
        hold1.setBackground(Color.white);
        hold1.add(ResTi);

        hold2 = new JPanel();
        hold2.setBackground(Color.WHITE);
        hold2.add(hold3);


        Inframe = new JFrame();
        Inframe.setSize(500, 500);
        Inframe.setResizable(false);
        Inframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Inframe.add(hold1,BorderLayout.NORTH);
        Inframe.add(hold2,BorderLayout.CENTER);
        Inframe.setVisible(true);
        Inframe.setTitle("Program Initializer");

    }
    public void getResolution(){
        a = new JRadioButton("1920x1080");
        b = new JRadioButton("1360x768");
        c = new JRadioButton("1560x846");
        d = new JRadioButton("1280x720");
        f = new JRadioButton("1440x900");
        g = new JRadioButton("1600x900");

        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        f.addActionListener(this);
        g.addActionListener(this);

        ButtonGroup reso = new ButtonGroup();
        reso.add(a);
        reso.add(b);
        reso.add(c);
        reso.add(d);
        reso.add(f);
        reso.add(g);

        res = new JFrame("Resolution selector");
        res.add(a);
        res.add(b);
        res.add(c);
        res.add(d);
        res.add(f);
        res.add(g);
        res.setLayout(new FlowLayout());
        res.setSize(400,200);
        res.setVisible(true);
        res.setResizable(false);
        res.pack();
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
         getResolution();
        }
        else if(e.getSource()==a){
            prefdim.setSize(1920,1080);
            res.dispose();
        }
        else if(e.getSource()==b){
            prefdim.setSize(1360,768);
            res.dispose();
        }
        else if(e.getSource()==c){
            prefdim.setSize(1560,846);
            res.dispose();
        }
        else if(e.getSource()==d){
            prefdim.setSize(1280,720);
            res.dispose();
        }
        else if(e.getSource()==f){
            prefdim.setSize(1440,900);
            res.dispose();
        }
        else if(e.getSource()==g){
            prefdim.setSize(1600,900);
            res.dispose();
        }
    }
}
