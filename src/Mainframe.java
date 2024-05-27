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
import java.util.ArrayList;

public class Mainframe extends JFrame implements ActionListener {
    JFrame mainframe;

    JPanel leftPane;
    JPanel bottomPane;
    JPanel content;
    JPanel options;
    JPanel options2;

    JLabel choicePrompt;
    JLabel graTitle;
    JLabel xTitle;
    JLabel xCoordValue;
    JLabel yTitle;
    JLabel yCoordValue;
    JLabel dataName;
    JLabel dataClass;
    JLabel dataValue;


    JButton scatterPlot;
    JButton pieChart;
    JButton lineGraph;
    JButton barChart;
    JButton addSlice;
    JButton addBar;
    JButton addCoordinate;
    JButton replaceSeries;
    JButton clearChart;


    JTextField graphTitle;
    JTextField xAxisTitle;
    JTextField yAxisTitle;
    JTextField dataPointName;
    JTextField dataPointNameAlt;
    JTextField numValue;
    JTextField numValueAlt;


    DefaultPieDataset generalPieData;
    DefaultCategoryDataset generalBarData;
    DefaultXYDataset generalGraphData;

    JFreeChart chartGenerator;
    ChartPanel chartHolder = new ChartPanel(null);

    ArrayList<String> graphSeries = new ArrayList<>();

