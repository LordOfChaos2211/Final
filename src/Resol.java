import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Resol implements ActionListener {
    JRadioButton a;
    JRadioButton b;
    JRadioButton c;
    JRadioButton d;
    JRadioButton e;
    JRadioButton f;

    Resol(){
        a = new JRadioButton("1920x1080");
        b = new JRadioButton("1360x768");
        c = new JRadioButton("1560x846");
        d = new JRadioButton("1280x720");
        e = new JRadioButton("1440x900");
        f = new JRadioButton("1600x900");

        ButtonGroup reso = new ButtonGroup();
        reso.add(a);
        reso.add(b);
        reso.add(c);
        reso.add(d);
        reso.add(e);
        reso.add(f);

        JFrame res = new JFrame("Resolution selector");
        res.add(a);
        res.add(b);
        res.add(c);
        res.add(d);
        res.add(e);
        res.setLayout(new FlowLayout());
        res.setSize(400,200);
        res.setVisible(true);
        res.setResizable(false);
        res.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==a){
            Introframe.setResolution(1920,1080);
        }
        else if(e.getSource()==b){
            Introframe.setResolution(1360,768);
        }
        else if(e.getSource()==c){
            Introframe.setResolution(1560,846);
        }
        else if(e.getSource()==d){
            Introframe.setResolution(1280,720);
        }
        else if(e.getSource()==e){
            Introframe.setResolution(1440,900);
        }
        else if(e.getSource()==f){
            Introframe.setResolution(1600,900);
        }
    }
}

