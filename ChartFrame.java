import javax.swing.*;
import java.awt.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

class ChartFrame extends JFrame
{
Container c;
int sub1,sub2,sub3;
String name;

JButton btnSave,btnBack;

HbOpChart h = new HbOpChart();
ChartFrame()
{

JFreeChart chart = ChartFactory.createBarChart("Student Performance","Subjects","Marks",h.ds,PlotOrientation.VERTICAL,true,false,false);

ChartPanel p = new ChartPanel(chart);
setContentPane(p);
//c = getContentPane();
//c.setLayout(new FlowLayout());
//c.add(p);


setTitle("Students Performance");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}