    Mainframe(Dimension dim) {
        mainframe = new JFrame();
        mainframe.setTitle("Data Visualizer");
        mainframe.setSize(dim);

        generalBarData = new DefaultCategoryDataset();
        generalGraphData = new DefaultXYDataset();
        generalPieData = new DefaultPieDataset();

        choicePrompt = new JLabel("Please choose graph type:");
        choicePrompt.setVisible(true);
        choicePrompt.setBounds(0, 0, (int) (mainframe.getWidth() * .2), (int) (mainframe.getWidth() * .04));
        choicePrompt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        adjustLabel(choicePrompt);

        graTitle = new JLabel("Title: ");
        graTitle.setVisible(true);
        graTitle.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        xTitle = new JLabel("x-axis Title:");
        xTitle.setVisible(true);
        xTitle.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        dataValue = new JLabel("Data point Value:");
        dataValue.setVisible(true);
        dataValue.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        dataName = new JLabel("Data point Name:");
        dataName.setVisible(true);
        dataName.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        yTitle = new JLabel("y-axis Title:");
        yTitle.setVisible(true);
        yTitle.setFont(new Font("Times New Roman:", Font.PLAIN, 20));

        dataClass = new JLabel("Data Class:");
        dataClass.setVisible(true);
        dataClass.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        xCoordValue = new JLabel("x Values:");
        xCoordValue.setVisible(true);
        xCoordValue.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        yCoordValue = new JLabel("y Values:");
        yCoordValue.setVisible(true);
        yCoordValue.setFont(new Font("Times New Roman", Font.PLAIN, 20));

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

        addSlice = new JButton("Add Slice");
        addSlice.setFocusable(false);
        addSlice.addActionListener(this);

        addBar = new JButton("Add Bar");
        addBar.setFocusable(false);
        addBar.addActionListener(this);

        addCoordinate = new JButton("Add Coordinate");
        addCoordinate.setFocusable(false);
        addCoordinate.addActionListener(this);

        replaceSeries = new JButton("Add/Replace Dataset");
        replaceSeries.setFocusable(false);
        replaceSeries.addActionListener(this);

        clearChart = new JButton("Clear Graph");
        clearChart.setFocusable(false);
        clearChart.addActionListener(this);

        graphTitle = new JTextField();
        xAxisTitle = new JTextField();
        yAxisTitle = new JTextField();
        dataPointName = new JTextField();
        dataPointNameAlt = new JTextField();
        numValue = new JTextField();
        numValueAlt = new JTextField();

        options = new JPanel();
        options.setBounds(0, (int) (mainframe.getWidth() * .04), (int) (mainframe.getWidth() * .2), (int) (mainframe.getWidth() * .15));
        options.setBackground(Color.BLACK);
        options.setLayout(new GridLayout(2, 2, 5, 5));
        options.add(scatterPlot);
        options.add(pieChart);
        options.add(lineGraph);
        options.add(barChart);

        options2 = new JPanel();
        options2.setBounds(0, ((int) (mainframe.getWidth() * .04) + (int) (mainframe.getWidth() * .15))
                , (int) (mainframe.getWidth() * .2), ((int) (mainframe.getHeight()) - (int) (mainframe.getHeight() * .2))
                        - ((int) (mainframe.getWidth() * .04) + (int) (mainframe.getWidth() *.1775)));
        options2.setBackground(Color.WHITE);
        options2.setLayout(new GridLayout(6, 1, 0, 0));
        options2.add(graTitle);
        options2.add(graphTitle);
        options2.add(xTitle);
        options2.add(xAxisTitle);
        options2.add(yTitle);
        options2.add(yAxisTitle);

        leftPane = new JPanel();
        leftPane.setPreferredSize(new Dimension((int) (mainframe.getWidth() * .2), 100));
        leftPane.setLayout(null);
        leftPane.setBackground(Color.RED);
        leftPane.add(options);
        leftPane.add(options2);
        leftPane.add(choicePrompt);

        bottomPane = new JPanel();
        bottomPane.setPreferredSize(new Dimension(100, (int) (mainframe.getHeight() * .2)));
        //bottomPane.setBackground(Color.BLUE);


        content = new JPanel();
        //content.setBackground(Color.GREEN);
        content.setLayout(new BorderLayout());
        content.add(chartHolder);

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
        if(e.getSource()==pieChart){
            chartGenerator = ChartFactory.createPieChart(graphTitle.getText(),generalPieData);
            chartHolder.setChart(chartGenerator);
            options2.removeAll();
            options2.add(dataValue);
            options2.add(numValue);
            options2.add(dataName);
            options2.add(dataPointName);
            options2.add(addSlice);
            options2.revalidate();
            options2.repaint();
            bottomPane.add(clearChart);
            content.repaint();
            chartHolder.repaint();
        }
        else if(e.getSource()==barChart){
            chartGenerator = ChartFactory.createBarChart(graphTitle.getText(),xAxisTitle.getText(),yAxisTitle.getText(),generalBarData);
            chartHolder.setChart(chartGenerator);
            options2.removeAll();
            options2.add(dataValue);
            options2.add(numValue);
            options2.add(dataName);
            options2.add(dataPointName);
            options2.add(dataClass);
            options2.add(dataPointNameAlt);
            options2.add(addBar);
            options2.revalidate();
            options2.repaint();
            bottomPane.add(clearChart);
            content.repaint();
            chartHolder.repaint();

        }
        else if(e.getSource()==scatterPlot){
            chartGenerator = ChartFactory.createScatterPlot(graphTitle.getText(),xAxisTitle.getText(),yAxisTitle.getText(),generalGraphData);
            chartHolder.setChart(chartGenerator);
            options2.removeAll();
            options2.add(xCoordValue);
            options2.add(numValue);
            options2.add(yCoordValue);
            options2.add(numValueAlt);
            options2.add(dataName);
            options2.add(dataPointName);
            options2.add(replaceSeries);
            options2.revalidate();
            options2.repaint();
            bottomPane.add(clearChart);
            content.repaint();
            chartHolder.repaint();
        }
        else if(e.getSource()==lineGraph){
            chartGenerator = ChartFactory.createXYLineChart(graphTitle.getText(),xAxisTitle.getText(),yAxisTitle.getText(),generalGraphData);
            chartHolder.setChart(chartGenerator);
            options2.removeAll();
            options2.add(xCoordValue);
            options2.add(numValue);
            options2.add(yCoordValue);
            options2.add(numValueAlt);
            options2.add(dataName);
            options2.add(dataPointName);
            options2.add(replaceSeries);
            options2.revalidate();
            options2.repaint();
            bottomPane.add(clearChart);
            content.repaint();
            chartHolder.repaint();
        }
        else if(e.getSource()== addSlice){
            generalPieData.setValue(dataPointName.getText(),Integer.valueOf(numValue.getText()));
            chartHolder.repaint();
        }
        else if (e.getSource()== clearChart){
            generalPieData.clear();
            generalBarData.clear();
            for(int i=0; i<graphSeries.size();i++){
                generalGraphData.removeSeries(graphSeries.get(i));
            }
            graphSeries.clear();
            chartHolder.repaint();
        }
        else if(e.getSource()==addBar){
            generalBarData.addValue(Integer.valueOf(numValue.getText()),dataPointNameAlt.getText(),dataPointName.getText());
            chartHolder.repaint();
        }
        else if(e.getSource()==replaceSeries){
            String xData = numValue.getText();
            String yData= numValueAlt.getText();
            String[] xDataPrc = xData.split(",");
            String[] yDataPrc = yData.split(",");
            double[][] processedCoords = new double[2][xDataPrc.length];
            for(int i=0;i< xDataPrc.length;i++){
                processedCoords[0][i] = Double.parseDouble(xDataPrc[i]);
                processedCoords[1][i] = Double.parseDouble(yDataPrc[i]);
            }
            graphSeries.add(dataPointName.getText());
            generalGraphData.addSeries(dataPointName.getText(),processedCoords);
            chartHolder.repaint();
        }
    }
}
