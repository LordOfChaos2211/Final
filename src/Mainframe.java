import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.*;
import org.jfree.data.xy.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mainframe extends JFrame implements ActionListener {
    JFrame mainframe;

    JPanel leftPane;
    JPanel bottomPane;
    JPanel content;
    JPanel options;
    JPanel options2;

    JLabel label;
    JLabel graTitle;
    JLabel xTitle;
    JLabel yTitle;
    JLabel dataName;
    JLabel dataClass;
    JLabel dataValue;


    JButton scatterPlot;
    JButton pieChart;
    JButton lineGraph;
    JButton barChart;


    JTextField graphTitle;
    JTextField xAxisTitle;
    JTextField yAxisTitle;
    JTextField dataPointName;
    JTextField dataPointNameAlt;
    JTextField numValue;

    DefaultPieDataset generalPieData;
    DefaultCategoryDataset generalBarData;
    DefaultXYDataset generalGraphData;

    JFreeChart chartGenerator;
    ChartPanel chartHolder;

    Mainframe(Dimension dim) {
        mainframe = new JFrame();
        mainframe.setTitle("Data Visualizer");
        mainframe.setSize(dim);

        generalBarData = new DefaultCategoryDataset();
        generalGraphData = new DefaultXYDataset();
        generalPieData = new DefaultPieDataset();

        label = new JLabel("Please choose graph type:");
        label.setVisible(true);
        label.setBounds(0, 0, (int) (mainframe.getWidth() * .2), (int) (mainframe.getWidth() * .04));
        label.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        adjustLabel(label);

        graTitle = new JLabel("Title: ");
        graTitle.setVisible(true);
        graTitle.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        xTitle = new JLabel("x-axis Title:");
        xTitle.setVisible(true);
        xTitle.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        dataValue = new JLabel("Data point Value:");
        dataValue.setVisible(true);
        dataValue.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        dataName = new JLabel("Data point Name");
        dataName.setVisible(true);
        dataName.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        yTitle = new JLabel("Data point Name");
        yTitle.setVisible(true);
        yTitle.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        dataClass = new JLabel("Data point Name");
        dataClass.setVisible(true);
        dataClass.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        scatterPlot = new JButton("Scatter Plot");
        scatterPlot.setFocusable(false);
        scatterPlot.addActionListener(this);

        pieChart = new JButton("Pie Chart");
        pieChart.setFocusable(false);
        pieChart.addActionListener(this);


        lineGraph = new JButton("Line Graph");
        lineGraph.setFocusable(false);
        lineGraph.addActionListener(this);


        barChart = new JButton("Bar Chart");
        barChart.setFocusable(false);
        barChart.addActionListener(this);

        graphTitle = new JTextField();
        //graphTitle.setPreferredSize(new Dimension((int) (mainframe.getWidth()*.2),(int) (mainframe.getWidth()*.04)));

        xAxisTitle = new JTextField();
        //xAxisTitle.setPreferredSize(new Dimension((int) (mainframe.getWidth()*.2),(int) (mainframe.getWidth()*.04)));

        yAxisTitle = new JTextField();
        //yAxisTitle.setPreferredSize(new Dimension((int) (mainframe.getWidth()*.2),(int) (mainframe.getWidth()*.04)));

        dataPointName = new JTextField();
        //dataPointName.setPreferredSize(new Dimension((int) (mainframe.getWidth()*.2),(int) (mainframe.getWidth()*.04)));

        dataPointNameAlt = new JTextField();
        //dataPointNameAlt.setPreferredSize(new Dimension((int) (mainframe.getWidth()*.2),(int) (mainframe.getWidth()*.04)));

        numValue = new JTextField();
        //numValue.setPreferredSize(new Dimension((int) (mainframe.getWidth()*.2),(int) (mainframe.getWidth()*.04)));

        options = new JPanel();
        options.setBounds(0, (int) (mainframe.getWidth() * .04), (int) (mainframe.getWidth() * .2), (int) (mainframe.getWidth() * .2));
        options.setBackground(Color.BLACK);
        options.setLayout(new GridLayout(2, 2, 5, 5));
        options.add(scatterPlot);
        options.add(pieChart);
        options.add(lineGraph);
        options.add(barChart);

        options2 = new JPanel();
        options2.setBounds(0, ((int) (mainframe.getWidth() * .04) + (int) (mainframe.getWidth() * .2))
                , (int) (mainframe.getWidth() * .2), ((int) (mainframe.getHeight()) - (int) (mainframe.getHeight() * .2))
                        - ((int) (mainframe.getWidth() * .04) + (int) (mainframe.getWidth() * .2)));
        options2.setBackground(Color.WHITE);
        options2.setLayout(new GridLayout(6, 1, 0, 0));
        options2.add(graTitle);
        options2.add(graphTitle);
        options2.add(xTitle);
        options2.add(xAxisTitle);

        leftPane = new JPanel();
        leftPane.setPreferredSize(new Dimension((int) (mainframe.getWidth() * .2), 100));
        leftPane.setLayout(null);
        leftPane.setBackground(Color.RED);
        leftPane.add(options);
        leftPane.add(options2);
        leftPane.add(label);

        bottomPane = new JPanel();
        bottomPane.setPreferredSize(new Dimension(100, (int) (mainframe.getHeight() * .2)));
        bottomPane.setBackground(Color.BLUE);

        content = new JPanel();
        content.setBackground(Color.GREEN);

        mainframe.setLayout(new BorderLayout());
        mainframe.add(bottomPane, BorderLayout.SOUTH);
        mainframe.add(leftPane, BorderLayout.WEST);
        mainframe.add(content, BorderLayout.CENTER);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setResizable(false);
        mainframe.setVisible(true);
    }

    public void adjustLabel(JLabel label) {
        Font labelFont = label.getFont();
        String labelText = label.getText();

        int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = label.getWidth();

        double widthRatio = (double) componentWidth / (double) stringWidth;

        int newFontSize = (int) (labelFont.getSize() * widthRatio);
        int componentHeight = label.getHeight();

        int fontSizeToUse = Math.min(newFontSize, componentHeight);

        label.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
